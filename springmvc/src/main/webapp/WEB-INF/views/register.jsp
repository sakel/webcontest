<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<%@ include file="header.jsp"%>

<article id="pageBody" class="container">

<aside id="registrationFrame">
			<div class="col-md-6 col-md-offset-3">
				<h2 id="formFrameTitle">Registration</h2>
			</div>
			<div class="col-md-6 col-md-offset-3">
				<form action="/springmvc/webcontest/register" method="post" class="form-horizontal" role="form">
					<div class="form-group">
						<label for="name" class="col-sm-4 control-label">Name</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="name" placeholder="Name" name="name">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="alert alert-danger">You should enter some data</div>
						</div>
					</div>

					<div class="form-group">
						<label for="surname" class="col-sm-4 control-label">Surname</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="surname" placeholder="Surname" name="surname">
						</div>
					</div>

					<div class="form-group">
						<label for="email" class="col-sm-4 control-label">Email</label>
						<div class="col-sm-8">
							<input type="email" class="form-control" id="email" placeholder="Email" name="email">
						</div>
					</div>

					<div class="form-group">
						<label for="password" class="col-sm-4 control-label">Password</label>
						<div class="col-sm-8">
							<input type="password" class="form-control" id="password" placeholder="Password" name="password">
						</div>
					</div>

					<div class="form-group">
						<label for="repeatPassword" class="col-sm-4 control-label">Repeat password</label>
						<div class="col-sm-8">
							<input type="password" class="form-control" id="repeatPassword" placeholder="Password" name="repeatPassword">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<button type="submit" class="btn btn-default">Sign in</button>
						</div>
					</div>
				</form>
			</div>
		</aside>

</article>

<%@ include file="footer.jsp"%>
