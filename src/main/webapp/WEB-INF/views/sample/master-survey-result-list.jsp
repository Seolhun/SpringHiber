<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<body data-ng-app="SurveyResultApp" data-ng-controller="SurveyResultCtrl">
	<div id="page-wrapper">
		<!-- 사이드바 -->
		<!-- /사이드바 -->
		<!-- 본문 -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<h3>설문 결과 관리 페이지</h3>
				<form class="navbar-search pull-left">
					설문지 결과 : 
					<input type="text" class="search-query" placeholder="검색">
					<input id="searchButton" name="searchButton" type="button" value="검색" />
				</form>

				<form id="userListForm" name="userListForm" method="post">
					
				</form>
				<div class="row" data-ng-repeat="survey in surveys">
					<div class="col-sm-1">
						{{survey.surveyId}}
					</div>
					<div class="col-sm-1">
						{{survey.surveyId}}
					</div>
					<div class="col-sm-1">
						{{survey.surveyId}}
					</div>
					<div class="col-sm-1">
						{{survey.surveyId}}
					</div>
				</div>
			</div>
		</div>
		<!-- /본문 -->
	</div>
</body>
</html>