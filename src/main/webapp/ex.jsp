<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
	<label>name : </label>
    <input type="text" class="input" name ="foodname" pattern="[A-Za-z]{4,}+[ ][A-Za-z]{4,}+[ ][A-Za-z]{4,}+[(][A-Za-z]{3,}+[)]" required>
    <button><a href="ex1.jsp">login</a></button>
</form>
</body>
</html>