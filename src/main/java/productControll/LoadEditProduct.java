package productControll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dao.UserDao;
import model.Product;
import model.Category;

/**
 * Servlet implementation class LoadEditProduct
 */
@WebServlet("/LoadEditProduct")
public class LoadEditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid= request.getParameter("productId");
		ProductDao pdao= new ProductDao();
		UserDao udao= new UserDao();
		List<Product> plist= new ArrayList<>();
		List<Category> clist= new ArrayList<>();
		request.setCharacterEncoding("UTF-8");
		try {
			Product p=pdao.getProductById(pid);
			clist=udao.getListCategory(); 
			
			request.setAttribute("clist", clist);
			request.setAttribute("product", p);
			request.getRequestDispatcher("editProduct.jsp").forward(request, response);
			
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
