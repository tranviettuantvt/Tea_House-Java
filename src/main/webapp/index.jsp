<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%
	User user = (User) request.getSession().getAttribute("user");
	if (user != null) {
	    request.setAttribute("person", user);
	}
	
	ArrayList<Cart> cartListSS = (ArrayList<Cart>) session.getAttribute("cartListSS");
	if (cartListSS != null) {
		request.setAttribute("cartListSS", cartListSS);
}
%>
<!DOCTYPE html>	
<html lang="en">
<head>
	<meta charset="UTF-8">
	 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tea House Web</title>
   	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
   	<link rel="stylesheet" href="./assets/fonts/fontawesome-free-6.2.0-web/css/all.min.css">
    <link rel="stylesheet"
  	href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
  	<link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600&family=Poppins:wght@100;200;300;400;500;600;700;800;900&family=Quicksand:wght@300;400;500;600;700&family=Roboto:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
 
	<link rel="stylesheet" href="./css/base.css">
	<link rel="stylesheet" href="./css/grid.css">
	<link rel="stylesheet" href="./css/main.css">
	
</head>
<body>
    <div class="app">
        <!-- Start header -->
        <div id="header">
            <!-- Nav bar -->
            <div class="header__navbar-wrap">
                <div class="grid wide ">
                    
                    <div class="header__navbar hide-on-mobile-and-tablet">
                        <ul class="header__navbar-list">
                            <li class="header__navbar-item">
                                <img src="	" alt="" class="header__navbar-img">
                            </li>
                            <li class="header__navbar-item">
                                <a href="#" class="header__navbar-link-left">Hotline:</a>
                            </li>
                            <li class="header__navbar-item">
                                <a href="#" class="header__navbar-link-left header__navbar-link-number">0338455991</a>
                            </li>
                             <li class="header__category-item">
                           		 <a style="color: white; margin-left: 12px; font-size: 1.4rem;" href="DisplayProductServlet" class="header__navbar-link-left">   Trang ch???</a>
                        	</li>
                        </ul>
    
                        <ul class="header__navbar-list">
                            <li class="header__navbar-item">
                                
                            </li>
                            <li class="header__navbar-item navbar-item-display">
                                <a href="#" class="header__navbar-link-right">
                                    <i class="header__navbar-icon bx bx-search" style="font-weight:600 ;"></i>
                                    T??m ki???m
                                </a>
                                <form action="SearchProductServlet" method="post">
	                                <div class="header__navbar-search">
	                                    <input class="header__navbar-search-input" type="text" name="search" placeholder="T??m ki???m..." value="${pname}">
	                                    <button type="submit" class="header__navbar-search-btn">
	                                    	<i class="header__navbar-search-icon bx bx-search" style="font-weight:600 ;"></i>
	                                    </button>
	                                 </div>
                                </form>
                            </li>
                            <c:if test="${sessionScope.user == null}">
	                            <li class="header__navbar-item navbar-item-display">
	                                <a href="#" class="header__navbar-link-right ">
	                                    <i class="header__navbar-icon bx bxs-user"></i>
	                                    T??i Kho???n
	                                </a>
	                                <div class="user__notify">
	                                    <ul class="user__notify-list">
	                                        <li class="user__notify-item">
	                                            <a href="signup.jsp" class="user__notify-link">????ng k??</a>
	                                        </li>
	                                        <li class="user__notify-item">
	                                            <a href="login.jsp" class="user__notify-link">????ng nh???p</a>
	                                        </li>
	                                    </ul>
	                                </div>
	                            </li>
                            </c:if>
                            <c:if test="${sessionScope.user !=null}">
                             	<li class="header__navbar-item navbar-item-display">
	                                <a href="#" class="header__navbar-link-right ">
	                                    <i class="header__navbar-icon bx bxs-user"></i>
	                                    Hello ${sessionScope.user.fullName}
	                                </a>
	                                <div class="user__notify">
	                                    <ul class="user__notify-list">
	                                        <li class="user__notify-item">
	                                            <a href="LogoutFormServlet" class="user__notify-link">Lo-gout</a>
	                                        </li>
	                                       
	                                    </ul>
	                                </div>
                            	</li>
                            </c:if>
                            
                            <li class="header__navbar-item navbar-item-display">
                                <a href="ManageCartServlet" class="header__navbar-link-right">
                                    <i class='header__navbar-icon bx bx-shopping-bag'></i>
                                    <span class="header__navbar-icon-quantity">${cartListSS.size()}</span>
                                    Gi??? h??ng
                                </a>
                                <div class="header__cart-no-cart">
                                    <div class="header__cart-no-cart-img">
                                        <img src="https://images.app.goo.gl/YLaQSNe9evetJRTf8" alt="">
                                    </div>
                                    
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>    
            </div>
            <!-- End navbar -->
            
            <!-- category -->
            
            <div class="grid wide">
                <div class="header__category hide-on-mobile-and-tablet">
                    <ul class="header__category-list">
                        <li class="header__category-item">
                            <a href="DisplayProductServlet" class="header__category-link header__category-link--active">Trang ch???</a>
                        </li>
                        <li class="header__category-item">
                            <a href="" class="header__category-link">Gi???i thi???u</a>
                        </li>
                        
                        <li class="header__category-item">
                            <a href="" class="header__category-link">S???n ph???m
                                <i class='header__category-icon bx bxs-down-arrow' ></i>
                            </a>

                            <ul class="header__category-menu">
                            <c:set var="c" value="${requestScope.listCategory}" />
							<c:forEach var="ca" items="${c}" varStatus="counter">
                                <li class="header__category-menu-item">
                                    <a href="ProductByCateIdServlet?categoryId=${ca.categoryId}" class="header__category-menu-link ${cid == ca.categoryId ? 'active':''}">${ca.categoryName }</a>
                                </li>
                             </c:forEach>
                            </ul>
                        </li>
                        
                        
                    </ul>
                    <div class="header_-category-img">
                        <a href="" class="header__category-link">
                            <img src="https://uptoaltar.github.io/TeaHouse/assets/img/logo.webp" alt="">
                        </a>
                    </div>
                    <ul class="header__category-list">
                    	<c:if test="${sessionScope.user.role==1}">
	                    	<li class="header__category-item">
	                            <a href="ManageUserServlet" class="header__category-link">Qu???n L?? TK</a>
	                        </li>
	                        <li class="header__category-item">
	                            <a href="ManageProductServlet" class="header__category-link">Qu???n L?? SP</a>
	                        </li>
                   		</c:if>
                    	<c:if test="${sessionScope.user.role!=1}">
	                        <li class="header__category-item">
	                            <a href="" class="header__category-link">Tin t???c</a>
	                        </li>
	                        <li class="header__category-item">
	                            <a href="" class="header__category-link">Khuy???n m??i</a>
	                        </li>
                        </c:if>
                        <li class="header__category-item">
                            <a href="" class="header__category-link">Th???c ????n</a>
                        </li>
                        <li class="header__category-item">
                            <a href="ManageOrderServlet" class="header__category-link">Qu???n L?? Order</a>
                        </li>
                       
                         
                    </ul>
                </div>
            </div>
  
  			 <!--end category-->
        </div>

       <div id="slider">
            <img src="https://uptoaltar.github.io/TeaHouse/assets/img/slider_1.webp" alt="">
        </div>

        <!-- body -->
        <div id="app__container">
           
            <div class="body__menu-wrap">
                <div class="grid wide">
                	<!-- body logo -->
                 	<div class="content__header">
                        <div class="content__header-logo">
                            <img src="https://uptoaltar.github.io/TeaHouse/assets/img/title_base.webp" alt="">
                        </div>
                        <div class="content__header-title">DANH M???C S???N PH???M</div>
                    </div>
                    <!-- end body logo -->
                    
                    <!-- body-Category -->
                    <ul class=" body__menu-nav">
                    	<c:set var="c" value="${requestScope.listCategory}" />
						<c:forEach var="ca" items="${c}" varStatus="counter">
	                        <li class="body__menu-nav-item ">
	                            <a href="ProductByCateIdServlet?categoryId=${ca.categoryId}"><div class="body__menu-nav-link ${cid == ca.categoryId ? 'active':''}">${ca.categoryName}</div></a>
	                        </li>
	                   	</c:forEach> 
           
                    </ul>
                    <!-- end body Category -->
                    
                    <!-- body Product -->
                    <ul class="row body__menu-list">
                    	<c:set var="p" value="${requestScope.listProduct}" />
						<c:forEach var="dto" items="${p}" varStatus="counter">
	                        <li class="col l-3 m-4 c-6 body__menu-list-item">
	                            <a href="AddtoCart?productId=${dto.productId}" class="body__menu-list-link">
	                                <div class="body__menu-list-link-img-btn">
	                                    <img src="${dto.image}" alt="">
	                                    <button class="body__menu-list-link-btn">Th??m v??o gi??? h??ng</button>
                            		</div>
	                                
	                                <p class="body__menu-list-link-desc">${dto.productName}</p>
	                                <p class="body__menu-list-link-price">Gi??: <span>
	                                    ${dto.productPrice}
	                                </span></p>
	                                
	                            </a>
	                        </li>
                        </c:forEach>
                        
                    </ul>
                   
                	<!-- end body Product -->
                </div>
            </div>

        </div>

        <div id="footer">
            <div class="grid wide">
                <ul class="row footer__list">
                    <li class="col l-4 m-12 c-12 footer__list-item">
                        <a href="" class="header__category-link footer-logo" style="display:block ;">
                            <img src="https://uptoaltar.github.io/TeaHouse/assets/img/logo.webp" alt="">
                        </a>
                        <p class="footer__list-item-desc footer__list-item-desc--margin">Ch??ng t??i mong mu???n Tea House s??? tr??? th??nh ???Nh?? Tr??", n??i m???i ng?????i x??ch l???i g???n nhau v?? t??m th???y ni???m vui, s??? s??? chia th??n t??nh b??n nh???ng t??ch c?? ph?? ???????m h????ng, ch???t l?????ng.</p>
                        <div class="footer__list-item-icon">
                            <a href="" class="footer__list-item-icon-link">
                                <i class='bx bxl-twitter'></i>
                            </a>
                            <a href="" class="footer__list-item-icon-link">
                                <i class='bx bxl-facebook-circle'></i>
                            </a>
                            <a href="" class="footer__list-item-icon-link">
                                <i class='bx bxl-tiktok'></i>
                            </a>
                            <a href="" class="footer__list-item-icon-link">
                                <i class='bx bxl-instagram'></i>
                            </a>
                            <a href="" class="footer__list-item-icon-link">
                                <i class='bx bxl-youtube'></i>
                            </a>
                        </div>
                    </li>
                    <li class="col l-4 m-6 c-12 footer__list-item">
                        <div class="footer__list-item-header">LI??N H??? V???I CH??NG T??I</div>
                        <ul class="footer__list-item-text footer__list-item-desc--2">
                            <li class="footer__list-item-text-icon"><i class='bx bxs-location-plus' ></i></li>
                            <li class="footer__list-item-desc ">?????a ch???: T??ng 6 to?? nh?? Ladeco, 266 ?????i C???n, ph?????ng Li???u Giai, H?? N???i, Vietnam</li>
                        </ul>
                        <ul class="footer__list-item-text">
                            <li class="footer__list-item-text-icon"><i class='bx bxs-phone' ></i></li>
                            <li class="footer__list-item-text-desc" >
                                <p class="footer__list-item-desc">Hotline ?????t b??n: 1900 6750</p>
                                <p class="footer__list-item-desc">Hotline giao h??ng: 1900 6750</p>

                            </li>
                        </ul>

                    </li>
                    <li class="col l-4 m-6 c-12 footer__list-item">
                        <div class="footer__list-item-header">????NG K?? NH???N KHUY???N M??I</div>
                        <p class="footer__list-item-desc footer__list-item-desc--margin">?????ng b??? l??? nh???ng s???n ph???m v?? ch????ng tr??nh khuy???n m??i h???p d???n</p>
                        <div class="footer__list-item-sign">
                            <input type="email" placeholder="Email c???a b???n" class="footer__list-item-sign-email">
                            <button class="footer__list-item-sign-login" >????ng k??</button>
                        </div>
                    </li>
                </ul>    
            </div>
            <div class="footer__last">
                <p class="footer__last-text footer__last-text--after">?? B???n quy???n thu???c v??? Cafein Team  </p>
                <p class="footer__last-text">Cung c???p b???i <a href="#">Sapo</a></p>
            </div>
        </div>

        <div class="go-to-head">
            <a href="#header" title="L??n ?????u trang"><i class='bx bxs-chevron-up-circle'></i></a>
        </div>
    </div>

   
</body>
</html>