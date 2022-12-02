<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

  	<title>Insert title here</title>
  	<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="./css/managerUser.css">
</head>
<body>

	<div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Edit <b>Product</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="SaveEditUser" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Edit User</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">	
	                            	<c:set var="dto" value="${requestScope.userr}" />
											
	                                <div class="form-group">
	                                   <label>Id</label>
										<input value="${dto.userId}" name="userId" readonly="readonly" type="text" class="form-control" required>
	                                </div>
	                                <div class="form-group">
	                                   <label>Username</label>
										<input value="${dto.username}" name="username" type="text" class="form-control" required>
	                                </div>
	                                <div class="form-group">
	                                    <label>Password</label>
										<input  value="${dto.password}" name="password" type="text" class="form-control" required>
	                                </div>
	                                <div class="form-group">
	                                   <label>Role</label>
										<input  ${dto.role == 0?'checked':''}  type="radio" name="role" value="0"> User
										<input  ${dto.role == 1?'checked':''} type="radio" name="role" value="1"> Admin
	                                </div>
	                                <div class="form-group">
	                                  	<label>FullName</label>
										<input  value="${dto.fullName}" name="fullName" type="text" class="form-control" required>
	                                </div>
	                            
                            </div>
                            
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Edit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>

 <script src="./js/managerUser.js" type="text/javascript"></script>
</body>
</html>