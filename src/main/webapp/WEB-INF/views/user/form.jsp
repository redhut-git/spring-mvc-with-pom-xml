<%@ include file="../global/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.7.1.js" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <title>Create Account</title>
    
    <style type="text/css">
    * {
    	padding: 0;
    	margin: 0;
    	box-sizing: border-box;
    }
    body {
	    height: 100vh;
	    display: flex;
	    align-items: center;
	    justify-content: center;
	}
	.container {
		width: min(100%, 50rem);
	}
    </style>
</head>
<body>
    <div class="container">
    	<form:form id="form" action="save.htm" commandName="userForm">
	    	<form:hidden path="id"/>
	    	<div class="row m-auto">
	    		<div class="col-12 mb-3">
	    			<form:input path="fullName" class="form-control" required="required"/>
	    		</div>
	    		<div class="col-md-6 mb-3">
	    			<form:input path="username" class="form-control" required="required"/>
	    		</div>
	    		<div class="col-md-6 mb-3">
	    			<form:input type="password" path="password" class="form-control" required="required"/>
	    		</div>
	    		
	    		<div class="col-12"> 
	    			<button type="submit" class="btn btn-primary w-100">Save</button>
    			</div>
	    	</div>
	    </form:form>
    </div>
    
    <jsp:include page="../global/errorMessage.jsp"/>
    <script type="text/javascript">
    $(document).ready(function() {
    	setTimeout(() => {
        	$("#fullName").val("");
            $("#username").val("");
            $("#password").val("");
    	}, 500);
	});
    </script>
</body>
</html>