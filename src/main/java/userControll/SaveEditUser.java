package userControll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class SaveEditUser
 */
@WebServlet("/SaveEditUser")
public class SaveEditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		int role=Integer.parseInt(request.getParameter("role"));
		String fname=request.getParameter("fullName");
		String uid=request.getParameter("userId");
		request.setCharacterEncoding("UTF-8");
		UserDao udao= new UserDao();
		
		try {
			udao.editUser(uid, uname, pass, role, fname);
			response.sendRedirect("ManageUserServlet");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
