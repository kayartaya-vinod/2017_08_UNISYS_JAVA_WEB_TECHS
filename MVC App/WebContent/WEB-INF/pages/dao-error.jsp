<%@page import="java.io.PrintWriter"%>
<%@page isErrorPage="true" %>
<%@include file="header.txt" %>
<h3>Something went wrong!</h3>
<p>
	<%= exception.getMessage() %> 
	<a href="javascript:void(0)" id="show_hide" data-status="hidden">Show details</a>
</p>
<pre id="err_details">
	<%
		PrintWriter out1 = new PrintWriter(out);
		exception.printStackTrace(out1);
	%>
</pre>

<script>
	$("#err_details").hide();
	$("#show_hide").click(function(){
		var status = $("#show_hide").attr("data-status");
		if(status=="hidden"){
			$("#show_hide").attr("data-status", "visible").text("Hide details");
			$("#err_details").show();
		}
		else {
			$("#show_hide").attr("data-status", "hidden").text("Show details");
			$("#err_details").hide();
		}
	});
</script>


<%@include file="footer.txt" %>







