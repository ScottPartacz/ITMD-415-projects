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
	  font: 25px Georgia, "Times New Roman", Times, serif;
	  margin: auto;
	}
	#title{
	  width:300px;
	  height:300px;	  
	  float:right;
	  margin-right:50px;
	  margin-top:10px;
	}
	span{
	  font: 25px Georgia, "Times New Roman", Times, serif;
	}
	#description{
	  width:300px;
	  height:260px;
	  background:#EEE;
	  font: 25px Georgia, "Times New Roman", Times, serif;
	}
	#table{
	 float:left;
	 margin-left:50px;
	  font: 25px Georgia, "Times New Roman", Times, serif;
	}
	table{
	
	border-collapse:separate;
    border-spacing:10px 20px;
	}
	#button-wrapper{
	 float:left;
	  margin-left:50px;
	  margin-top:20px;
	}
	</style>
  </head>
  
  <body>
  <% 
  Goods g=(Goods)session.getAttribute("good");
  seller s=(seller)session.getAttribute("seller"); 
  %>
  <div id="content">
  <div id="header">
    <h1>Good detail</h1>
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
                 <td><B>goodid:<%=g.getGoodsid() %></B></td> 
               </tr>
               <tr>
                 <td>Goodname:<%=g.getGoodsname()%></td>
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
				<a href="Controller/servlet/orderServlet?goodid=<%=g.getGoodsid()%>"><button id="order">add it to cart</button></a>
				<a href="cart.jsp"><button id="showcart">show my cart</button></a>
				<a href="indexCustomer.jsp"><button id="return">return</button></a>
   </div>
   </div>
  </body>
</html>
