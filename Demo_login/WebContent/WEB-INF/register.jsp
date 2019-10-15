<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/Demo_login/register.ds" method="post">
Registration </br>
</br>
</br>

Full name: <input type="text" name="name"/></br>
email: <input type="text" name="email"/></br>
password: <input type="password" name="password"/></br>
mobileno: <input type="text" name="mobileno"/></br>
<input type="submit" value="submit">
</form>

<form:errors path="employee.*"></form:errors>

</body>
</html>