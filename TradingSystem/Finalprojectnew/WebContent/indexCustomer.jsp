<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,Model.entities.*,Model.DaoImpl.*,Model.Dao.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
	 text-align:center;
	 float:center;
	}
	#header{	
	  width:790px;
	  font: 25px Georgia, "Times New Roman", Times, serif;
	  margin: auto;
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
	   #goodlist{
	   font: 25px Georgia, "Times New Roman", Times, serif;
	    float:left;
	    width:1000px;
	   }
	   #goodlist div{
	   
	     float:left;
	      margin: 10px;
	   
	   }
	   div dd{
	      margin:0px;
	      font-size:14pt;
	   }
	   div dd.dd_name
	   {
	      color:blue;
	   }
	   div dd.dq
	   {
	      color:#000;
	   }
	   #table{
	   text-align:left;
	     font: 30px Georgia, "Times New Roman", Times, serif;
	     float:left;
	     border-collapse:separate;
         border-spacing:10px 20px;
	   }
	</style>
  </head>
  
  <body>
  <div id="count">
  <div id="header">
    <h1>Online Trading System</h1> 
    <ul id="nav">
   <li><a href="Controller/servlet/orderServlet2">Account information</a></li>
  
   <li><a href="cart.jsp"> View my Cart</a></li>
   <li><a href="index.jsp"> Sign Out</a> </li>
   </ul>
  </div>  
   <div id="goodlist">

    <table  id="table">
      <tr>
        <td>
          
           <% 
           String u=(String)session.getAttribute("user");
           List<Goods> glist=(List<Goods>)session.getAttribute("glist");
           List<seller> sellerlist=(List<seller>)session.getAttribute("sellerlist");
               if(glist!=null&&glist.size()>0)
               {
	               for(int i=0;i<glist.size();i++)
	               {
	                  Goods g=glist.get(i);
	                 seller se= sellerlist.get(i);
           %>   
          <div>
             <dl>
               <dt>
                 <a href="Controller/servlet/goodsServlet?id=<%=g.getGoodsid()%>"><%=g.getGoodsname() %></a>
               </dt>
               <dd class="dq">sellername:<%=se.getUsername() %>&nbsp;&nbsp;price$: <%=g.getPrice() %></dd> 
             </dl>
          </div>
        
          <%
                   }
              } 
          %>
        </td>
      </tr>
    </table>

    </div>
    </div>
  </body>
</html>
