<html>
<!-- Some Sample HTML -->
<head>
<h1 align="center">My Login Page</h1>
</head>
<body>
<%
  Cookie c = new Cookie("cook","1");
response.addCookie(c);
%>
<form action="./validatelogin" method="post">
	Regno: <input type="text" name="regno" />  Password: <input type="password"
		name="passwd" /> <input type="Submit" />
	
	</center>
</form>
</body>
</html>