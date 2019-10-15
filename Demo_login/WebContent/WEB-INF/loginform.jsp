<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
welcome ${name}

<form action="/Demo_login/login1.ds" method="get">
Username :	<input type="text" name="username"/></br>
password:  <input type="password" name="password"/></br>
<input type="submit" value="submit"/>
</form>
</a></form>

 <form:errors path="employee1.*" ></form:errors> 
</body>
</html>