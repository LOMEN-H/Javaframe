<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 添加表单的action应该是stuAddServlet -->
<form action="stuAddServlet">
<h2>修改学生信息</h2><hr>
<table>
	<tr>
		<td>id</td>
		<td>name</td>
		<td>gender</td>
		<td>major</td>
		<td>grade</td>
		<td colspan="2">opr</td>
	<tr>
	
	<tr>
		<td><label><input type="text" name="id"  ></label></td>
		<td><label><input type="text" name="name"></label></td>
		<td><label><input type="text" name="gender"></label></td>
		<td><label><input type="text" name="major"></label></td>
		<td><label><input type="text" name="grade">></label></td>
		
		<td><label><input type="submit"></label></td>
		
	<tr>

	
</table>
</form>
</body>
</html>