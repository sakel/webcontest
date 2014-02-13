<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>

<%@ include file="header.jsp"%>

<article id="pageBody" class="container">
	<aside id="loginFrame" class="row">
		<div class="col-md-6 col-md-offset-3">
			<h2 id="formFrameTitle"><fmt:message key="addconf.formtitle" /></h2>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<stripes:form beanclass="org.zabica.webcontest.stripes.actions.WebContestActionBean" method="post" class="form-horizontal">
				<div class="form-group">
					<stripes:label class="col-sm-4 control-label" for="conf.title">
						<%-- <fmt:message key="addconf.title" /> --%>
					</stripes:label>
					<div class="col-sm-8">
						<stripes:text class="form-control" id="conf.title" name="conference.title" />
					</div>
				</div>
				<c:if test="${stripes:hasErrors(actionBean, 'conference.title')}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">
								<stripes:errors field="conference.title">
									<stripes:individual-error />
								</stripes:errors>
							</div>
						</div>
					</div>
				</c:if>
				
				<div class="form-group">
					<stripes:label class="col-sm-4 control-label" for="conf.description">
						<fmt:message key="conf.description" />
					</stripes:label>
					<div class="col-sm-8">
						<stripes:text class="form-control" id="conf.description" name="conference.description" />
					</div>
				</div>
				<c:if test="${stripes:hasErrors(actionBean, 'conference.description')}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">
								<stripes:errors field="conference.description">
									<stripes:individual-error />
								</stripes:errors>
							</div>
						</div>
					</div>
				</c:if>
				
								<div class="form-group">
					<stripes:label class="col-sm-4 control-label" for="conf.start">
						<fmt:message key="conf.start" />
					</stripes:label>
					<div class="col-sm-5">
						<stripes:text class="form-control" id="conf.start" name="conference.start" />
					</div>
					<div class="col-sm-3">
						<fmt:message key="date.format" />
					</div>
				</div>
				<c:if test="${stripes:hasErrors(actionBean, 'conference.start')}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">
								<stripes:errors field="conference.start">
									<stripes:individual-error />
								</stripes:errors>
							</div>
						</div>
					</div>
				</c:if>
				
				<div class="form-group">
					<stripes:label class="col-sm-4 control-label" for="conf.duration">
						<fmt:message key="conf.duration" />
					</stripes:label>
					<div class="col-sm-8">
						<stripes:text class="form-control" id="conf.duration" name="conference.duration" />
					</div>
				</div>
				<c:if test="${stripes:hasErrors(actionBean, 'conference.duration')}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">
								<stripes:errors field="conference.duration">
									<stripes:individual-error />
								</stripes:errors>
							</div>
						</div>
					</div>
				</c:if>
				
				<div class="form-group">
					<stripes:label class="col-sm-4 control-label" for="conf.regdeadline">
						<fmt:message key="conf.regdeadline" />
					</stripes:label>
					<div class="col-sm-5">
						<stripes:text class="form-control" id="conf.regdeadline" name="conference.registrationDeadline" />
					</div>
					<div class="col-sm-3">
						<fmt:message key="date.format" />
					</div>
				</div>
				<c:if test="${stripes:hasErrors(actionBean, 'conference.registrationDeadline')}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">
								<stripes:errors field="conference.registrationDeadline">
									<stripes:individual-error />
								</stripes:errors>
							</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<stripes:label class="col-sm-4 control-label" for="conf.maxattendees">
						<fmt:message key="conf.maxattendees" />
					</stripes:label>
					<div class="col-sm-8">
						<stripes:text class="form-control" id="conf.maxattendees" name="conference.maxAttendees" />
					</div>
				</div>
				<c:if test="${stripes:hasErrors(actionBean, 'conference.maxAttendees')}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">
								<stripes:errors field="conference.maxAttendees">
									<stripes:individual-error />
								</stripes:errors>
							</div>
						</div>
					</div>
				</c:if>

				<div class="form-group">
					<stripes:label class="col-sm-4 control-label" for="conf.fee">
						<fmt:message key="conf.fee" />
					</stripes:label>
					<div class="col-sm-8">
						<stripes:text class="form-control" id="conf.fee" name="conference.fee" />
					</div>
				</div>
				<c:if test="${stripes:hasErrors(actionBean, 'conference.fee')}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">
								<stripes:errors field="conference.fee">
									<stripes:individual-error />
								</stripes:errors>
							</div>
						</div>
					</div>
				</c:if>

				<div class="form-group">
					<stripes:label class="col-sm-4 control-label" for="conf.location">
						<fmt:message key="conf.location" />
					</stripes:label>
					<div class="col-sm-8">
						<stripes:text class="form-control" id="conf.location" name="conference.location" />
					</div>
				</div>
				<c:if test="${stripes:hasErrors(actionBean, 'conference.location')}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">
								<stripes:errors field="conference.location">
									<stripes:individual-error />
								</stripes:errors>
							</div>
						</div>
					</div>
				</c:if>
				
				<div class="form-group">
					<stripes:label class="col-sm-4 control-label" for="conf.tags">
						<fmt:message key="conf.tags" />
					</stripes:label>
					<div class="col-sm-8">
						<stripes:text class="form-control" id="conf.tags" name="conference.tags" />
					</div>
				</div>
				<c:if test="${stripes:hasErrors(actionBean, 'conference.tags')}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">
								<stripes:errors field="conference.tags">
									<stripes:individual-error />
								</stripes:errors>
							</div>
						</div>
					</div>
				</c:if>

				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-2">
						<stripes:link beanclass="org.zabica.webcontest.stripes.actions.WebContestActionBean" event="conferences" class="btn btn-default" ><fmt:message key="button.back" /></stripes:link>
					</div>
					<div class="col-sm-2">
						<stripes:submit name="doAddConf" class="btn btn-default"><fmt:message key='addconf.submit' /></stripes:submit>
					</div>
				</div>
			</stripes:form>
		</div>
	</aside>
</article>

<%@ include file="footer.jsp"%>
