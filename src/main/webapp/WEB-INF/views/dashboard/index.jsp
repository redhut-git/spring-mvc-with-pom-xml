<%@ include file="../global/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    
    <!-- Data Table CSS -->
	<link rel="stylesheet" href="https://cdn.datatables.net/2.1.2/css/dataTables.bootstrap5.css">
	
	<!-- Data Table JS -->
	<script src="https://cdn.datatables.net/2.1.2/js/dataTables.js"></script>
	<script src="https://cdn.datatables.net/2.1.2/js/dataTables.bootstrap5.js"></script>
    <title>Home</title>
</head>
<body>
	<div class="container">
		<table id="employeeList" class="table table-striped" style="width:100%">
	    	<thead>
	    		<th>Full Name</th>
	    		<th>Username</th>
	    	</thead>
	    	<tbody>
	    		<c:forEach items="${users}" var="user">
	    			<tr>
		    			<td>${user.fullName}</td>
		    			<td>${user.username}</td>
		    		</tr>
	    		</c:forEach>
	    	</tbody>
	    </table>
	</div>
	    
    <script type="text/javascript">
    new DataTable('#employeeList');
    </script>
</body>
</html>