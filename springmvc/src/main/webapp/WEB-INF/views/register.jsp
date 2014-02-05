<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="header.jsp"%>

<article id="pageBody" class="container">
	<aside id="registrationFrame">
		<div class="col-md-6 col-md-offset-3">
			<h2 id="formFrameTitle"><spring:message code='register.title' text='Registration'/></h2>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<form:form action="/springmvc/webcontest/register" commandName="registration" method="post" class="form-horizontal" role="form">
				<div class="form-group">
					<label for="name" class="col-sm-4 control-label"><spring:message code='register.name' text='Name'/></label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="name" placeholder="<spring:message code='register.name' text='Name'/>" name="name" value="${registration.name}">
					</div>
				</div>
				<c:if test="${errors.name != null}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">${errors.name}</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<label for="surname" class="col-sm-4 control-label"><spring:message code='register.surname' text='Surname'/></label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="surname" placeholder="<spring:message code='register.surname' text='Surname'/>" name="surname" value="${registration.surname}">
					</div>
				</div>
				<c:if test="${errors.surname != null}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">${errors.surname}</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<label for="email" class="col-sm-4 control-label"><spring:message code='register.email' text='E-mail'/></label>
					<div class="col-sm-8">
						<input type="email" class="form-control" id="email" placeholder="<spring:message code='register.email' text='E-mail'/>" name="email" value="${registration.email}">
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
					<label for="password" class="col-sm-4 control-label"><spring:message code='register.password' text='Password'/></label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="password" placeholder="<spring:message code='register.password' text='Password'/>" name="password" value="${registration.password}">
					</div>
				</div>
				<c:if test="${errors.name != password}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">${errors.password}</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<label for="repeatPassword" class="col-sm-4 control-label"><spring:message code='register.repassword' text='Password'/></label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="repeatPassword" placeholder="<spring:message code='register.repassword' text='Password'/>" name="repeatPassword" value="${registration.repeatPassword}">
					</div>
				</div>
				<c:if test="${errors.repeatPassword != null}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">${errors.repeatPassword}</div>
						</div>
					</div>
				</c:if>
				<c:if test="${errors.userRegistration != null}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">${errors.userRegistration}</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-8">
						<button type="submit" class="btn btn-default"><spring:message code='register.submit' text='Register'/></button>
					</div>
				</div>
				</form:form>
		</div>
	</aside>

</article>

<%@ include file="footer.jsp"%>
