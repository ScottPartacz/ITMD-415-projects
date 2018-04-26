<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,Model.entities.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
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
		 $('#input').hide();
		 $('#carslist').hide();
		 $('#update').hide();
		 
	 }
	 function showupdate(){
		 $('#orderlist').hide();
		 $('#input').hide();
		 $('#carslist').hide();
		 $('#update').show();
	 }
	 function showcars(){
		 $('#orderlist').hide();
		 $('#input').hide();
		 $('#carslist').show();
		 $('#update').hide();
	 }
	 function showinput(){
		 $('#orderlist').hide();
		 $('#input').show();
		 $('#carslist').hide();
		 $('#update').hide();
	 }
	 document.getElementById("3").addEventListener('click',showorder,false);
	 document.getElementById("4").addEventListener('click',showupdate,false);
	 document.getElementById("2").addEventListener('click',showcars,false);
	 document.getElementById("1").addEventListener('click',showinput,false);
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
function check2(form) {

	 if(form.addcarid.value==''){
	          alert("please input carid!");
	          form.addcarid.focus();
	          return false;
	   }
	 if(form.addcarname.value==''){
	     alert("please input carname!");
	     form.addcarname.focus();
	     return false;
	}
	 if(form.addamount.value==''){
	     alert("please input addamount!");
	     form.addamount.focus();
	     return false;
	} 
	 if(form.addprice.value==''){
	     alert("please input price!");
	     form.addprice.focus();
	     return false;
	}
	 if(form.description.value==''){
	     alert("please input description!");
	     form.description.focus();
	     return false;
	}
	   return true;
	   }
</script>
<% 

String u=(String)session.getAttribute("user");
String userid=(String)request.getSession().getAttribute("userid");
String gid=(String)request.getSession().getAttribute("gid");
%>
<div id="content">
<div id="header">
 <h1>Hello! <%=u%></h1>
  <%if(gid!=null){ %>
   
   <h3><%=gid %></h3>
   
   <%
     request.getSession().removeAttribute("gid");
    } 
  %>
</div>
<div id="functionlist">


 <ul id="nav">
  <li id="1"><a>Create car</a></li>
  <li id="2"><a>View cars List</a></li>
  <li id="3"><a>View order List</a></li>
  <li id="4"><a>Update account</a></li>
  <li><a href="index.jsp">Sign Out</a></li>
 </ul>
</div>

<div id="input">
	<span id="span1">Create a new car</span>
	<div id="create">
	<form action="Controller/servlet/carsServlet" method="post" onsubmit="return check2(this)">
		<label><span>carid:</span> <input id="addcarid" name="addcarid" type="text"/></label><br>
		<label><span>carname:</span> <input id="addcarname" name="addcarname" type="text"/></label><br>
		<label><span>amount:</span> <input id="addamount" name="addamount" type="text"></label><br>
		<label><span>price:</span> <input id="addprice" name="addprice" type="text" ></label><br>
		<label><span>description:</span> <textarea id="description" name="description"></textarea></label><br>
		<button id="save-btn">Save</button>
		<button id="cancel-btn">Cancel</button>
		</form>
	</div>
</div>

<div id="orderlist">
  <h1><%=u %>'s order</h1>
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
               if(orderlist!=null&&orderlist.size()>0)
               {
	               for(int i=0;i<orderlist.size();i++)
	               {
	            	  float price=0;
	                  Order o=orderlist.get(i);
	                  String[] prices=o.getcarid().trim().split(" ");
	                  for(int q=0;q<prices.length;q++){
	                	  price+=Float.parseFloat(prices[q]);
	                  }
           %>   
             <tr>
               <td>
                 <a href="Controller/servlet/orderServlet3?orderid=<%=o.getOrderid()%>">Orderid:<%=o.getOrderid()%>(click see detail)</a>
               </td>
               <td class="dq">status:<%=o.getStatus() %></td>
              <td> price$: <%=price %></td><td>create date: <%=o.getDate() %></td>
               <%if(!o.getStatus().equals("cancel")&&!o.getStatus().equals("paid")){ %>
              <td> <a href="Controller/servlet/orderServlet2?cancelorderid=<%=o.getOrderid()%>">Cancel it</a></td>
               <% }else if(o.getStatus().equals("cancel")){%>
                <td>This order has been canceled</td>
                <%}else{ %>
               <td> This order has been paid by Customer</td>
                <% } %>
             </tr>
      
        
          <%
                   }
              } 
          %>
</table>
 </div>
 <div id="carslist">
  <h1><%=u %>'s cars</h1>
           <table >
 
          <tr>
           <th>carname</th>
           <th>amount</th>
           <th>price</th>
           <th>sellerid</th>
          </tr>
          
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
               <td>Sellerid:<%=g.getSellerid() %></td>
             </tr>

        
          <%
                   }
              } 
          %>

    </table>
 </div>
 <div id="update"> 
 <div id="update1">
  <h1>Update <%=u %>'s account</h1>
  <form action="Controller/servlet/SelfUpdateServlet" method="post" onsubmit="return check(this)">
    <table>
        <tr>
            <td><label for="txtpswd">password</label></td>
            <td><input type="text" id="password" name="password" /></td>
        </tr>
        <tr>
            <td><label for="txtaddress">username</label></td>
            <td><input type="text" id="username" name="username" /></td>
        </tr>
        <tr>
            <td><label for="txtaddress">address</label></td>
            <td><input type="text" id="address" name="address" /></td>
        </tr>
        <tr>
            <td colspan=2>
                <input type="reset" style="width:80px; margin-right:100px;"/>
                <input type="submit" value="Update" style="width:80px"/>
            </td>
        </tr>
    </table>
</form>
</div>
</div>
</div>
</body>
</html>