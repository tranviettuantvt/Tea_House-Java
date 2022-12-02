<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
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
            .hint-total {
            	font-size: 20px;
            	float: left;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div  class="table-title">
                    <div style="display: flex;align-items: center; class="row">
                        <div class="col-sm-6">
                            <h2 >Manage <b>Order</b></h2>
                            
                        </div>
                        <div class="col-sm-6">
                           <a href="DisplayProductServlet" style="color:green;" class="btn btn-home" ><i class="fa-solid fa-house-user"></i> <span>Home Page</span></a>					
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                        <th >Id</th>
						<th >User</th>
						<th >Product</th>
						<th >Quantity</th>
						<th >Product</th>
						<th >Order Date</th>
						<th >Cancel</th>
						
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.olist}" var="o">
                            <tr>
                            	<td>${o.orderId}</td>
                            	<c:forEach items="${requestScope.user}" var="u">
                            		<c:if test="${o.userId == u.userId}">
                                		<td>${u.fullName}</td>
                                	</c:if>
                                </c:forEach>
                                <td>${o.productName }</td>
                                <td>${o.quantity }</td>
                                <td>${o.productPrice }</td>
								<td>${o.orderDate }</td>
								<td><a href="DeleteFromOrder?oid=${o.orderId}" style="color: white;" class="btn btn-sm btn-success">Remove</a></td>
                                
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="clearfix">
                    <div  class="hint-total">Total Price:  <span class="text-success">$ ${total>0 ? total : 0}</span></div>
                   <ul class="pagination">
                    	<c:if test="${index>1}">
                    		<li class="page-item "><a href="ManageOrderServlet?index=${index-1}">Previous</a></li>
	                    </c:if>
	                    <c:forEach begin="1" end="${endPage}" var="i">
	                        <li class="page-item ${index == i ? 'active' :'' }"><a href="ManageOrderServlet?index=${i}">${i}</a></li>
	                    </c:forEach>
	                    <c:if test="${index < endPage}">
	                    	<li class="page-item"><a href="ManageOrderServlet?index=${index+1}" class="page-link">Next</a></li>
	                   	</c:if>
                    </ul>
                </div>
            </div>
      

        </div>
        <!-- Edit Modal HTML -->
        
   <script src="./js/managerUser.js" type="text/javascript"></script>
</body>
</html>