<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes-dynattr.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
  <head><title>My First Stripe</title></head>
  <body>
    <h1>Stripes Calculator</h1>

	<fmt:setBundle basename="StripesResources" />
	<fmt:message key="kakec"/>

    <stripes:form beanclass="org.zabica.webcontest.stripes.actions.CalculatorActionBean" focus="">
        <table>
            <tr>
                <td>Number 1:</td>
                <td><stripes:text name="numberOne"/></td>
            </tr>
            <tr>
                <td>Number 2:</td>
                <td><stripes:text name="numberTwo"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <stripes:submit name="addition" value="Add"/>                    
                </td>
            </tr>
            <tr>
                <td>Result:</td>
                <td>${actionBean.result}</td>
            </tr>
        </table>
    </stripes:form>
  </body>
</html>
