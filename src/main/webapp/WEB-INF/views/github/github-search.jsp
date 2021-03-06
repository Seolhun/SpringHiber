<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<spring:url value="/resources" var="resources"/>
<spring:url value="/resources/template" var="template"/>
<tag:layout tab="${target}">
    <div class="bg-color-ocean-g">
        <div class="container">
            <div class="row">
                <div class="ocean-title col-sm-8">
                    <p>GitHub API와 D3를 통해 데이터시각화를 사용합니다</p>
                </div>
                <sec:authorize access="hasRole('SUPERADMIN')">
                    <div class="col-sm-4">

                    </div>
                </sec:authorize>
            </div>
        </div>
    </div>


    <!--=== End Call To Action ===-->
    <div class="container content-xs">
        <div class="row service-box-v1">
            <div class="col-sm-4 col-xs-12" id="sizeDiv">
                <div class="row">
                    <div class="col-sm-6">
                        <div> Min Size</div>
                        <input name="minSize" class="form-control2 width-100 margin-bottom-10"
                               placeholder="Insert Min Size you want to search">
                    </div>
                    <div class="col-sm-6">
                        <div> Max Size</div>
                        <input name="maxSize" class="form-control2 width-100 margin-bottom-10"
                               placeholder="Insert Max Size you want to search">
                    </div>
                    <hr>
                </div>
            </div>
            <div class="col-sm-4 col-xs-12" id="startsDiv">
                <div class="row">
                    <div class="col-sm-6">
                        <div> Min Stars</div>
                        <input name="minStar" class="form-control2 width-100 margin-bottom-10"
                               placeholder="Insert Min Stars you want to search">
                    </div>
                    <div class="col-sm-6">
                        <div> Max Stars</div>
                        <input name="maxStart" class="form-control2 width-100 margin-bottom-10"
                               placeholder="Insert Max Stars you want to search">
                    </div>
                    <hr>
                </div>
            </div>
            <div class="col-sm-4 col-xs-12" id="forksDiv">
                <div class="row">
                    <div class="col-sm-6">
                        <div> Min Forks</div>
                        <input name="minForks" class="form-control2 width-100 margin-bottom-10"
                               placeholder="Insert Min Forks you want to search">
                    </div>
                    <div class="col-sm-6">
                        <div> Max Forks</div>
                        <input name="maxForks" class="form-control2 width-100 margin-bottom-10"
                               placeholder="Insert Max Forks you want to search">
                    </div>
                    <hr>
                </div>
            </div>
        </div>

        <div class="row service-box-v1">
            <div class="col-sm-12 col-xs-12">
                <div> Repository Name</div>
                <input name="repoName" class="form-control2 width-100 margin-bottom-10"
                       placeholder="Insert Repository Name you want to search (example : blog, hompage, ...)">

                <div> Language</div>
                <input name="language" class="form-control2 width-100 margin-bottom-10"
                       placeholder="Insert Language you want to search (example : python, java, ...)">

                <div> Topic</div>
                <input name="topic" class="form-control2 width-100 margin-bottom-10"
                       placeholder="Insert Topic you want to search (example : java, spring, ...)">
            </div>

            <div class="col-sm-12 col-xs-12 margin-bottom-10 text-center">
                <select name="searchType">
                    <option value="/repositories">Repositories</option>
                        <%--
                        <c:forEach items="${searchTypes}" var="searchType">
                            <option value="${searchType.type}">${searchType.name}</option>
                        </c:forEach>
                        --%>
                </select>
                <select name="searchOrder">
                    <c:forEach items="${searchOptions}" var="option">
                        <option value="${option.type}">${option.name}</option>
                    </c:forEach>
                </select>
                <input type="button" class="btn-u btn-u-ocean" onclick="GithubService.githubSearch()" value="검색하기">
            </div>
            <div class="text-center" id="searchResultPaging">

            </div>
        </div>

        <div class="row service-block service-block-default">
            <div class="col-sm-12 col-xs-12">
                <div class="text-left" id="searchResult">

                </div>
            </div>
        </div>
    </div>
</tag:layout>
<script type="text/javascript" src="${resources}/js/github/github-module.js"></script>
<script type="text/javascript" src="${resources}/js/github/github-search.js"></script>