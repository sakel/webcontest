<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>

<c:set var="contextpath" value="${requestScope['javax.servlet.forward.context_path']}" />
<c:if test="${not empty pageContext.request.queryString}">
	<c:set var="querystring" value="?${pageContext.request.queryString}" />
</c:if>

<fmt:setBundle basename="StripesResources"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${contextpath}/static/bootstrap.css" media="screen" />
<link rel="stylesheet" type="text/css" href="${contextpath}/static/font-awesome.css" media="screen" />
<link rel="stylesheet" type="text/css" href="${contextpath}/static/style.css" media="screen" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
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
				<c:if test="${actionBean.context.user != null}">
					<div class="col-md-2">
						<stripes:url beanclass="org.zabica.webcontest.stripes.actions.WebContestActionBean" event="setlanguage" var="returnurl">
							<stripes:param name="locale" value="sl_SI"/>
							<stripes:param name="source" value="${requestScope['javax.servlet.forward.servlet_path']}${querystring}"/>
						</stripes:url>
						<stripes:link href="${returnurl}" ><img class="langflag" alt="Slovensko" src="${contextpath}/static/slo.png" /></stripes:link>
						<stripes:url beanclass="org.zabica.webcontest.stripes.actions.WebContestActionBean" event="setlanguage" var="returnurl">
							<stripes:param name="locale" value="en_US"/>
							<stripes:param name="source" value="${requestScope['javax.servlet.forward.servlet_path']}${querystring}"/>
						</stripes:url>
						<stripes:link href="${returnurl}" ><img class="langflag" alt="English" src="${contextpath}/static/usa.png" /></stripes:link>
					</div>
					<div class="col-md-1">
						<stripes:link beanclass="org.zabica.webcontest.stripes.actions.WebContestActionBean" event="logout" ><fmt:message key="header.logout" /></stripes:link>
					</div>
				</c:if>
			</div>
		</div>
	</header>
