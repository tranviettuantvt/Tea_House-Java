<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
	<style type="text/css">
		.bg-image-vertical {
		position: relative;
		overflow: hidden;
		background-repeat: no-repeat;
		background-position: right center;
		background-size: auto 100%;
		}
		
		@media (min-width: 1025px) {
		.h-custom-2 {
		height: 100%;
		}
	}
	</style>
</head>

<body>
	<section class="vh-100" style="background-color: #4d8a54;">
	  <div class="container py-5 h-100">
	    <div class="row d-flex justify-content-center align-items-center h-100">
	      <div class="col col-xl-10">
	        <div class="card" style="border-radius: 1rem;">
	          <div class="row g-0">
	            <div class="col-md-6 col-lg-5 d-none d-md-block">
	              <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img1.webp"
	                alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
	            </div>
	            <div class="col-md-6 col-lg-7 d-flex align-items-center">
	              <div class="card-body p-2 p-lg-5 text-black">
	
	                <form action="SignUpFormServlet" method="post">
					 
<!-- 	                  <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign up new account</h5> -->
						
					  <div class="form-outline mb-2">
	                    <input name="fullname" type="text" id="form2Example17" class="form-control form-control-lg" />
	                    <label class="form-label" for="form2Example17">FullName</label>
	                  </div>
	                  
	                  <div class="form-outline mb-2">
	                    <input name="username" type="text" id="form2Example17" class="form-control form-control-lg" />
	                    <label class="form-label" for="form2Example17">Username</label>
	                  </div>
	
	                  <div class="form-outline mb-2">
	                    <input name="password" type="password" id="form2Example27" class="form-control form-control-lg" />
	                    <label class="form-label" for="form2Example27">Password</label>
	                  </div>
	                  
	                  <div class="form-outline mb-2">
	                    <input name="repassword" type="password" id="form2Example27" class="form-control form-control-lg" />
	                    <label class="form-label" for="form2Example27">Repeat Password</label>
	                  </div>
						<h5 class="text-danger">${error}</h5>
	                  <div class="pt-1 mb-3">
	                    <button class="btn btn-dark btn-lg btn-block" type="submit">Sign Up</button>
	                  </div>
					 <a href="login.jsp" class="small text-muted">Back to Login</a> 
	                </form>
	
	              </div>
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	</section>
</body>
</html>