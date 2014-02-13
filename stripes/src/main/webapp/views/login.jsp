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
			<h2 id="formFrameTitle">
				<fmt:message key="login.title" />
			</h2>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<stripes:form beanclass="org.zabica.webcontest.stripes.actions.WebContestActionBean" method="post" class="form-horizontal">
				<div class="form-group">
					<stripes:label class="col-sm-4 control-label" for="email">
						<fmt:message key="login.email" />
					</stripes:label>
					<div class="col-sm-8">
						<stripes:text class="form-control" id="email" name="email" />
					</div>
				</div>
				<c:if test="${stripes:hasErrors(actionBean, 'email')}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">
								<stripes:errors field="email">
									<stripes:individual-error />
								</stripes:errors>
							</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<stripes:label class="col-sm-4 control-label" for="password">
						<fmt:message key="login.password" />
					</stripes:label>
					<div class="col-sm-8">
						<stripes:password class="form-control" id="password" name="password" />
					</div>
				</div>
				<c:if test="${stripes:hasErrors(actionBean, 'password')}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">
								<stripes:errors field="password">
									<stripes:individual-error />
								</stripes:errors>
							</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-2">
						<stripes:submit name="doLogin" class="btn btn-default">
							<fmt:message key="login.submit" />
						</stripes:submit>
					</div>
					<div class="col-sm-1 or">
						<fmt:message key="login.or" />
					</div>
					<div class="col-sm-2">
						<stripes:link beanclass="org.zabica.webcontest.stripes.actions.WebContestActionBean" event="register" class="btn btn-default" ><fmt:message key="login.register" /></stripes:link>
					</div>
				</div>
			</stripes:form>
		</div>
	</aside>

</article>

<%@ include file="footer.jsp"%>
