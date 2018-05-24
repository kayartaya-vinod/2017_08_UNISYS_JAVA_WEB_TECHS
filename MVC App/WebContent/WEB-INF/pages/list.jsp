<%@ include file="header.txt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<h2>List of all contacts</h2>

<h2>
<c:if test="${pageNum>1}">
	<a href="./list-all?page=${pageNum-1}">
		<span class="glyphicon glyphicon-backward "></span>
	</a>
</c:if>

<c:if test="${fn:length(contacts)>0}">
	<a href="./list-all?page=${pageNum+1}" class="pull-right">
		<span class="glyphicon glyphicon-forward"></span>
	</a>
</c:if>

</h2>
<table class="table table-striped table-hover table-bordered table-condensed">
	<thead>
		<tr>
			<th>Name</th>
			<th>Email id</th>
			<th>Phone number</th>
			<th>City</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${contacts}" var="c">
		<tr>
			<td>
			<a href="./edit-contact?id=${c.id}">
				<span class="glyphicon glyphicon-pencil"></span>
			</a>
			<a onclick="return confirm('Are you sure to delete this contact?')" 
				href="./delete-contact?id=${c.id}&page=${pageNum}">
				<span class="glyphicon glyphicon-trash"></span>
			</a>
			${c.gender=="Male"?"Mr.":"Ms"} ${c.firstname} ${c.lastname}</td>
			<td>${c.email}</td>
			<td>${c.phone}</td>
			<td>${c.city}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="footer.txt"%>