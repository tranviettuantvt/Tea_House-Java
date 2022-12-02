package cartControll;

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
import dao.ProductDao;
import model.Cart;
import model.Category;
/**
 * Servlet implementation class ManageCartServlet
 */
@WebServlet("/ManageCartServlet")
public class ManageCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Cart> cartListSS = (ArrayList<Cart>) request.getSession().getAttribute("cartListSS");
		ProductDao pdao = new ProductDao();
		List<Category> clist= new ArrayList<>();
		
//		String indexP=request.getParameter("index");
//		if(indexP == null) {
//			indexP="1";
//		}
//		int index=Integer.parseInt(indexP);
		try {
			CartDao cDao= new CartDao(DbCon.getConnection());
			List<Cart> cartProduct = new ArrayList<>();
//			List<Cart> cartProductPaging = new ArrayList<>();
			if (cartListSS != null) {
				cartProduct = cDao.getCartProduct(cartListSS);
				double total = cDao.getTotalCartPrice(cartListSS);
				clist=pdao.getListCategory();
//				for(Cart c: cartProduct) {
//					System.out.println(c+"1");
//				}
//				
//				int cartcount=cartProduct.size();
//				int endPage= cartcount/5;
//				if(cartcount % 5!=0) {
//					endPage++;
//				} 
//				cartProductPaging=cDao.pagingCart(index, cartProduct);
//				System.out.println("index: "+index);
//				for(Cart a: cartProductPaging) {
//					System.out.println(a+"2");
//				}
//				request.setAttribute("index", index);
//				request.setAttribute("endPage", endPage);
//				
				request.setAttribute("cateList", clist);
				request.setAttribute("total", total);
				request.setAttribute("cartProduct", cartProduct);
				request.getRequestDispatcher("cart.jsp").forward(request, response);
			} else {
				response.sendRedirect("cart.jsp");
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
