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
			<spring:message code="conference.title" text="Login" />
		</h2>
	</div>
	<aside class="col-md-offset-2 col-md-8">
		<div class="panel panel-default">
			<!-- Table -->
			<table class="table">
				<tr>
					<th><spring:message code='confdetail.label' text='Label' /></th>
					<th><spring:message code='confdetail.value' text='Value' /></th>
				</tr>
				<tr class="conferences">
					<td><label><spring:message code='conf.start' text='Start date' /></label></td>
					<td><spring:eval expression="conference.start" /></td>
				</tr>

				<tr class="conferences">
					<td><label><spring:message code='conf.title' text='Title' /></label></td>
					<td>${conference.title}</td>
				</tr>
				<tr class="conferences">
					<td><label><spring:message code='conf.description' text='Description' /></label></td>
					<td>${conference.description}</td>
				</tr>
				<tr class="conferences">
					<td><label><spring:message code='conf.location' text='Location' /></label></td>
					<td>${conference.location}</td>
				</tr>
				<tr class="conferences">
					<td><label><spring:message code='conf.duration' text='Duration' /></label></td>
					<td>${conference.duration}days</td>
				</tr>
				<tr class="conferences">
					<td><label><spring:message code='conf.maxattendees' text='Max attendees' /></label></td>
					<td>${conference.maxAttendees}</td>
				</tr>
				<tr class="conferences">
					<td><label><spring:message code='conf.regdeadline' text='Registration Deadline' /></label></td>
					<td>${conference.registrationDeadline}</td>
				</tr>
				<tr class="conferences">
					<td><label><spring:message code='conf.fee' text='Fee' /></label></td>
					<td><spring:eval expression="conference.fee" /></td>
				</tr>
				<tr class="conferences">
					<td><label><spring:message code='conf.tags' text='Tags' /></label></td>
					<td>${conference.tags}</td>
				</tr>
			</table>
		</div>
	</aside>
	<aside class="col-md-offset-2 col-md-8">
		<a role="button" href="conferences" class="btn btn-default"><spring:message code="button.back" text="Back" /></a>
	</aside>
</article>

<%@ include file="footer.jsp"%>
