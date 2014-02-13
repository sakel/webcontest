<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>

<%@ include file="header.jsp"%>

<div>
	<fmt:message key="bla"/>
</div>

Users:
<ul>
<c:forEach items="${actionBean.users}" var="element"> 
	<li>${element.email}</li>
</c:forEach>
</ul>

Attributes:
<ul>
	<%Enumeration<String> attrs = request.getAttributeNames(); %>
	<%while(attrs.hasMoreElements()) {%>
		<li><%=attrs.nextElement() %></li>
	<%}%>
	
</ul>

Paths:

<ul>
<li>javax.servlet.forward.request_uri : ${requestScope['javax.servlet.forward.request_uri']}</li>
<li>javax.servlet.forward.context_path : ${requestScope['javax.servlet.forward.context_path']}</li>
<li>javax.servlet.forward.servlet_path : ${requestScope['javax.servlet.forward.servlet_path']}</li>
</ul>

Session:
<ul>
<li>${sessionScope['scopedTarget.userSession'].loggedIn}</li>
<li>${sessionScope['scopedTarget.userSession'].user.locale}</li>
</ul>
<%@ include file="footer.jsp"%>
