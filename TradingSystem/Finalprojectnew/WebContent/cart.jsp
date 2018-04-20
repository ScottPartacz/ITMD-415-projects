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
	  font: 25px Georgia, "Times New Roman", Times, serif;
	  margin: auto;
	}
	#shopping{
	
	}
	#table{
	   text-algin:center;
	   font: 20px Georgia, "Times New Roman", Times, serif;
	   width:790px;
	   margin: auto;
	   border-collapse:separate;
       border-spacing:10px 20px;
	}
	th{
	      font: 25px Georgia, "Times New Roman", Times, serif;
	}
	td {
       text-align:center;
       vertical-align:middle;
       }
   .total{
       margin-top:10px;
       margin-left:80px;
       font: 25px Georgia, "Times New Roman", Times, serif;
       float:left;
       }
   #buttons{
       width:790px;
       float:left;
       margin-top:15px;
      }
   .button{
      float:right;
      margin-right:70px;
      
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
   <a href="indexCustomer.jsp">Return to Goodslist</a>
   <hr> 
   </div>
 
   <div id="shopping">	
			<table id="table">
				<tr>
					<th>Goodname</th>
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
				         List<Goods>Goodslist = (List<Goods>)request.getSession().getAttribute("cart");
				     for(int i=0;i<Goodslist.size();i++){
				    	 f+=Goodslist.get(i).getPrice();
				     }
				         for(int i=0;i<Goodslist.size();i++){
				     %> 
				<tr name="products" id="product_id_1">
					<td class="thumb"><%=Goodslist.get(i).getGoodsname()%></td>
					<td class="number"><%=Goodslist.get(i).getAmount()%></td>
					<td class="price" id="price_id_1">
						<span><%=Goodslist.get(i).getPrice() %></span>
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
