<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,Model.entities.*,Model.DaoImpl.*,Model.Dao.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
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
    #count{
	 margin:auto;
	 width:1000px;
	 height:600px;
	 text-align:center;
	 float:center;
	  background: #EEE;
	}
	#header{	
	  width:890px;
	  font: 25px Georgia, "Times New Roman", Times, serif;
	  margin: auto;
	}
	   #left{
	    width:45%;
	    float:left;
	    margin-left:20px;
	   }
	  #left table{
	    font: 20px Georgia, "Times New Roman", Times, serif;
	  	border-collapse:separate;
        border-spacing:10px 20px;
	  }
	  #right{
	  margin-top:20px;
	  margin-right:20px;
	   width:50%;
	   float:left;
	    font: 20px Georgia, "Times New Roman", Times, serif;
	  }
#right table {  
  width: 100%;  
  border-collapse: collapse;  
} 

#right tr:nth-of-type(odd) {  
  background: #eee;  
} 
#right th {  
  background: #333;  
  color: white;  
  font-weight: bold;  
} 
#right td, th {  
  padding: 6px;  
  border: 1px solid #ccc;  
  text-align: left;  
}
#return{
   width:100%;
   margin-top:200px;
   font: 25px Georgia, "Times New Roman", Times, serif;
   float:left;

}
	</style>
  </head>
  
  <body>
  <div id="count">
  <div id="header">
    <h1>OrderDetail</h1>
    </div>
    <hr>
          <% 
             String role=(String)request.getSession().getAttribute("role");
             Order o=(Order)session.getAttribute("orderdetail");
             List<Goods> g=(List<Goods>)session.getAttribute("goodsdetail");
             List<seller> sl=(List<seller>)session.getAttribute("sellerlist2");
             float price=0;
             for(int i=0;i<g.size();i++){
            	 price+=g.get(i).getPrice();
             }
             if(o!=null)
             {
          %>
         <div id="left">
             <table>
               <tr>
                 <td><B>Orderid:<%=o.getOrderid() %></B></td> 
               </tr>
               <tr>
                  <td>Customerid:<%=o.getCustomerid() %></td>
               </tr>
               <tr>
                 <td>Total price:<%=price %></td>
               </tr>  
             </table>
          </div>
          <% 
            }
          %>
     <div id="right">  
     <table>
     <tr>
     <th>Goodname</th>
     <th>Sellername</th>
     <th>Price</th>
     </tr>
      <%
        for(int i=0;i<g.size();i++){
        	
        	Goods gdetail=g.get(i);
        	seller s=sl.get(i);
      %>
      <tr>
       <td>Goodname:<%=gdetail.getGoodsname() %></td>
       <td>Sellername:<%=s.getUsername() %></td>
       <td>Price:<%=gdetail.getPrice()%></td>
      </tr>
      <%
        }
      %>
     </table>
     </div>
    <div id="return">
    <% if(role.equals("customer")){ %>
    <a href="CustomerAccount.jsp">Return to account information page</a>
    <% }else{%>
    <a href="indexAdministrator.jsp">Return to account information page</a>
    <% } %>
    </div>
 </div>
  
  </body>
</html>
