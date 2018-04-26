<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,Model.entities.*,Model.DaoImpl.*,Model.Dao.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
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
		 $('#left').show();
		 $('#left2').hide();
	 }
	 function showupdate(){
		 $('#left').hide();
		 $('#left2').show();
	 }
	 document.getElementById("order").addEventListener('click',showorder,false);
	 document.getElementById("update").addEventListener('click',showupdate,false);
	 }
function check(form) {

 if(form.password.value==''){
          alert("please input password!");
          form.password.focus();
          return false;
   }
 if(form.username.value==''){
     alert("please input username!");
     form.username.focus();
     return false;
}
 if(form.address.value==''){
     alert("please input address!");
     form.address.focus();
     return false;
} 
   return true;
   }
</script>
 <%
   String u=(String)session.getAttribute("user");
 String uid=(String)session.getAttribute("userid");
   %>
<div id="count">
<div id="header">
 <h1><%=u %>'s account information</h1>
 <ul id="nav">

   <li id="order"><a>See your orders</a></li>
  
   <li id="update"><a>Update your information</a></li>
   <li><a href="indexCustomer.jsp">return to carslist</a></li>
   <li><a href="index.jsp">Sign Out</a></li>
 </ul>
</div>

 <div id="left">
  <h1><%=u %>'s order:</h1>
  <table>
  
  <tr>
   <th>Orderid</th>
   <th>Status</th>
   <th>Price</th>
   <th>Create date</th>
   <th>Payment status</th>
  </tr>
           <% 
         
           List<Order> orderlist=(List<Order>)session.getAttribute("orderlist");
           List<Float> pricelist=(List<Float>)session.getAttribute("pricelist");
               if(orderlist!=null&&orderlist.size()>0)
               {
	               for(int i=0;i<orderlist.size();i++)
	               {
	            	  float price=0;
	                  Order o=orderlist.get(i);
	                  price=pricelist.get(i);
           %>   
            <tr>
               <td>
                 <a href="Controller/servlet/orderServlet3?orderid=<%=o.getOrderid()%>">Orderid:<%=o.getOrderid()%>(click see detail)</a>
               </td>
               <td class="dq">status:<%=o.getStatus() %></td>
              <td> price$: <%=price %></td><td>create date: <%=o.getDate() %></td>
              <%if(!o.getStatus().equals("cancel")&&!o.getStatus().equals("paid")){ %>
               <td> <a href="Controller/servlet/orderServlet2?cancelorderid=<%=o.getOrderid()%>">Cancel</a>&nbsp;&nbsp;
                    <a href="Controller/servlet/orderServlet2?payorderid=<%=o.getOrderid()%>">pay for it</a></td>
               <% }else if(o.getStatus().equals("cancel")){%>
                <td>This order has been canceled.</td>
                <%}else{ %>
               <td> This order has been paid.</td>
                <% } %> 
             </tr>
        
          <%
                   }
              } 
          %>
 </table>
 </div>
 <div id="left2">
 <div id="update">
  <h1>Update <%=u %>'s account</h1>
  <form action="Controller/servlet/SelfUpdateServlet" method="post" onsubmit="return check(this)">
    <table>
        <tr>
            <td><label for="txtpswd">password</label></td>
            <td><input type="text" id="password" name="password" style="width:300px;height:22px"/></td>
        </tr>
        <tr>
            <td><label for="txtaddress">username</label></td>
            <td><input type="text" id="username" name="username" style="width:300px;height:22px"/></td>
        </tr>
        <tr>
            <td><label for="txtaddress">address</label></td>
            <td><input type="text" id="address" name="address" style="width:300px;height:22px"/></td>
        </tr>
        <tr>
            <td colspan=2>
                <input type="reset" />
                <input type="submit" value="Update"/>
            </td>
        </tr>
    </table>
</form>
</div>
 </div>
 </div>
</body>
</html>