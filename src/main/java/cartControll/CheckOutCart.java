package cartControll;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.DbCon;
import dao.OrderDao;
import model.*;
/**
 * Servlet implementation class ManageOrderServlet
 */
@WebServlet("/CheckOutCart")
public class CheckOutCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        
        String strDate= formatter.format(date); 
        
        
		List<Order> olist= new ArrayList<>();
		ArrayList<Cart> cartListSS = (ArrayList<Cart>) request.getSession().getAttribute("cartListSS");
		User user = (User) request.getSession().getAttribute("user");
		
		if(cartListSS !=null && user !=null) {
			for(Cart c: cartListSS) {
				Order order= new Order();
				order.setProductId(c.getProductId());
				order.setUserId(user.getUserId());
				order.setQuantity(c.getQuantity());
				order.setOrderDate(strDate);
				
				OrderDao odao= new OrderDao(DbCon.getConnection());
				boolean result= odao.insertOrder(order.getUserId(), order.getProductId(),order.getQuantity(), order.getOrderDate());
				System.out.println(user.getUserId() +" 3");
				if(!result) break;
			
			}
			cartListSS.clear();
			response.sendRedirect("ManageOrderServlet");
			
		} else {
			if(user == null) {
				response.sendRedirect("login.jsp");
			}
			response.sendRedirect("ManageCartServlet");
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
