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
import model.Category;
import model.Product;
/**
 * Servlet implementation class DisplayProductServlet
 */
@WebServlet("/DisplayProductServlet")
public class DisplayProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> plist= new ArrayList<>();
		ProductDao pdao= new ProductDao();
		
		List<Category> clist= new ArrayList<>();
		
		try {
			clist=pdao.getListCategory();
			plist= pdao.getListProduct();
			request.setAttribute("listCategory", clist);
			request.setAttribute("listProduct", plist);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		catch (Exception e) {
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
