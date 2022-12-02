<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="./css/managerUser.css">
        <style>
            img{
                width: 200px;
                height: 120px;
            }
            
            .btn-home {
			    color: green;
			    background-color: #f8f9fa;
			    border-color: #f8f9fa;
			    padding: 8px;
			    border-radius: 4px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Manage <b>User</b></h2>
                        </div>
                        <div class="col-sm-6">
                           <a href="DisplayProductServlet" style="color:green;" class="btn btn-home" ><i class="fa-solid fa-house-user"></i> <span>Home Page</span></a>					
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            
						<th>Id</th>
						<th>Full Name</th>
						<th>User Name</th>
						<th>Password</th>
						<th>Role</th>
						<th>Actions</th>
					
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${ulist}" var="u">
                            <tr>
                                <td>${u.userId}</td>
								<td>${u.fullName }</td>
								<td>${u.username }</td>
								<td>${u.password}</td>
								<td>${u.role == 1 ?'Admin':'User'}</td>
                                <td>
                                    <a href="LoadEditUser?userId=${u.userId}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                    <a href="DeleteUserServlet?userId=${u.userId}" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="clearfix">
                    <div class="hint-text">Showing <b>5</b> out of <b class="text-success">${ucount}</b> entries</div>
                	<ul class="pagination">
                    	<c:if test="${index>1}">
                    		<li class="page-item "><a href="ManageUserServlet?index=${index-1}">Previous</a></li>
	                    </c:if>
	                    <c:forEach begin="1" end="${endPage}" var="i">
	                        <li class="page-item ${index == i ? 'active' :'' }"><a href="ManageUserServlet?index=${i}">${i}</a></li>
	                    </c:forEach>
	                    <c:if test="${index < endPage}">
	                    	<li class="page-item"><a href="ManageUserServlet?index=${index+1}" class="page-link">Next</a></li>
	                   	</c:if>
                    </ul>
                </div>
            </div>
      

        </div>
        <!-- Edit Modal HTML -->
        
   <script src="./js/managerUser.js" type="text/javascript"></script>
</body>
</html>
