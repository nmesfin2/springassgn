<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		Registration Page
		<table>
			<form action="/registration/adduser" method="post">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" /><div>${firstName }</div>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" /><div>${lastName }</div>
				</tr>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="userName" /><div>${userName }</div></tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /><div>${password }</div>
				</tr>
				<tr>
					<td><input type="submit"/></td>
				</tr>
			</form>
		</table>
	</body>
</html>