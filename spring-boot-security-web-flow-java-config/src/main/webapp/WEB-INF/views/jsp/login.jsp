<%--
  Created by IntelliJ IDEA.
  User: cp336622
  Date: 06/08/2018
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <h1>Login</h1>
    <form name='f' action="perform_login" method='POST'>
      <table>
        <tr>
          <td>User:</td>
          <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
          <td>Password:</td>
          <td><input type='password' name='password' /></td>
        </tr>
        <tr>
          <td><input name="submit" type="submit" value="submit" /></td>
        </tr>
      </table>
    </form>
  </body>
</html>
