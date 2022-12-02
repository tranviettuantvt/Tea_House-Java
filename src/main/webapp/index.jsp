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
                           		 <a style="color: white; margin-left: 12px; font-size: 1.4rem;" href="DisplayProductServlet" class="header__navbar-link-left">   Trang chủ</a>
                        	</li>
                        </ul>
    
                        <ul class="header__navbar-list">
                            <li class="header__navbar-item">
                                
                            </li>
                            <li class="header__navbar-item navbar-item-display">
                                <a href="#" class="header__navbar-link-right">
                                    <i class="header__navbar-icon bx bx-search" style="font-weight:600 ;"></i>
                                    Tìm kiếm
                                </a>
                                <form action="SearchProductServlet" method="post">
	                                <div class="header__navbar-search">
	                                    <input class="header__navbar-search-input" type="text" name="search" placeholder="Tìm kiếm..." value="${pname}">
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
	                                    Tài Khoản
	                                </a>
	                                <div class="user__notify">
	                                    <ul class="user__notify-list">
	                                        <li class="user__notify-item">
	                                            <a href="signup.jsp" class="user__notify-link">Đăng ký</a>
	                                        </li>
	                                        <li class="user__notify-item">
	                                            <a href="login.jsp" class="user__notify-link">Đăng nhập</a>
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
                                    Giỏ hàng
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
                            <a href="DisplayProductServlet" class="header__category-link header__category-link--active">Trang chủ</a>
                        </li>
                        <li class="header__category-item">
                            <a href="" class="header__category-link">Giới thiệu</a>
                        </li>
                        
                        <li class="header__category-item">
                            <a href="" class="header__category-link">Sản phẩm
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
	                            <a href="ManageUserServlet" class="header__category-link">Quản Lí TK</a>
	                        </li>
	                        <li class="header__category-item">
	                            <a href="ManageProductServlet" class="header__category-link">Quản Lí SP</a>
	                        </li>
                   		</c:if>
                    	<c:if test="${sessionScope.user.role!=1}">
	                        <li class="header__category-item">
	                            <a href="" class="header__category-link">Tin tức</a>
	                        </li>
	                        <li class="header__category-item">
	                            <a href="" class="header__category-link">Khuyến mãi</a>
	                        </li>
                        </c:if>
                        <li class="header__category-item">
                            <a href="" class="header__category-link">Thực đơn</a>
                        </li>
                        <li class="header__category-item">
                            <a href="ManageOrderServlet" class="header__category-link">Quản Lí Order</a>
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
                        <div class="content__header-title">DANH MỤC SẢN PHẨM</div>
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
	                                    <button class="body__menu-list-link-btn">Thêm vào giỏ hàng</button>
                            		</div>
	                                
	                                <p class="body__menu-list-link-desc">${dto.productName}</p>
	                                <p class="body__menu-list-link-price">Giá: <span>
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
                        <p class="footer__list-item-desc footer__list-item-desc--margin">Chúng tôi mong muốn Tea House sẽ trở thành “Nhà Trà", nơi mọi người xích lại gần nhau và tìm thấy niềm vui, sự sẻ chia thân tình bên những tách cà phê đượm hương, chất lượng.</p>
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
                        <div class="footer__list-item-header">LIÊN HỆ VỚI CHÚNG TÔI</div>
                        <ul class="footer__list-item-text footer__list-item-desc--2">
                            <li class="footer__list-item-text-icon"><i class='bx bxs-location-plus' ></i></li>
                            <li class="footer__list-item-desc ">Địa chỉ: Tâng 6 toà nhà Ladeco, 266 Đội Cấn, phường Liễu Giai, Hà Nội, Vietnam</li>
                        </ul>
                        <ul class="footer__list-item-text">
                            <li class="footer__list-item-text-icon"><i class='bx bxs-phone' ></i></li>
                            <li class="footer__list-item-text-desc" >
                                <p class="footer__list-item-desc">Hotline đặt bàn: 1900 6750</p>
                                <p class="footer__list-item-desc">Hotline giao hàng: 1900 6750</p>

                            </li>
                        </ul>

                    </li>
                    <li class="col l-4 m-6 c-12 footer__list-item">
                        <div class="footer__list-item-header">ĐĂNG KÝ NHẬN KHUYẾN MÃI</div>
                        <p class="footer__list-item-desc footer__list-item-desc--margin">Đừng bỏ lỡ những sản phẩm và chương trình khuyến mãi hấp dẫn</p>
                        <div class="footer__list-item-sign">
                            <input type="email" placeholder="Email của bạn" class="footer__list-item-sign-email">
                            <button class="footer__list-item-sign-login" >Đăng ký</button>
                        </div>
                    </li>
                </ul>    
            </div>
            <div class="footer__last">
                <p class="footer__last-text footer__last-text--after">© Bản quyền thuộc về Cafein Team  </p>
                <p class="footer__last-text">Cung cấp bởi <a href="#">Sapo</a></p>
            </div>
        </div>

        <div class="go-to-head">
            <a href="#header" title="Lên đầu trang"><i class='bx bxs-chevron-up-circle'></i></a>
        </div>
    </div>

   
</body>
</html>