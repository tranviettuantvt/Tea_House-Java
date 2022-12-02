package cartControll;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cart;

/**
 * Servlet implementation class DeleteFromCart
 */
@WebServlet("/DeleteFromCart")
public class DeleteFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String pid= request.getParameter("id");
		if(pid != null) {
			ArrayList<Cart> cartListSS = (ArrayList<Cart>) request.getSession().getAttribute("cartListSS");
			if(cartListSS !=null) {
				for(Cart c: cartListSS) {
					if(c.getProductId() == Integer.parseInt(pid)) {
						cartListSS.remove(cartListSS.indexOf(c));
						break;
					}
				}
			}
			response.sendRedirect("ManageCartServlet");
		} else {
			response.sendRedirect("ManageCartServlet");
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
