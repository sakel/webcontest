<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>

<%@ include file="header.jsp"%>

<article id="pageBody" class="container">
	<aside id="registrationFrame">
		<div class="col-md-6 col-md-offset-3">
			<h2 id="formFrameTitle">
				<fmt:message key='register.title' />
			</h2>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<stripes:form beanclass="org.zabica.webcontest.stripes.actions.WebContestActionBean" method="post" class="form-horizontal">
				<div class="form-group">
					<stripes:label class="col-sm-4 control-label" for="register.name">
						<fmt:message key="register.name" />
					</stripes:label>
					<div class="col-sm-8">
						<stripes:text class="form-control" id="register.name" name="register.name" />
					</div>
				</div>
				<c:if test="${stripes:hasErrors(actionBean, 'register.name')}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">
								<stripes:errors field="register.name">
									<stripes:individual-error />
								</stripes:errors>
							</div>
						</div>
					</div>
				</c:if>

				<div class="form-group">
					<stripes:label class="col-sm-4 control-label" for="register.surname">
						<fmt:message key="register.surname" />
					</stripes:label>
					<div class="col-sm-8">
						<stripes:text class="form-control" id="register.surname" name="register.surname" />
					</div>
				</div>
				<c:if test="${stripes:hasErrors(actionBean, 'register.surname')}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">
								<stripes:errors field="register.surname">
									<stripes:individual-error />
								</stripes:errors>
							</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<stripes:label class="col-sm-4 control-label" for="register.email">
						<fmt:message key="register.email" />
					</stripes:label>
					<div class="col-sm-8">
						<stripes:text class="form-control" id="register.email" name="register.email" />
					</div>
				</div>
				<c:if test="${stripes:hasErrors(actionBean, 'register.email')}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">
								<stripes:errors field="register.email">
									<stripes:individual-error />
								</stripes:errors>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${actionBean.alreadyExists}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">
								<fmt:message key="register.email.taken" />
							</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<stripes:label class="col-sm-4 control-label" for="register.password">
						<fmt:message key="register.password" />
					</stripes:label>
					<div class="col-sm-8">
						<stripes:password class="form-control" id="register.password" name="register.password" />
					</div>
				</div>
				<c:if test="${stripes:hasErrors(actionBean, 'register.password')}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">
								<stripes:errors field="register.password">
									<stripes:individual-error />
								</stripes:errors>
							</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<stripes:label class="col-sm-4 control-label" for="register.repeatPassword">
						<fmt:message key="register.repassword" />
					</stripes:label>
					<div class="col-sm-8">
						<stripes:password class="form-control" id="register.repeatPassword" name="register.repeatPassword" />
					</div>
				</div>
				<c:if test="${stripes:hasErrors(actionBean, 'register.repeatPassword')}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">
								<stripes:errors field="register.repeatPassword">
									<stripes:individual-error />
								</stripes:errors>
							</div>
						</div>
					</div>
				</c:if>
				<%-- 				<c:if test="${errors.userRegistration != null}">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-8">
							<div class="erroralert">${errors.userRegistration}</div>
						</div>
					</div>
				</c:if> --%>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-8">
						<stripes:submit name="doRegister" class="btn btn-default">
							<fmt:message key="register.submit" />
						</stripes:submit>
					</div>
				</div>
			</stripes:form>
		</div>
	</aside>

</article>

<%@ include file="footer.jsp"%>
