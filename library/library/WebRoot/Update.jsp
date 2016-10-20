<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<style type="text/css">
<!--
body {
background-image: url(5.png);
}
-->
</style> 
    <head>
        <title>更新书籍信息</title>
    </head>
    
	<h1 >请输入修改信息 </h1>
		<form action="LibraryOperations_UpdateBookInfo.action?" method="post">
			<input type="hidden" name="ISBN" value="${ID}"/>
  			书名: <input type="text" name="Title" /><br>
  			<p></p>
  			出版社: <input type="text" name="Publisher" /><br>
  			<p></p>
  			出版日期: <input type="text" name="PublishDate" /><br>
  			<p></p>
  			价格: <input type="text" name="Price" /><br>
  			<p></p>
 		<input type="submit" value="提交" />
		</form>
		<input type="button" name="jump" value= "返回首页" onclick="location.href='index.jsp'"/>
    </body>
</html>
