<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,Model.entities.*,Model.DaoImpl.*,Model.Dao.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<title>Insert title here</title>
<style type="text/css">
ol, ul ,li{list-style:none} 
img {border: 0; vertical-align:middle} 
body{color:#000000;background:#FFF; text-align:center} 
.clear{clear:both;height:1px;width:100%; overflow:hidden; margin-top:-1px} 
a{color:#000000;text-decoration:none}  
a:hover{color:#BA2636} 
 
.red ,.red a{ color:#F00} 
.lan ,.lan a{ color:#1E51A2} 
.pd5{ padding-top:5px} 
.dis{display:block} 
.undis{display:none} 
 
ul#nav{ height:60px; background:#00A2CA;margin:0 auto} 
ul#nav li{display:inline; height:60px} 
ul#nav li a{display:inline-block; padding:0 20px; height:60px; line-height:60px; 
color:#FFF; font-family:"\5FAE\8F6F\96C5\9ED1"; font-size:16px} 
ul#nav li a:hover{background:#0095BB}
 #content{
	 margin:auto;
	 width:950px;
	 text-align:center;
	 float:center;
	}
	#header{	
	  width:900px;
	  font: 25px Georgia, "Times New Roman", Times, serif;
	  margin: auto;
	}
	table {  
  text-align:center;
  width: 100%;  
  border-collapse: collapse;  
} 
tr:nth-of-type(odd) {  
  background: #eee;  
} 
th {  
  background: #333;  
  color: white;  
  font-weight: bold;  
} 
td, th {  
  padding: 6px;  
  border: 1px solid #ccc;  
  text-align: left;  
}
#orderlist{
	text-align:left;
	 float:left;
	 width:100%;
	}
#orderlist h1{
 float:left;
 margin-left:5px;
}
#goodslist{
 display:none; 
}
#goodslist h1{
 float:left;
 margin-left:5px;
}
#customerslist{
 display:none; 
}
#customerslist h1{
 float:left;
 margin-left:5px;
}
#sellerslist{
 display:none; 
}
#sellerslist h1{
 float:left;
 margin-left:5px;
}
</style>
</head>
<body>
<script type="text/javascript">
window.onload=function(){
	 function showorder(){
		 $('#orderlist').show();
		 $('#customerslist').hide();
		 $('#goodslist').hide();
		 $('#sellerslist').hide();
		 
	 }
	 function showcustomers(){
		 $('#orderlist').hide();
		 $('#customerslist').show();
		 $('#goodslist').hide();
		 $('#sellerslist').hide();
	 }
	 function showgoods(){
		 $('#orderlist').hide();
		 $('#customerslist').hide();
		 $('#goodslist').show();
		 $('#sellerslist').hide();
	 }
	 function showsellers(){
		 $('#orderlist').hide();
		 $('#customerslist').hide();
		 $('#goodslist').hide();
		 $('#sellerslist').show();
	 }
	 document.getElementById("1").addEventListener('click',showorder,false);
	 document.getElementById("4").addEventListener('click',showsellers,false);
	 document.getElementById("3").addEventListener('click',showgoods,false);
	 document.getElementById("2").addEventListener('click',showcustomers,false);
	 }
</script>
<div id="content">
<div id="header">
<% 

String u=(String)session.getAttribute("user");
String userid=(String)request.getSession().getAttribute("userid");
%>
<h1>Hello! <%=u%></h1>
</div>
 <ul id="nav">
  <li id="1"><a>view order list</a></li>
  <li id="3"><a>View goods List</a></li>
  <li id="2"><a>View Customers list</a></li>
  <li id="4"><a>View Sellers list</a></li>
  <li><a href="index.jsp">Sign Out</a></li>
 </ul>

<div id="orderlist">
  <h1>All of orders</h1>
  <table>
   <tr>
    <th>Orderid</th>
    <th>Status</th>
    <th>create date</th>
    <th>Payment-status</th>
    <th>Operation</th>
   </tr>
           <% 
         
           List<Order> orderlist=(List<Order>)session.getAttribute("orderlist");
               if(orderlist!=null&&orderlist.size()>0)
               {
	               for(int i=0;i<orderlist.size();i++)
	               {
	                  Order o=orderlist.get(i);
           %>   
             <tr>
               <td>
                 <a href="Controller/servlet/orderServlet3?orderid=<%=o.getOrderid()%>">Orderid:<%=o.getOrderid()%>(click see detail)</a>
               </td>
               <td class="dq">status:<%=o.getStatus() %></td>
              <td>create date: <%=o.getDate() %></td>
               <%  if(o.getStatus().equals("cancel")){%>
                <td>This order has been canceled by Customer.</td>
                <%}else if(o.getStatus().equals("paid")){ %>
                <td>This order has been paid by Customer.</td>
                <% }else{ %>
                <td>This order is non-payment</td>
                <% }%>
               <td> <a href="Controller/servlet/orderServlet2?deleteorderid=<%=o.getOrderid()%>">Delete it</a></td>
               
             </tr>
        
          <%
                   }
              } 
          %>
       </table>
 </div>
  <div id="goodslist">
  <h1>Goodslist</h1>
           <table>
          <tr>
           <th>Goodid</th>
           <th>Amount</th>
           <th>Price</th>
           <th>Operation</th>
          </tr>
          <!-- 商品循环开始 -->
           <% 
           List<Goods> glist=(List<Goods>)session.getAttribute("glist");
               if(glist!=null&&glist.size()>0)
               {
	               for(int i=0;i<glist.size();i++)
	               {
	                  Goods g=glist.get(i);
           %>   
          <tr>           
               <td>
                 <a href="Controller/servlet/goodsServlet?sellergoodid=<%=g.getGoodsid()%>"><%=g.getGoodsname() %></a>
               </td>
               <td class="dq">Amount:<%=g.getAmount() %></td><td>price$: <%=g.getPrice() %></td> 
               <td><a href="Controller/servlet/goodsServlet?deletegoodid=<%=g.getGoodsid()%>"><button id="delete">Delete</button></a></td>
          
          </tr>
          <%
                   }
              } 
          %>
    </table>
 </div>
 <div id="customerslist">
  <h1>Customer list</h1>
           <table>
           <tr>
            <th>Customername</th>
            <th>Customerid</th>
            <th>Password</th>
            <th>Address</th>
            <th>Operation</th>
           </tr>
           <% 
           List<customer> clist=(List<customer>)session.getAttribute("clist");
               if(clist!=null&&clist.size()>0)
               {
	               for(int i=0;i<clist.size();i++)
	               {
	                  customer c=clist.get(i);
           %>   
          <tr>
             <td>
                 <%=c.getUsername() %>
               </td>
               <td class="dq">Userid: <%=c.getUserid() %></td><td>password: <%=c.getPassword() %></td><td>address: <%=c.getAddress() %></td>         
               <td> <a href="Controller/servlet/viewandupdateuserServlet?deletecid=<%=c.getUserid()%>&viewid=customers">Delete</a></td>
          </tr>
        
          <%
                   }
              } 
          %>
    </table>
 </div>
 <div id="sellerslist">
  <h1>Sellers list</h1>
           <table>
           <tr>
            <th>Sellername</th>
            <th>Sellerid</th>
            <th>Password</th>
            <th>Address</th>
            <th>Operation</th>
           </tr>
           <% 
           List<seller> slist=(List<seller>)session.getAttribute("slist");
               if(slist!=null&&slist.size()>0)
               {
	               for(int i=0;i<slist.size();i++)
	               {
	                  seller c=slist.get(i);
           %>   
             <tr>
               <td>
                 <%=c.getUsername() %>
               </td>
               <td class="dq">Userid:<%=c.getUserid() %></td><td>password: <%=c.getPassword() %></td><td>address: <%=c.getAddress() %></td>
               <td><a href="Controller/servlet/viewandupdateuserServlet?deletesid=<%=c.getUserid()%>&&viewid=sellers">Delete</a></td>
        
             </tr>
        
          <%
                   }
              } 
          %>
    </table>
 </div>
 </div>
</body>
</html>