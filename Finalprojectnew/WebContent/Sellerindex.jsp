<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,Model.entities.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<style type="text/css">
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
	#input{
	display:none;
	float:left;
	width:600px;
	height:400px;
   }
#input #span1{
	float:left;
	font: 20px Georgia, "Times New Roman", Times, serif;
	margin-left:30px;
	margin-bottom:10px;
	margin-top:10px;
}

#create {
	float:left;
	margin-left:auto;
    margin-right:auto;
    width: 600px;
    background: #F7F7F7;
    padding: 25px 15px 25px 10px;
    font: 20px Georgia, "Times New Roman", Times, serif;
    color: #888;
    text-shadow: 1px 1px 1px #FFF;
    border:1px solid #E4E4E4;
}
#create span{
	color:red;
}
#create label{
	margin-top:3px;
	margin-bottom:3px;
	display:block;
}
#create label> span{
float: left;
width: 20%;
text-align: right;
margin-top: 10px;
color: #888;
}
#create textarea{
	height:100px;
	width:60%;
	padding: 5px 3px 3px 5px;
}
#create input{
	padding:5px 3px 3px 5px;
	width:60%;
}
#create #save-btn{
	padding: 5px 20px 5px 20px;
	margin-left:100px;
	margin-top:10px;
	float:left;
}
#create #cancel-btn{
	padding: 5px 20px 5px 20px;
	margin-left:180px;
	margin-top:10px;
	float:left;
}
  ul, li{
   margin:0; padding:0;font-style: normal;font:12px/22px "\5B8B\4F53",Arial, Helvetica, sans-serif
} 

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
 
ul#nav{ width:100%; height:60px; background:#00A2CA;margin:0 auto} 
ul#nav li{display:inline; height:60px} 
ul#nav li a{display:inline-block; padding:0 20px; height:60px; line-height:60px; 
color:#FFF; font-family:"\5FAE\8F6F\96C5\9ED1"; font-size:16px} 
ul#nav li a:hover{background:#0095BB}
#orderlist{
	text-align:left;
	 float:left;
	 width:950px;
	}
	#orderlist h1{
	 text-align:left;
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
#update{
	
	float:left;
	width:500px;
	display:none; 
 	}
#update table td, th { 
  font: 20px Georgia, "Times New Roman", Times, serif; 
  padding: 6px;  
  border: 1px solid #ccc;
  height:40px;
  text-align: center;  
}
#update input{ 
font: 20px Georgia, "Times New Roman", Times, serif; 
  width:250px;
  height:30px;
  text-align: center;  
}
#carslist{
 display:none;
}
#update{
 display:none;
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