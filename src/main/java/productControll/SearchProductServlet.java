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
 * Servlet implementation class SearchProductServlet
 */
@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pname= request.getParameter("search");
		List<Product> plist= new ArrayList<>();
		ProductDao pdao= new ProductDao();
		
		List<Category> clist= new ArrayList<>();
		try {
			clist=pdao.getListCategory();
			plist= pdao.getListProductByName(pname);
			request.setAttribute("listCategory", clist);
			request.setAttribute("listProduct", plist);
			request.setAttribute("pname", pname);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
