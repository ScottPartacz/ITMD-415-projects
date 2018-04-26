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
        background: #42d9f4;
        position:absolute;
        left:0;
        top: 0;
        bottom: 0;
        right: 0;
        margin: auto;
        font: 50px Georgia, oblique;
        font-style:oblique;
         }
    #text{
        text-align:center;
        margin-top:90px;
       
    
    }
    #back{
        text-align:center;
        margin-top:50px;
         font: 20px Georgia;
         font-style:oblique;
     }
</style>
</head>
<body>
<div id="content">
<div id="text">
      <% 
         String id = (String)request.getSession().getAttribute(("payorderid"));
      %>
           You have paid for car:<%=id%>
</div>
    <div id="back"><a href="CustomerAccount.jsp">return to your account</a></div>
</div>
</body>
</html>