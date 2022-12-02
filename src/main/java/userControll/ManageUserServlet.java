package userControll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;
/**
 * Servlet implementation class ManageUserServlet
 */
@WebServlet("/ManageUserServlet")
public class ManageUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> ulist= new ArrayList<>();
		UserDao udao= new UserDao();
		
		String indexP=request.getParameter("index");
		if(indexP == null) {
			indexP="1";
		}
		int index=Integer.parseInt(indexP);
		try {
			int ucount=udao.getTotalUser();
			int endPage= ucount/5;
			if(ucount % 5!=0) {
				endPage++;
			}
			ulist=udao.pagingUser(index);
//			ulist=udao.getListUser();
			request.setAttribute("index", index);
			request.setAttribute("ucount", ucount);
			request.setAttribute("endPage", endPage);
			
			request.setAttribute("ulist", ulist);
			request.getRequestDispatcher("listUser.jsp").forward(request, response);
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
