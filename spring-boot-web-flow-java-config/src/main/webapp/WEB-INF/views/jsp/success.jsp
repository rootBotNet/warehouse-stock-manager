<%--
  Created by IntelliJ IDEA.
  User: cp336622
  Date: 20/08/2018
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
    <body>
        <h2>Activation Successful!</h2>
        <form method="post" action="${flowExecutionUrl}">

            <input type="hidden" name="_eventId" value="home">
            <input type="submit" value="Home" />

        </form>
    </body>
</html>
