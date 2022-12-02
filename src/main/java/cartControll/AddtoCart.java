package cartControll;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import model.Cart;
import model.Category;
import model.Product;
/**
 * Servlet implementation class AddtoCart
 */
@WebServlet("/AddtoCart")
public class AddtoCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
		int productId=Integer.parseInt(request.getParameter("productId"));
		String pid=request.getParameter("productId");
		
//		List<Product> plist= new ArrayList<>();
//		ProductDao pdao= new ProductDao();
//		List<Category> clist= new ArrayList<>();
		int quanity;
		List<Cart> cartList= new ArrayList<>();
		
//		Product pd= new Product();
//		pd=pdao.getProductById(pid);
//		Cart cart= new Cart(pd.getProductId(), pd.getProductName(), pd.getCategoryId(), pd.getProductPrice(), pd.getImage());
		Cart cart= new Cart();
		cart.setProductId(productId);
		cart.setQuantity(1);
		
		HttpSession session = request.getSession();
		ArrayList<Cart> cartListSS = (ArrayList<Cart>) session.getAttribute("cartListSS");
		if(cartListSS == null) {
			cartList.add(cart);
			session.setAttribute("cartListSS", cartList);
			response.sendRedirect("DisplayProductServlet");
		} else {
			cartList = cartListSS;
			
			boolean exist= false;
			for(Cart c: cartListSS) {
				if(c.getProductId() == productId) {
					exist= true;
//					out.println("<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='ManageCartServlet'>GO to Cart Page</a></h3>");
					quanity=c.getQuantity()+1;
					c.setQuantity(quanity);
					System.out.println(c.getQuantity());
//					request.setAttribute("index", 1);
//					request.getRequestDispatcher("ManageCartServlet").forward(request, response);
					response.sendRedirect("ManageCartServlet");
				}
			}
			if(!exist) {
				cartList.add(cart);
				response.sendRedirect("DisplayProductServlet");
			}
//			
//			for(Cart c: cartList) {
//				System.out.println(c+"1");
//			}
		}
		}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
