<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>新增</title>
    <script type="text/javascript">
    	function checkAdd(){
    	   var addName = document.getElementById("addName").value;
    	   var addPrice = document.getElementById("addPrice").value;
    	   var addWeight = document.getElementById("addWeight").value;
           if(addName==null||addName==""){
               alert("用户名不能为空！");
               return false;
           }
           if(addPrice==null||addPrice==""){
               alert("手机号不能为空！");
               return false;
           }
           var myreg = /^[-\+]?\d+(\.\d+)?$/;
           if(!myreg.test(addPrice)||!myreg.test(addWeight)) 
           { 
               alert("价格或重量请输入数字！"); 
               return false; 
           }
           return true;
	   }
    </script>
  </head>
  
  <body>
    <form id="addForm" action="add.action" method="post" onsubmit="checkAdd()">
	        商品名称：<input type="text" id="addName" name="name" style="width:120px"/> <br/>
	        价格：<input type="text" id="addPrice" name="price" style="width:120px"/><br/>
	        描述：<input type="text" name="desc" style="width:120px"/><br/>
	        重量：<input type="text" id="addWeight" name="weight" style="width:120px"/><br/>
	        型号规格：<input type="text" name="model" style="width:120px"/><br/>
	   <input type="submit" value="添加" style="background-color:#173e65;color:#ffffff;width:70px;"/>
    </form>
  </body>
</html>
