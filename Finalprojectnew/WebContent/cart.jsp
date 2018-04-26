<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,Model.entities.*,Model.DaoImpl.*,Model.Dao.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'cart.jsp' starting page</title>
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
    <script language="javascript">
	    function delcfm() {
	        if (!confirm("Do you want to delete it？")) {
	            window.event.returnValue = false;
	        }
	    }
	    function test(){
	    	 var url = "Controller/servlet/orderServlet2";
	    	 window.location.href= url;
	    	}
	    function return1(){
	    	 var url = "indexCustomer.jsp";
	    	 window.location.href= url;
	    	}
   </script>
  </head>
  
  <body>
  <div id="content">
  <div id="header">
   <h1>My Cart</h1>
   <a href="indexCustomer.jsp">Return to carslist</a>
   <hr> 
   </div>
 
   <div id="shopping">	
			<table id="table">
				<tr>
					<th>carname</th>
					<th>Stock</th>
					<th>Price</th>
					<th>Operation</th>
				</tr>
				
				<% 
				   if(request.getSession().getAttribute("cart")!=null)
				   {
				%>
				     <% 
				     float f=0;
				         List<Cars>carslist = (List<Cars>)request.getSession().getAttribute("cart");
				     for(int i=0;i<carslist.size();i++){
				    	 f+=carslist.get(i).getPrice();
				     }
				         for(int i=0;i<carslist.size();i++){
				     %> 
				<tr name="products" id="product_id_1">
					<td class="thumb"><%=carslist.get(i).getModel()%></td>
					<td class="number"><%=carslist.get(i).getAmount()%></td>
					<td class="price" id="price_id_1">
						<span><%=carslist.get(i).getPrice() %></span>
						<input type="hidden" value="" />
					</td>                     
                    <td class="delete">
					  <a href="Controller/servlet/orderServlet?action=delete&deleteid=<%=i%>" onclick="delcfm();">Delete</a>					                  
					</td>
				</tr>
				     <% 
				         }
				     %>
				
			</table>
			 <div class="total"><span id="total">Total price:<%=f%></span></div>
			  <% 
			    }
			 %>
			<div id="buttons">
			<div class="button"><input type="button" onclick="test()" value="create order"style="width:100px;height:30px;" /></div>
			<div class="button"><a href="indexCustomer.jsp"><input type="submit" value="Return"style="width:100px;height:30px;" /></a></div>
			</div>
	</div>
	</div>
  </body>
</html>
