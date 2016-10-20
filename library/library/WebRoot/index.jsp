<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
    
<style type="text/css">
<!--
body {
background-image: url(1.png);
}
-->
</style>     

	<head>
        <title>查询书籍</title>
    </head>
    <font size=24>欢迎来到刘昕源的图书馆</font><br>
    <font size=6>请输入作者姓名</font>
	<form  action="LibraryOperations_execute.action" method="post" style="height: 51px; ">
	  	<font size=6>名字:</font> <input type="text" name="name" style="height: 37px; width: px"/>
	  	<input type="submit" value="查询" style="height: 37px ">
	</form>
	<input type="button" name="jump" value= "全部书籍" onclick="location.href='LibraryOperations_allbooks.action'"/>
	</body>
	
</html>