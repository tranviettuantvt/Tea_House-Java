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
                            <h2>Manage <b>Product</b></h2>
                        </div>
                        <div class="col-sm-6">
                        	<a href="#addEmployeeModal" style="color:green;" class="btn btn-home" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
                           <a href="DisplayProductServlet" style="color:green;" class="btn btn-home" ><i class="fa-solid fa-house-user"></i> <span>Home Page</span></a>					
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            
						<th>Id</th>
						<th>Product Name</th>
						<th>Category Id</th>
						<th>Product Price</th>
						<th>Image</th>
						<th>Actions</th>
					
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listProduct}" var="p">
                            <tr>
                                <td>${p.productId}</td>
								<td>${p.productName }</td>
								<c:forEach items="${cateList}" var="c">
									<c:if test="${p.categoryId == c.categoryId}">
										<td>${c.categoryName}</td>
									</c:if>
								</c:forEach>
								<td>${p.productPrice}</td>
								<td><img alt="" src="${p.image}"> </td>
                                <td>
                                    <a href="LoadEditProduct?productId=${p.productId}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                    <a href="DeleteProductServlet?productId=${p.productId}" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="clearfix">
                    <div class="hint-text">Showing <b>5</b> out of <b class="text-success">${pcount}</b> entries</div>
                    <ul class="pagination">
                    	<c:if test="${index>1}">
                    		<li class="page-item "><a href="ManageProductServlet?index=${index-1}">Previous</a></li>
	                    </c:if>
	                    <c:forEach begin="1" end="${endPage}" var="i">
	                        <li class="page-item ${index == i ? 'active' :'' }"><a href="ManageProductServlet?index=${i}">${i}</a></li>
	                    </c:forEach>
	                    <c:if test="${index < endPage}">
	                    	<li class="page-item"><a href="ManageProductServlet?index=${index+1}" class="page-link">Next</a></li>
	                   	</c:if>
                    </ul>
                </div>
            </div>
      

        </div>
        <!-- Edit Modal HTML -->
         <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="SaveInsertProduct" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
<!--                             <div class="form-group"> -->
<!--                                 <label>productId</label> -->
<!--                                 <input name="productId" type="text" class="form-control" required> -->
<!--                             </div> -->
                            <div class="form-group">
                                <label>productName</label>
                                <input name="productName" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input name="productPrice" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Image URL</label>
                                <input name="image" type="text" class="form-control" required>
                            </div>
                         
                            <div class="form-group">
                                <label>Category</label>
                                <select name="category" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${cateList}" var="c">
                                        <option value="${c.categoryId}">${c.categoryName}</option>
                                    </c:forEach>
                                </select>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
   <script src="./js/managerUser.js" type="text/javascript"></script>
</body>
</html>
