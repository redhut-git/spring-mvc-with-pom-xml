<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty successMsg}">
	<script>
		Swal.fire({
			title : "Registration Success!",
			text : '<%= session.getAttribute("successMsg")%>',
			icon : "Success"
		});
	</script>
</c:if>
<c:if test="${not empty errorMsg}">
	<script>
		Swal.fire({
			title : "Registration Error!",
			text : '<%= session.getAttribute("errorMsg")%>',
			icon : "Error"
		});
	</script>
</c:if>


<% 
session.setAttribute("successMsg", ""); 
session.setAttribute("errorMsg", ""); 
%>