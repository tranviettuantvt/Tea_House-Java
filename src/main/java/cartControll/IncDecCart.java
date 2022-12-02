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
 * Servlet implementation class IncDecCart
 */
@WebServlet("/IncDecCart")
public class IncDecCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("id"));
		ArrayList<Cart> cartListSS = (ArrayList<Cart>) request.getSession().getAttribute("cartListSS");
		
		if(action != null && id>=1) {
			if(action.equals("inc")) {
				for(Cart c: cartListSS) {
					if(c.getProductId()==id) {
						int quantity=c.getQuantity();
						quantity++;
						c.setQuantity(quantity);
						response.sendRedirect("ManageCartServlet");
					}
				}
			}if(action.equals("des")) {
				for(Cart c: cartListSS) {
					if(c.getProductId()==id && c.getQuantity() > 1) {
						int quantity =c.getQuantity();
						quantity--;
						c.setQuantity(quantity);
						break;
					} 
				}
				response.sendRedirect("ManageCartServlet");
			}
		}else {
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
