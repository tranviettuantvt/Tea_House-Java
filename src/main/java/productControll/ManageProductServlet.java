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
import model.Product;
import model.Category;
/**
 * Servlet implementation class ManageProductServlet
 */
@WebServlet("/ManageProductServlet")
public class ManageProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> plist= new ArrayList<>();
		ProductDao pdao = new ProductDao();
		List<Category> clist= new ArrayList<>();
		
		String indexP=request.getParameter("index");
		if(indexP == null) {
			indexP="1";
		}
		int index=Integer.parseInt(indexP);
		try {
			int pcount=pdao.getTotalProduct();
			int endPage= pcount/5;
			if(pcount % 5!=0) {
				endPage++;
			}
			clist=pdao.getListCategory();
			plist=pdao.pagingProduct(index);
			for(Product a: plist) {
				System.out.println(a);
			}
			request.setAttribute("index", index);
			request.setAttribute("pcount", pcount);
			request.setAttribute("endPage", endPage);
			
			request.setAttribute("cateList", clist);
			request.setAttribute("listProduct", plist);
			request.getRequestDispatcher("listProduct.jsp").forward(request, response);
			
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
