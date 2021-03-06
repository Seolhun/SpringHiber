<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<spring:url value="/resources" var="resources"/>
<spring:url value="/resources/template" var="template"/>
<spring:url value="/myinfo" var="myinfo"/>
<spring:url value="/po" var="po"/>
<tag:layout tab="${target}">
    <div class="bg-color-ocean-g">
        <div class="container">
            <div class="row">
                <div class="ocean-title col-sm-8">
                    <p>Admin Stack Manager</p>
                </div>
                <sec:authorize access="hasRole('SUPERADMIN')">
                    <div class="col-sm-4 text-right">
                        <input type="text" name="stackName" class="input" placeholder="Insert Stack Name" value="ruby"/>
                        <button class="btn-u btn-u-green rounded" onclick="AdminStackService.stackInsert()">저장</button>
                        <button class="btn-u btn-u-green rounded" onclick="AdminStackService.stackListInsert()">리스트 저장
                        </button>
                    </div>
                </sec:authorize>
            </div>
        </div>
    </div>

    <div class="container content-xs">
        <div class="row">
            <div class="col-sm-12">
                <div class="row service-box-v1">
                    <div class="col-sm-12 no-margin-bottom">
                        <div class="service-block service-block-default">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</tag:layout>
<script type="text/javascript" src="${resources}/js/stack/admin-stack-module.js"></script>