<%@ page contentType="text/html; charset=UTF-8" %>
<!-- 导入Struts 标签库 -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<style type="text/css">
<!--
body {
background-image: url(4.png);
}
-->
</style>     
<head>
        <title>查询结果</title>
    </head>
<font size=6>查询结果：</font>
<table  border="3">
	<tr>
		<td align="center" style="width:135px; height: 21px;" valign="middle"> 
		书名</td>
		<td align="center" style="width:60px; height: 21px;" valign="middle"> 
		作者</td>
		<td align="center" style="width:35px; height: 21px;" valign="middle"> 
		操作</td>
	</tr>
	<s:iterator value="books" var="b">
		<tr>
			<td align="center" style="width:135px; height: 21px;" valign="middle"> 
			<a href="LibraryOperations_bookdetail.action?ID=${b.ID}">${b.name}</a></td>
			<td align="center" style="width:50px; height: 21px;" valign="middle">${b.auther}</td>
			<td align="center" style="width:35px; height: 21px;" valign="middle"> 
			<a href="LibraryOperations_delete.action?ID=${b.ID}">删除</td>
		</tr>
	</s:iterator>
</table>
<input type="button" name="jump" value= "返回首页" onclick="location.href='index.jsp'"/>
</body>