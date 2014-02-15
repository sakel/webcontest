<%@page import="java.util.Enumeration"%>
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
			<h2 id="formFrameTitle"><spring:message code="login.title" text="Login"/></h2>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<form:form action="/springmvc/webcontest/login" commandName="userLogin" method="post" class="form-horizontal" role="form">
				<div class="form-group">
					<form:label path="email" cssClass="col-sm-4 control-label"><spring:message code="login.email" text="E-mail"/></form:label>
					<div class="col-sm-8">
						<input type="email" class="form-control" id="email" placeholder="<spring:message code='login.email' text='E-mail'/>" name="email" value="${userLogin.email}"/>
					</div>
				</div>
				<c:if test="${errors.email != null}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">${errors.email}</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<label for="password" class="col-sm-4 control-label"><spring:message code="login.password" text="Password"/></label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="password" placeholder="<spring:message code='login.password' text='Password'/>" name="password" />
					</div>
				</div>
				<c:if test="${errors.password != null}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">${errors.password}</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-2">
						<button type="submit" class="btn btn-default"><spring:message code="login.submit" text="Sign in"/></button>
					</div>
					<div class="col-sm-1 or">
						<spring:message code="login.or" text="or"/>
					</div>
					<div class="col-sm-2">
						<a role="button" href="${contextpath}/webcontest/register" class="btn btn-default"><spring:message code="login.register" text="Register"/></a>
					</div>
				</div>
			</form:form>
		</div>
	</aside>

</article>

<%@ include file="footer.jsp"%>
