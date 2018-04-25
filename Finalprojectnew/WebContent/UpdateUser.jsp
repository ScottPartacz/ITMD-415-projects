<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,Model.entities.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="register">
  <%
  String role=(String)session.getAttribute("role");
  String userid=(String)session.getAttribute("updateid");
  %>
  <h1>Update <%=role %>:<%=userid %>'s</h1>
  <form action="Controller/servlet/updateUserServlet" method="post">
    <table>
        <tr>
            <td><label for="txtpswd">password</label></td>
            <td><input type="text" id="password" name="password" /></td>
        </tr>
        <tr>
            <td><label for="txtaddress">username</label></td>
            <td><input type="text" id="username" name="username" /></td>
        </tr>
        <tr>
            <td><label for="txtaddress">address</label></td>
            <td><input type="text" id="address" name="address" /></td>
        </tr>
        <tr>
            <td colspan=2>
                <input type="reset" />
                <input type="submit" value="Sign in"/>
            </td>
        </tr>
    </table>
</form>
</div>
</body>
</html>