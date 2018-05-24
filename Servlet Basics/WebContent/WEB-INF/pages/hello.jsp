<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello, JSP!</title>
</head>
<body>
	<%
		pageContext.setAttribute("title", "This is from Page scope");
	%>
	
	<h1><%= request.getAttribute("title") %></h1>
	
	<h1>${title}</h1><!-- looks in page, request, session, application scopes -->
	
	<h1>${pageScope["title"]}</h1>
	<h1>${requestScope.title}</h1>
	<h1>${sessionScope.title}</h1>
	<h1>${applicationScope.title}</h1>
	<h1>My name is : ${myName}</h1>
	
	<hr />
</body>
</html>