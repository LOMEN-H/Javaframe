<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{border:solid 2px gray}
	td{border:solid 1px pink}
</style>
</head>
<body>
<h2>学生信息列表</h2><hr>
<table>
	<tr>
		<td>id</td>
		<td>name</td>
		<td>gender</td>
		<td>major</td>
		<td>grade</td>
		<td colspan="2">opr</td>
	<tr>
	<%
		ResultSet rs=(ResultSet)session.getAttribute("rs");
		while(rs.next()){
	%>
	<tr>
		<td><%= rs.getInt(1) %></td>
		<td><%= rs.getString("name") %></td>
		<td><%= rs.getString(3) %></td>
		<td><%= rs.getString(4) %></td>
		<td><%= rs.getString(5) %></td>
		<td><a href="stuSelectById?id=<%= rs.getInt(1) %>">修改</a></td>
		<td><a href="stuDelServlet?id=<%= rs.getInt(1) %>" onClick="return confirm('真的这么狠心吗？')">删除</a></td>
	<tr>
	<%} %>
	<tr>
		<td colspan="7" align="center"><a href="studentAdd.jsp">添加</a></td>
	</tr>
</table>

</body>
</html>