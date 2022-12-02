package productControll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;

/**
 * Servlet implementation class SaveInsertProduct
 */
@WebServlet("/SaveInsertProduct")
public class SaveInsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		String pid= request.getParameter("productId");
		String pname=request.getParameter("productName");
		Double pprice=Double.parseDouble(request.getParameter("productPrice"));
		String image= request.getParameter("image");
		int categoryId=Integer.parseInt(request.getParameter("category"));
		
		ProductDao pdao= new ProductDao();
		try {
			pdao.insertProduct(pname, categoryId, pprice, image);
			response.sendRedirect("ManageProductServlet");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
