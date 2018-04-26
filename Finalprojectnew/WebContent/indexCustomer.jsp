<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,Model.entities.*,Model.DaoImpl.*,Model.Dao.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

table {
    width: 100%;
}

th {
    height: 50px;
}
</style>
  </head>
  
  <body>
  <div id="count">
  <div id="header">
    <h1>Online Trading System</h1> 
    <ul id="nav">
   <li><a href="Controller/servlet/orderServlet2">Account information</a></li>
  
   <li><a href="cart.jsp"> View my Cart</a></li>
   <li><a href="index.jsp"> Sign Out</a> </li>
   </ul>
  </div>  
   <div id="carlist">

    <table  id="table">
      <tr>
        <td>
          
           <% 
           String u=(String)session.getAttribute("user");
           List<Cars> glist=(List<Cars>)session.getAttribute("glist");
           List<seller> sellerlist=(List<seller>)session.getAttribute("sellerlist");
               if(glist!=null&&glist.size()>0)
               {
	               for(int i=0;i<glist.size();i++)
	               {
	                  Cars g=glist.get(i);
	                 seller se= sellerlist.get(i);
           %>   
          <div>
             <dl>
               <dt>
                 <a href="Controller/servlet/CarsServlet?id=<%=g.getCarid()%>"><%=g.getModel() %></a>
               </dt>
               <dd class="dq">sellername:<%=se.getUsername() %>&nbsp;&nbsp;price$: <%=g.getPrice() %></dd> 
             </dl>
          </div>
        
          <%
                   }
              } 
          %>
        </td>
      </tr>
    </table>

    </div>
    </div>
  </body>
</html>
