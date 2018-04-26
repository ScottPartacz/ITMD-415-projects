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
    text-align: center;
}

th {
    height: 50px;
}
</style>
</head>
<body>
<script type="text/javascript">
window.onload=function(){
	 function showorder(){
		 $('#orderlist').show();
		 $('#customerslist').hide();
		 $('#carslist').hide();
		 $('#sellerslist').hide();
		 
	 }
	 function showcustomers(){
		 $('#orderlist').hide();
		 $('#customerslist').show();
		 $('#carslist').hide();
		 $('#sellerslist').hide();
	 }
	 function showcars(){
		 $('#orderlist').hide();
		 $('#customerslist').hide();
		 $('#carslist').show();
		 $('#sellerslist').hide();
	 }
	 function showsellers(){
		 $('#orderlist').hide();
		 $('#customerslist').hide();
		 $('#carslist').hide();
		 $('#sellerslist').show();
	 }
	 document.getElementById("1").addEventListener('click',showorder,false);
	 document.getElementById("4").addEventListener('click',showsellers,false);
	 document.getElementById("3").addEventListener('click',showcars,false);
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
  <li id="3"><a>View cars List</a></li>
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
  <div id="carslist">
  <h1>carslist</h1>
           <table>
          <tr>
           <th>carid</th>
           <th>Amount</th>
           <th>Price</th>
           <th>Operation</th>
          </tr>
          <!-- 商品循环开始 -->
           <% 
           List<Cars> glist=(List<Cars>)session.getAttribute("glist");
               if(glist!=null&&glist.size()>0)
               {
	               for(int i=0;i<glist.size();i++)
	               {
	                  Cars g=glist.get(i);
           %>   
          <tr>           
               <td>
                 <a href="Controller/servlet/carsServlet?sellercarid=<%=g.getCarid()%>"><%=g.getModel() %></a>
               </td>
               <td class="dq">Amount:<%=g.getAmount() %></td><td>price$: <%=g.getPrice() %></td> 
               <td><a href="Controller/servlet/carsServlet?deletecarid=<%=g.getCarid()%>"><button id="delete">Delete</button></a></td>
          
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