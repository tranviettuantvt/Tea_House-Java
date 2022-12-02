<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="dao.*"%>
<%@page import="connection.*"%>
<%
	
	User user = (User) request.getSession().getAttribute("user");
	if (user != null) {
	    request.setAttribute("person", user);
	}
	ArrayList<Cart> cartListSS = (ArrayList<Cart>) session.getAttribute("cartListSS");
	List<Cart> cartProduct = null;
	if (cartListSS != null) {
		CartDao cDao = new CartDao(DbCon.getConnection());
		cartProduct = cDao.getCartProduct(cartListSS);
		double total = cDao.getTotalCartPrice(cartListSS);
		request.setAttribute("total", total);
		request.setAttribute("cart_list", cartListSS);
}
%>
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
                            <h2>Manage <b>Cart</b></h2>
                            <h3>Total Price: $ ${total>0 ? total : 0} </h3>
                        </div>
                        <div class="col-sm-6">
                           <a href="DisplayProductServlet" style="color:green;" class="btn btn-home" ><i class="fa-solid fa-house-user"></i> <span>Home Page</span></a>					
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            
						<th >Name</th>
						<th >Category</th>
						<th >Price</th>
						<th >Buy Now</th>
						<th >Cancel</th>
						
                        </tr>
                    </thead>
                    <tbody>
			                <%
							if (cartListSS != null) {
								for (Cart c : cartProduct) {
							%>
                            <tr>
                                <td><%=c.getProductName()%></td>
								<td><%=c.getCategoryId()%></td>
								<td><%=c.getProductPrice()%></td>
								<td>
									<form action="order-now" method="post" class="form-inline">
										<input type="hidden" name="id" value="${c.productId}" class="form-input">
										<div class="form-group d-flex justify-content-between">
											<a class="btn bnt-sm btn-incre" href="quantity-inc-dec?action=inc&id=<%=c.getProductId()%>"><i class="fas fa-plus-square"></i></a> 
												<input type="text" name="quantity" class="form-control"  value="<%=c.getQuantity()%>" readonly> 
											<a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=dec&id=<%=c.getProductId()%>"><i class="fas fa-minus-square"></i></a>
										</div>
										<button type="submit" class="btn btn-primary btn-sm">Buy</button>
									</form>
								</td>
								<td><a href="remove-from-cart?id=${c.productId}" class="btn btn-sm btn-danger">Remove</a></td>
                                <%
								}}%>
                            </tr>
                        
                    </tbody>
                </table>
                <div class="clearfix">
                    <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                    <ul class="pagination">
                        <li class="page-item disabled"><a href="#">Previous</a></li>
                        <li class="page-item"><a href="#" class="page-link">1</a></li>
                        <li class="page-item"><a href="#" class="page-link">2</a></li>
                        <li class="page-item active"><a href="#" class="page-link">3</a></li>
                        <li class="page-item"><a href="#" class="page-link">4</a></li>
                        <li class="page-item"><a href="#" class="page-link">5</a></li>
                        <li class="page-item"><a href="#" class="page-link">Next</a></li>
                    </ul>
                </div>
            </div>
      

        </div>
        <!-- Edit Modal HTML -->
        
   <script src="./js/managerUser.js" type="text/javascript"></script>
</body>
</html>