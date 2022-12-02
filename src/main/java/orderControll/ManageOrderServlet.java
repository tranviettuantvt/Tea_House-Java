package orderControll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.DbCon;
import dao.CartDao;
import dao.OrderDao;
import dao.UserDao;
import model.*;

/**
 * Servlet implementation class ManageOrderServlet
 */
@WebServlet("/ManageOrderServlet")
public class ManageOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String indexP=request.getParameter("index");
		if(indexP == null) {
			indexP="1";
		}
		int index=Integer.parseInt(indexP);
		
		try {
			UserDao udao= new UserDao();
			OrderDao orderDao  = new OrderDao(DbCon.getConnection());
			User user = (User) request.getSession().getAttribute("user");
			List<User> us= new ArrayList<>();
			ArrayList<Order> orders= new ArrayList<>();
			ArrayList<Order> orderPaging= new ArrayList<>();
			if(user != null ) {
				request.setAttribute("person", user);
			   
				int ocount=orderDao.getTotalOrder(user.getUserId());
				System.out.println(ocount+"---------");
				int endPage= ocount/5;
				if(ocount % 5!=0) {
					endPage++;
				}
				orders = (ArrayList<Order>) orderDao.getListOrderByUser(user.getUserId());
				orderPaging=(ArrayList<Order>) orderDao.pagingOrder(index, orders);
				
				double total = orderDao.getTotalOrderPrice(orders);
				for(Order o: orderPaging) {
					System.out.println(o);
				}
//				System.out.println(total+" total");
				
				request.setAttribute("index", index);
				request.setAttribute("ocount", ocount);
				request.setAttribute("endPage", endPage);
				us=udao.getListUser();
				request.setAttribute("total", total);
				request.setAttribute("user", us);
				request.setAttribute("olist", orderPaging);
				request.getRequestDispatcher("order.jsp").forward(request, response);
			}else{
				response.sendRedirect("login.jsp");
			}
		}catch (Exception e) {
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
