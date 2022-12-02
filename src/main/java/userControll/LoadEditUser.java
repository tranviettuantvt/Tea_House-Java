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
 * Servlet implementation class LoadEditUser
 */
@WebServlet("/LoadEditUser")
public class LoadEditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId= request.getParameter("userId");
		UserDao udao= new UserDao();
		List<User> ulist= new ArrayList<>();
		try {
			User userr=udao.getUserById(userId);
			System.out.println(userr);
//			ulist=udao.getListUser();
//			request.setAttribute("ulist", ulist);
			request.setAttribute("userr", userr);
			request.getRequestDispatcher("editUser.jsp").forward(request, response);
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
