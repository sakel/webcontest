<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes-dynattr.tld"%>

<%@ include file="header.jsp"%>

<article id="pageBody" class="container">
	<div class="col-md-6 col-md-offset-2">
		<h2 id="formFrameTitle">
			<fmt:message key="conference.title"  />
		</h2>
	</div>
	<aside class="col-md-offset-2 col-md-8">
		<div class="panel panel-default">
			<!-- Table -->
			<table class="table fixedtable">
				<tr>
					<th><fmt:message key='confdetail.label'  /></th>
					<th><fmt:message key='confdetail.value'  /></th>
				</tr>
				<tr class="conferences">
					<td><label><fmt:message key='conf.start'  /></label></td>
					<td><fmt:formatDate value="${actionBean.conference.start}" type="date" pattern="${dateformat}"/></td>
				</tr>

				<tr class="conferences">
					<td><label><fmt:message key='conf.title'  /></label></td>
					<td>${fn:escapeXml(actionBean.conference.title)}</td>
				</tr>
				<tr class="conferences">
					<td><label><fmt:message key='conf.description'  /></label></td>
					<td>${fn:escapeXml(actionBean.conference.description)}</td>
				</tr>
				<tr class="conferences">
					<td><label><fmt:message key='conf.location'  /></label></td>
					<td>${fn:escapeXml(actionBean.conference.location)}</td>
				</tr>
				<tr class="conferences">
					<td><label><fmt:message key='conf.duration'  /></label></td>
					<td>${actionBean.conference.duration}days</td>
				</tr>
				<tr class="conferences">
					<td><label><fmt:message key='conf.maxattendees'  /></label></td>
					<td>${actionBean.conference.maxAttendees}</td>
				</tr>
				<tr class="conferences">
					<td><label><fmt:message key='conf.regdeadline'  /></label></td>
					<td><fmt:formatDate value="${actionBean.conference.registrationDeadline}" type="date" pattern="${dateformat}"/></td>
				</tr>
				<tr class="conferences">
					<td><label><fmt:message key='conf.fee' /></label></td>
					<td>${actionBean.conference.fee}</td>
				</tr>
				<tr class="conferences">
					<td><label><fmt:message key='conf.tags' /></label></td>
					<td>${fn:escapeXml(actionBean.conference.tags)}</td>
				</tr>
			</table>
		</div>
	</aside>
	<aside class="col-md-offset-2 col-md-8">
		<a role="button" href="conferences" class="btn btn-default"><fmt:message key="button.back"  /></a>
	</aside>
</article>

<%@ include file="footer.jsp"%>
