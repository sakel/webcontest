<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes-dynattr.tld" %>

<%@ include file="header.jsp"%>

<article id="pageBody" class="container">
	<div class="col-md-6 col-md-offset-2">
		<h2 id="formFrameTitle">
			<fmt:message key="conferences.title" />
		</h2>
	</div>
	<aside class="col-md-offset-2 col-md-8">
		<stripes:form beanclass="org.zabica.webcontest.stripes.actions.WebContestActionBean" method="post" class="form-horizontal">
			<div class="input-group">
				<span class="input-group-addon">
					<span class="fa fa-tag"></span>
				</span>
			
				<input name="tags" type="text" class="form-control" placeholder="<fmt:message key="conf.tags" />" />
				<span class="input-group-addon">
					<span class="fa fa-calendar"></span>
				</span>
				
				<stripes:text name="date" class="form-control" formatType="date" formatPattern="${dateformat}" role="datepicker" placeholder="${dateformat}"></stripes:text>
    			<span class="input-group-addon searchButton">
					<button type="submit" name="conferences" class="searchButton">
						<span class="fa fa-search"></span>
					</button>
				</span>
				<span class="input-group-addon">
					<stripes:link beanclass="org.zabica.webcontest.stripes.actions.WebContestActionBean" event="addconference" class="contesticon">
						<span class="fa fa-plus"></span>
					</stripes:link>
				</span>
			</div>
		</stripes:form>
		<div class="btn-toolbar" role="toolbar"></div>
	</aside>
	<aside class="col-md-offset-2 col-md-8">
		<div class="panel panel-default">
			
			<!-- Table -->
			<table class="table fixedtable">
				<tr>
					<th><fmt:message key='conf.start' /></th>
					<th><fmt:message key='conf.title' /></th>
					<th><fmt:message key='conf.description' /></th>
					<th><fmt:message key='conf.location' /></th>
				</tr>
				<c:forEach items="${actionBean.conferences}" var="conference">
					<stripes:url beanclass="org.zabica.webcontest.stripes.actions.WebContestActionBean" event="conference" var="confurl">
						<stripes:param name="confid">${conference.id}</stripes:param>
					</stripes:url>
					<tr class="conferences mouseover" onclick="location.href='${confurl}';">
						<td><fmt:formatDate value="${conference.start}" type="date" pattern="${dateformat}"/></td>
						<td>${fn:escapeXml(conference.title)}</td>
						<td>${fn:escapeXml(conference.description)}</td>
						<td>${fn:escapeXml(conference.location)}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</aside>
</article>

<%@ include file="footer.jsp"%>
