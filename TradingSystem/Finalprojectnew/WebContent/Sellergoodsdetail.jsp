<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,Model.entities.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
 <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'details.jsp' starting page</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
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
	</style>
  </head>
  
  <body>
  <script type="text/javascript">
  window.onload=function(){
  function showupdate(){
		 $('#input').show();
	 }
  document.getElementById("update").addEventListener('click',showupdate,false);
  }
  function check2(form) {

		 if(form.addgoodid.value==''){
		          alert("please input goodid!");
		          form.addgoodid.focus();
		          return false;
		   }
		 if(form.addgoodname.value==''){
		     alert("please input goodname!");
		     form.addgoodname.focus();
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
  Goods g=(Goods)session.getAttribute("good");
  seller s=(seller)session.getAttribute("seller"); 
  String r=(String)session.getAttribute("role"); 
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
				<a href="Controller/servlet/goodsServlet?deletegoodid=<%=g.getGoodsid()%>"><button id="delete">Delete</button></a>
				<button id="update">update</button>
				<% if(r.equals("seller")){%>
				<a href="Sellerindex.jsp"><button id="return">return</button></a>
				<%} %>
				<% if(r.equals("administrator")){%>
				<a href="indexAdministrator.jsp"><button id="return">return</button></a>
				<%} %>
   </div>
   
   <div id="input">
	<span id="span1">Update Good</span>
	<div id="create">
	<form action="Controller/servlet/goodsServlet?updategoodid=<%=g.getGoodsid()%>" method="post" onsubmit="return check2(this)">
		<label><span>Goodname:</span> <input id="addgoodname" name="addgoodname" type="text"/></label><br>
		<label><span>amount:</span> <input id="addamount" name="addamount" type="text"></label><br>
		<label><span>price:</span> <input id="addprice" name="addprice" type="text" ></label><br>
		<label><span>description:</span> <textarea id="description" name="description"></textarea></label><br>
		<button id="save-btn">Save</button>
		<button id="cancel-btn">Reset</button>
		</form>
	</div>
</div>
   </div>
  </body>
</html>