<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Custom tags demo</title>
</head>
<body>
	<h1>Custom tags demo</h1>
	<hr />
	
	<%@taglib uri="https://vinod.co/customtags/at/unisys" prefix="v" %>
	
	<v:today /><br /><br />
	<v:today pattern="yyyy-MM-dd hh:mm:ss" /><br /><br />
	<v:today pattern="EEEE MMMM d, yyyy" /><br /><br />
</body>
</html>