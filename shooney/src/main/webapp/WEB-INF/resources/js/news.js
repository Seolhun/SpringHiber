/* Write here your custom javascript codes */
var root="/shooney";
var csrfHeader=$("#csrfHeader").attr("content");
var	csrfToken=$("#csrfToken").attr("content");

/* AJAX 통신 처리 */
var NewsAngularModule = angular.module('NewsAngularModule', []);
NewsAngularModule.controller('NewsAngularController', function ($scope, $http) {
	getNewsList();
	
	function getNewsList(){
		$http({
			method : 'GET', // 방식
			url : root +"/news/list-json", /* 통신할 URL */
			headers : {
				"Content-Type" : "application/json; charset=utf-8",
				csrfHeader : csrfToken
			}
	    }).then(function (response){
	    	console.log("Success");
	    	var responseData=response.data;
	    	
	    	var newsList=responseData.newsDatas.content;
	    	var paging=responseData.paging;
	    	
	    	$scope.newsList=newsList;
	    	$scope.paging=paging;
	    	
	    	//Ajax결과 출력    	
	    	newsList.forEach(function(data, index, status){
//	    		console.log(data);
	    	})
	    },function (error){
	    	console.log("Error"+error);
	    });
	}
});

var NewsModule=(function(){
	var _saveNews = function() {
		var newsNumber=$("#newsNumber").val();
		$.ajax({
			url : root +"/news/save/"+newsNumber,
			timeout : 60000,
			beforeSend: function(xhr) {
                 xhr.setRequestHeader("Accept", "application/json");
                 xhr.setRequestHeader("Content-Type", "application/json");
                 xhr.setRequestHeader(csrfHeader, csrfToken);
			}, success: function(data) {
				if(data.result=="success"){
					console.log('Success');
				} else {
					console.log('Fail');
				}
			},
			error : function(e){
				console.log('Error');
			}
		});	
	};
	
	var saveNews = function() {
		_saveNews();
	};
	
	var _stopNews = function() {
		$.ajax({
			url : root +"/news/stop",
			timeout : 60000,
			beforeSend: function(xhr) {
                 xhr.setRequestHeader("Accept", "application/json");
                 xhr.setRequestHeader("Content-Type", "application/json");
                 xhr.setRequestHeader(csrfHeader, csrfToken);
			}, success: function(data) {
				if(data.result=="success"){
					console.log('Success');
				} else {
					console.log('Fail');
				}
			},
			error : function(e){
				console.log('Error');
			}
		});
	};
	
	var stopNews = function() {
		_stopNews();
	};
	
	var _getNewsDetail = function(){
		var newsNumber=$("#newsNumber").val();
		console.log("newsNumber : "+newsNumber);
		$.ajax({
			url : root +"/news/detail/"+newsNumber,
			timeout : 60000,
			beforeSend: function(xhr) {
                 xhr.setRequestHeader("Accept", "application/json");
                 xhr.setRequestHeader("Content-Type", "application/json");
                 xhr.setRequestHeader(csrfHeader, csrfToken);
			}, success: function(data) {
				if(data){
					console.log(data);
				} else {
					console.log('Fail');
				}
			},
			error : function(e){
				console.log('Error');
			}
		});
	} 
	
	var getNewsDetail = function(){
		_getNewsDetail();
	} 
	
	return {
		stopNews : stopNews,
		saveNews : saveNews,
		getNewsDetail : getNewsDetail
	};
})();