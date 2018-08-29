<%--
  Created by IntelliJ IDEA.
  User: cp336622
  Date: 29/08/2018
  Time: 07:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>Welcome</title>
  </head>
  <body>
    <c:url value="/resources/text.txt" var="url"/>
    <spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />
    Spring URL: ${springUrl} at ${time}
  <br>
    JSTL URL: ${url}
  <br>
    Message: ${message}
  </body>
</html>
