<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextpath" value="${requestScope['javax.servlet.forward.context_path']}" />
<c:if test="${not empty pageContext.request.queryString}">
	<c:set var="querystring" value="?${pageContext.request.queryString}" />
	
</c:if>

<spring:message code="date.format" text="dd.MM.yyyy" var="dateformat"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${contextpath}/static/datepicker.css" media="screen" />
<link rel="stylesheet" type="text/css" href="${contextpath}/static/bootstrap.css" media="screen" />
<link rel="stylesheet" type="text/css" href="${contextpath}/static/font-awesome.css" media="screen" />
<link rel="stylesheet" type="text/css" href="${contextpath}/static/style.css" media="screen" />
<script src="${contextpath}/static/jquery-1.11.0.js"></script>
<script src="${contextpath}/static/bootstrap-datepicker.js"></script>
<title>WebContest</title>
</head>
<body>
	<header id="pageHeader" class="page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-11">
					<h1>WebContest</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-8 col-md-1">
				&nbsp;&nbsp;
				</div>
				<c:if test="${sessionScope['scopedTarget.userSession'].loggedIn}">
					<div class="col-md-2">
						<c:url value="setlanguage" var="returnurl">
							<c:param name="locale" value="sl_SI"/>
							<c:param name="source" value="${requestScope['javax.servlet.forward.servlet_path']}${querystring}"/>
						</c:url>
						<a href="${returnurl}"><img class="langflag" alt="Slovensko" src="${contextpath}/static/slo.png" /></a>
						<c:url value="setlanguage" var="returnurl">
							<c:param name="locale" value="en_US"/>
							<c:param name="source" value="${requestScope['javax.servlet.forward.servlet_path']}${querystring}"/>
						</c:url>
						<a href="${returnurl}"><img class="langflag" alt="English" src="${contextpath}/static/usa.png" /></a>
					</div>
					<div class="col-md-1">
						<a href="logout"><spring:message code="header.logout" text="Logout"/></a>
					</div>
				</c:if>
			</div>
		</div>
	</header>
