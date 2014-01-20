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
			<h2 id="formFrameTitle">Login</h2>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<form:form action="/springmvc/webcontest/login" commandName="loginform" method="post" class="form-horizontal" role="form">
				<div class="form-group">
					<label for="email" class="col-sm-4 control-label">Email</label>
					<div class="col-sm-8">
						<form:input path="email"/>
						<input type="email" class="form-control" id="email" placeholder="Email" name="email">
						<form:errors path="email" />
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-4 control-label">Password</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-8">
						<button type="submit" class="btn btn-default">Sign in</button>
					</div>
				</div>
			</form:form>
		</div>
	</aside>

</article>

<%@ include file="footer.jsp"%>
