<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>新加书籍</title>
    </head>
<style type="text/css">
<!--
body {
background-image: url(1.jpg);
}
-->
</style>
        <h3 align="center">请输入书籍信息 </h3>
       <h3 align="center"> ${ID} </h3>
<p align="center">
		<form action="UpdateInfo_newbook.action?" method="post">
			<!-- input type="hidden" name="ISBN" value="${ID}"/> -->
  			<p>名字: <input type="text" name="Title" /></p>
  			<p>作者: <input type="text" name="Name" /></p>
  			<p>出版社: <input type="text" name="Publisher" /></p>
  			<p>出版日期: <input type="text" name="PublishDate" /></p>
  			<p>价格: <input type="text" name="Price" /></p>
 			 <input type="submit" value="提交" />
		</form>
</p>
    </body>
</html>
