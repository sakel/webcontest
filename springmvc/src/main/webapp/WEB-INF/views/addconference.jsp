<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="header.jsp"%>

<article id="pageBody" class="container">
	<aside id="loginFrame" class="row">
		<div class="col-md-6 col-md-offset-3">
			<h2 id="formFrameTitle"><spring:message code="addconf.formtitle" text="Add conference"/></h2>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<form:form action="/springmvc/webcontest/addconference" commandName="conference" method="post" class="form-horizontal" role="form">
				<div class="form-group">
					<label for="title" class="col-sm-4 control-label"><spring:message code='conf.title' text='Title'/></label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="title" placeholder="<spring:message code='conf.title' text='Title'/>" name="title" />
					</div>
				</div>
				<c:if test="${errors.title != null}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">${errors.title}</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<label for="description" class="col-sm-4 control-label"><spring:message code='conf.description' text='Description'/></label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="description" placeholder="<spring:message code='conf.description' text='Description'/>" name="description" />
					</div>
				</div>
				<c:if test="${errors.description != null}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">${errors.description}</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<label for="start" class="col-sm-4 control-label"><spring:message code='conf.start' text='Start'/></label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="start" placeholder="<spring:message code='date.format' text='mm/dd/yyyy'/>" name="start" />
					</div>
				</div>
				<c:if test="${errors.start != null}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">${errors.start}</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<label for="duration" class="col-sm-4 control-label"><spring:message code='conf.duration' text='Duration'/></label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="duration" placeholder="<spring:message code='conf.duration' text='Duration'/>" name="duration" />
					</div>
				</div>
				<c:if test="${errors.duration != null}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">${errors.duration}</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<label for="registrationDeadline" class="col-sm-4 control-label"><spring:message code='conf.regdeadline' text='Registration open untill'/></label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="registrationDeadline" placeholder="<spring:message code='date.format' text='mm/dd/yyyy'/>" name="registrationDeadline" />
					</div>
				</div>
				<c:if test="${errors.registrationDeadline != null}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">${errors.registrationDeadline}</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<label for="maxAttendees" class="col-sm-4 control-label"><spring:message code='conf.maxattendees' text='Max attendees'/></label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="maxAttendees" placeholder="<spring:message code='conf.maxattendees' text='Max attendees'/>" name="maxAttendees" />
					</div>
				</div>
				<c:if test="${errors.maxAttendees != null}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">${errors.maxAttendees}</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<label for="fee" class="col-sm-4 control-label"><spring:message code='conf.fee' text='Fee'/></label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="fee" placeholder="<spring:message code='conf.fee' text='Fee'/>" name="fee" />
					</div>
				</div>
				<c:if test="${errors.fee != null}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">${errors.fee}</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<label for="location" class="col-sm-4 control-label"><spring:message code='conf.location' text='Location'/></label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="location" placeholder="<spring:message code='conf.location' text='Location'/>" name="location" />
					</div>
				</div>
				<c:if test="${errors.location != null}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">${errors.location}</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<label for="tags" class="col-sm-4 control-label"><spring:message code='conf.tags' text='Tags'/></label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="tags" placeholder="<spring:message code='conf.tags' text='Tags'/>" name="tags" />
					</div>
				</div>
				<c:if test="${errors.tags != null}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">${errors.tags}</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-2">
						<button type="submit" class="btn btn-default"><spring:message code='addconf.submit' text='Submit'/></button>
					</div>
				</div>
			</form:form>
		</div>
	</aside>
</article>

<%@ include file="footer.jsp"%>
