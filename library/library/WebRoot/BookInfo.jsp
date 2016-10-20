<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<style type="text/css">
<!--
body {
background-image: url(2.png);
}
-->
</style> 
  <head>
    <title>详细信息</title>
  </head>
  
<style type="text/css">
<!--
body {
background-image: url(2.png);
}
-->
</style>  
  
	  <h1 >详细信息</h1>
	  <h2 >书籍信息</h2>	  	
	 	 ISBN：${bookinfo[0]}<br>
	  	书名：${bookinfo[1]}<br>
	  	作者：${bookinfo[7]}<br>
	  	出版社：${bookinfo[3]}<br>
	  	出版日期：${bookinfo[4]}<br>
	  	价格：${bookinfo[5]}元<br>
	  	
	   <h2>作者信息</h2>
	  	作者：${bookinfo[7]}<br>
	  	国家：${bookinfo[9]}<br>
	  	年龄：${bookinfo[8]}<br>
     
   <input type="button" name="jump" value= "更新信息" onclick="location.href='LibraryOperations_update.action?ID=${bookinfo[0]}'"/>
     <input type="button" name="jump" value= "返回首页" onclick="location.href='index.jsp'"/>
  </body>
</html>
