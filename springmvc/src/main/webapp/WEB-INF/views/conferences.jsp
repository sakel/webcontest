<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="header.jsp"%>

<article id="pageBody" class="container">
	<div class="col-md-6 col-md-offset-2">
		<h2 id="formFrameTitle">
			<spring:message code="conferences.title" text="Conferences" />
		</h2>
	</div>
	<aside class="col-md-offset-2 col-md-8">
		<form:form action="${contextpath}/webcontest/conferences" commandName="conffilter" method="post" class="form-horizontal" role="form">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="fa fa-tag"></span>
				</span>
				<input name="tags" type="text" class="form-control" />
				<span class="input-group-addon">
					<span class="fa fa-calendar"></span>
				</span>
				<input name="date" type="text" class="form-control" role="datepicker" />
				<span class="input-group-addon searchButton">
					<button type="submit" class="searchButton">
						<span class="fa fa-search"></span>
					</button>
				</span>
				<span class="input-group-addon">
					<a href="addconference" class="contesticon">
						<span class="fa fa-plus"></span>
					</a>
				</span>
			</div>
		</form:form>
		<div class="btn-toolbar" role="toolbar"></div>
	</aside>
	<aside class="col-md-offset-2 col-md-8">
		<div class="panel panel-default">
			<!-- Table -->
			<table class="table">
				<tr>
					<th><spring:message code='conf.start' text='Start' /></th>
					<th><spring:message code='conf.title' text='Name' /></th>
					<th><spring:message code='conf.description' text='Start' /></th>
					<th><spring:message code='conf.location' text='Location' /></th>
				</tr>
				<c:forEach items="${conferences}" var="conference">
					<tr class="conferences mouseover" onclick="location.href='${contextpath}/webcontest/conference?confid=${conference.id}';">
						<td><spring:eval expression="conference.start" /></td>
						<td>${conference.title}</td>
						<td>${conference.description}</td>
						<td>${conference.location}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</aside>
</article>

<%@ include file="footer.jsp"%>
