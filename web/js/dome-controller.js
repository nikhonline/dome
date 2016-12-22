var app = angular.module("myApp", ["ngRoute","chart.js","ui.grid","ui.grid.edit","daterangepicker"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "home.html"
    })
    .when("/jira", {
        templateUrl : "jira.html"
    })
    .when("/zendesk", {
        templateUrl : "zendesk.html"
    })
    .when("/dba", {
        templateUrl : "dba.html"
    });
});
 
  
app.controller("HomeCtrl", function ($scope,$http) {
  //jira
   $scope.jira_unix_labels=["OPEN","WIP"];
   $scope.jira_unix_data=[];
   $scope.jira_web_labels=["OPEN","WIP"];
   $scope.jira_web_data=[];
   $scope.jira_win_labels=["OPEN","WIP"];
   $scope.jira_win_data=[];
   $scope.zendesk_piechart_labels = ["New", "Open", "Pending"];
   $scope.zendesk_piechart_data = [];
   
   var load=function(json,type,labels){
    var arr=json[0][type];
    for(var i=0;i<arr.length;++i){
        if(type==="jira"){
            if(arr[i]["team"]==="CSOUNIX"){
                $scope.jira_unix_data.push(arr[i]["open"]);
                $scope.jira_unix_data.push(arr[i]["wip"]);
            }
            if(arr[i]["team"]==="CSOWEB"){
                $scope.jira_web_data.push(arr[i]["open"]);
                $scope.jira_web_data.push(arr[i]["wip"]);
            }
            if(arr[i]["team"]==="CSOWIN"){
                $scope.jira_win_data.push(arr[i]["open"]);
                $scope.jira_win_data.push(arr[i]["wip"]);
            }
        }
        if(type==="zendesk"){
               $scope.zendesk_piechart_data.push(arr[i]["newTicket"]);
               $scope.zendesk_piechart_data.push(arr[i]["openTicket"]);
               $scope.zendesk_piechart_data.push(arr[i]["pendingTicket"]);
        }
    }
}  

  var jira=function(){
      $http.get('erp.do').success(function(response){
           load(response,"jira");
           load(response,"zendesk");
       });
  };
  

  jira();
  
  
  //$scope.jira_unix_labels = ["WIP", "Open"];
  //$scope.jira_unix_data = [300, 500];
  $scope.options = {legend: {showTooltips: true,display: true}};
  $scope.options_no_lables= {legend: {showTooltips: true,display: false}};
  //zendsek
  //$scope.zendesk_piechart_labels = ["New", "Open", "Pending"];
  //$scope.zendesk_piechart_data = [300, 500, 100,20];
  //zendsek ticket metrics
  $scope.zendesk_piechart_metrics_labels = ["New", "Open", "Pending","Closed"];
  $scope.zendesk_piechart_metrics_data = [300, 500, 100,20];
  //zendsek ticket metrics 2
  $scope.zendesk_barchart_labels = ["Incident", "None", "Problem","Questions","Task"];
  //$scope.zendesk_barchart_series = ["New","Open", "Closed"];
  $scope.zendesk_barchart_data = [[10, 20, 10,30,0],[10, 20, 30,0,0],[10, 20, 40,0,10]];
  

});

app.controller("jiraCtrl",function($scope,$http){

 $http.get("jira.do").success(function(data){
     $scope.jira_tickets_others=data["jiraRaw"];
     $scope.jira_snapshot=data["jiraSnapshot"];
 }).error(function(data){
     alert('error');
 });
 
})

app.controller("zendeskCtrl",function($scope,$http){
 $scope.datePicker = {startDate: '2016-12-01', endDate: '2016-12-11'};
 $http.get("zendesk.do").success(function(data){
     $scope.metrics_snapshot=data["zendeskSnapshot"];
     $scope.metrics_ticket_types=data["zendeskMetrics"];
     $scope.erp_as_requester=data["zendeskErpRequester"];
     console.log(JSON.stringify($scope.metrics_snapshot));
 }).error(function(data){
     alert('error');
 });
 //$scope.metrics_snapshot=JSON.parse("[{\"name\":\"Datta Manikanta\",\"new\":\"1\",\"open\":\"23\",\"pending\":\"2\",\"closed\":\"12\"},{\"name\":\"Dauphin\",\"new\":\"11\",\"open\":\"22\",\"pending\":\"22\",\"closed\":\"12\"}]");
 $scope.metrics_ticket_types=JSON.parse("[{\"name\":\"incident\",\"new\":\"1\",\"open\":\"23\",\"pending\":\"2\",\"closed\":\"12\"},{\"name\":\"problem\",\"new\":\"11\",\"open\":\"22\",\"pending\":\"22\",\"closed\":\"12\"}]");
 $scope.erp_as_requester=JSON.parse("[{\"name\":\"Datta Manikanta\",\"new\":\"1\",\"open\":\"23\",\"pending\":\"2\",\"closed\":\"12\"},{\"name\":\"Dauphin\",\"new\":\"11\",\"open\":\"22\",\"pending\":\"22\",\"closed\":\"12\"}]");

})

app.controller("dbaCtrl",function($scope){
    $scope.options = {legend: {showTooltips: true,display: true}};
    $scope.created_resolved_labels=["Jan-16", "Feb-16", "Mar-16","Apr-16","May-16","Jun-16","Jul-16","Aug-16",,"Sep-16","Oct-16","Nov-16"];
    $scope.created_resolved_data=[[644, 739, 766,720,732,657,642,773,614,601,618],[616,718,764,672,744,673,726,788,650,574,629]];
    $scope.created_resolved_series = ["Created","Resolved"];
    
    $scope.dba_users_labels=["Jun-16", "Jul-16", "Aug-16","Sep-16","Oct-16","Nov-16","Dec-16"];
    $scope.dba_users_data=[[10, 20, 10,30,20,15,25],[10, 20, 30,25,5,45]];
    $scope.dba_users_series = ["User","DBA"];
    
    $scope.rootcause_incident_labels=["Jan-16", "Feb-16", "Mar-16","Apr-16","May-16","Jun-16","Jul-16","Aug-16","Sep-16","Oct-16","Nov-16"];
    $scope.rootcause_incident_data=[[19,39,29,20,38,26,39,41,27,14,17],[26,19,36,13,28,41,44,42,21,9,25],[14,27,38,13,32,26,32,40,29,28,22],[24,33,26,3,16,14,10,18,9,5,3],[12,24,23,10,25,21,9,15,14,5,10],[18,21,34,6,6,12,9,10,15,9,8],[4,13,25,11,17,10,8,8,11,19,4],[6,7,13,7,9,6,9,0,1,3,4],[5,1,11,6,1,0,5,5,10,7,9],[4,4,9,1,3,0,6,9,4,11,1]];
    $scope.rootcause_incident_series = ["Replication Issue","File System Full","Process Failure","No Issue Found","Hardware Other","DB Config Change","User Error","Databse Bug","Bad Memory","Corruption"];
    
   // $scope.rootcause_incident_labels==["Jan-16", "Feb-16", "Mar-16"];
    //$scope.rootcause_incident_data=[[19,24,14]];
    //$scope.rootcause_incident_series = ["Replication Issue"];
  
  // Pie Chart
  $scope.jira_piechart_labels = ["Process Failure", "Hardware Other", "Bad Memory","User Error","Load Balancer Issue","Databse Bug","File System Full"];
  $scope.jira_piechart_data = [10, 30, 5,4,15,70];
  
  
  //Line Chart
  
  
  $scope.labels = ["Nov-16", "Oct-16", "Sep-16", "Aug-16", "Jul-16", "Jun-16", "May-16","Apr-16","Mar-16","Feb-16","Jan-16"];
  $scope.series = ['Mysql', 'Oracle','Vertica','Sybase','Mongo DB','Postgress','MSSQl','Netezza','Others','Redis','Ldap'];
  $scope.data = [
    [232, 236, 259, 316, 301, 321, 306,271,313,266,211],
    [90,116,97,123,118,101,111,131,131,124,133],
    [236,180,188,207,183,169,208,195,192,152,149],
    [20,19,45,44,13,25,30,17,35,45,28],
    [31,36,43,60,41,37,31,25,59,54,39],
    [18,20,30,35,44,39,48,24,33,53,49],
    [8,14,12,9,24,13,11,11,11,17,12],
    [14,10,12,14,12,18,10,5,8,12,7],
    [0,0,0,0,0,0,0,0,0,0,0],
    [3,1,7,4,2,3,3,2,3,3,1],
    [1,1,1,1,0,0,4,0,0,1,2]
  ];
  $scope.onClick = function (points, evt) {
    console.log(points, evt);
  };
  $scope.datasetOverride = [{ yAxisID: 'y-axis-1' }, { yAxisID: 'y-axis-2' }];
  $scope.lineoptions = {
    legend: {showTooltips: true,display: true}, 
    scales: {
      yAxes: [
        {
          id: 'y-axis-1',
          type: 'linear',
          display: true,
          position: 'left'
        },
        {
          id: 'y-axis-2',
          type: 'linear',
          display: true,
          position: 'right'
        }
      ]
    }
  };
})