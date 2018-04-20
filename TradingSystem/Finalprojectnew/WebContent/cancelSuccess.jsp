<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,Model.entities.*,Model.DaoImpl.*,Model.Dao.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
 #content{
        width: 650px;
        height: 300px;
        background: #EEE;
        position:absolute;
        left:0;
        top: 0;
        bottom: 0;
        right: 0;
        margin: auto;
        font: 40px Georgia, "Times New Roman", Times, serif;
         }
    #text{
        text-align:center;
        margin-top:90px;
    
    }
    #back{
        text-align:center;
        margin-top:50px;
         font: 20px Georgia, "Times New Roman", Times, serif;
     }
</style>
</head>
<body>
<div id="content">
  <div id="text">
      <% 
      String id = (String)request.getSession().getAttribute(("cancelorderid"));
      %>
              You have canceled the good:<%=id%></div>
       <div id="back"><a href="CustomerAccount.jsp">return to your account</a></div>
</div>
</body>
</html>