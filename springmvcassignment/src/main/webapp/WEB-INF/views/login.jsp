<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Login Page
	<table>
		<form action="/auth/login.html" method="post">
			<tr>
			<td>UserName
			</td>
			<td><input type="text" name="userName" /><div>${userName }</div>
			</tr>
			<tr>
			<td>Password
			</td>
			<td><input type="text" name="password" /><div>${password }</div>
			</tr><tr>
			<td><input type="submit"/></td></tr>
		</form>
	</table>
</body>
</html>