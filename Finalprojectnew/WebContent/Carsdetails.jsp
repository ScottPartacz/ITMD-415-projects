<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,Model.entities.*,Model.DaoImpl.*,Model.Dao.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'details.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style type="text/css">
     #content{
	 margin:auto;
	 width:800px;
	 text-align:center;
	 float:center;
	}
	#header{	
	  text-algin:center;
	  width:790px;
	  font: 30px Georgia, oblique;
	  margin: auto;
	  background-color:#f4ca41;
	}
	#shopping{
	
	}
	table {
    width: 100%;
}

th {
    height: 50px;
}
   .total{
       margin-top:10px;
       margin-left:80px;
       font: 20px Georgia, oblique;
       float:left;
       }
   #buttons{
       width:790px;
       float:left;
       margin-top:15px;
      }
   .button{
      float:center;
      margin-right:70px;
      border:3px;
      background-color:#d941f4;
      text-align:center;
      
   }
    </style>
  </head>
  
  <body>
  <% 
  Cars g=(Cars)session.getAttribute("car");
  seller s=(seller)session.getAttribute("seller"); 
  %>
  <div id="content">
  <div id="header">
    <h1>car detail</h1>
     <hr>
    </div>
    <div id="table">
      <table width="400" height="60" cellpadding="0" cellspacing="0" border="0">
        <tr>
          <% 
            
             if(g!=null)
             {
          %>
          <td width="70%" valign="top">
               <tr>
                 <td><B>carid:<%=g.getCarid() %></B></td> 
               </tr>
               <tr>
                 <td>carname:<%=g.getModel()%></td>
               </tr>
               <tr>
                 <td>price:<%=g.getPrice() %></td>
               </tr> 
                <tr>
                 <td>amount:<%=g.getAmount() %></td>
               </tr> 
                <tr>
                 <td>seller:<%=s.getUsername() %></td>
               </tr> 
          <% 
            }
          %>
       </table>  
     </div>  
     <div id="title">
      <span>Description:</span>
     <div id="description">    
      <%=g.getDescription() %>
    </div>
    </div>
    <div id="button-wrapper">
				<a href="Controller/servlet/orderServlet?carid=<%=g.getCarid()%>"><button id="order">add it to cart</button></a>
				<a href="cart.jsp"><button id="showcart">show my cart</button></a>
				<a href="indexCustomer.jsp"><button id="return">return</button></a>
   </div>
   </div>
  </body>
</html>