<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="exp1.model.entity.Student" import ="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 修改表单的每个输入域都要有原始值，这个原始值就是获取过来的学生的每个属性。修改表单的action值才是stuUpdateServlet -->
<form action="stuUpdateServlet">
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
	<%
		Student st=(Student)session.getAttribute("st");
		
	%>
	<tr>
		<td><label><input type="text" name="id" value=<%= st.getId() %> readonly="readonly"></label></td>
		<td><label><input type="text" name="name"value=<%= st.getName() %>></label></td>
		<td><label><input type="text" name="gender"value=<%= st.getGender() %>></label></td>
		<td><label><input type="text" name="major"value=<%= st.getMajor() %>></label></td>
		<td><label><input type="text" name="grade"value=<%= st.getGrade() %>></label></td>
		
		<td><label><input type="submit"></label></td>
		
	<tr>

	
</table>
</form>
</body>
</html>