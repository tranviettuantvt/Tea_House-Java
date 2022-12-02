package userControll;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;
/**
 * Servlet implementation class SignUpFormServlet
 */
@WebServlet("/SignUpFormServlet")
public class SignUpFormServlet extends HttpServlet {
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
		String repass=request.getParameter("repassword");
		String fullname= request.getParameter("fullname");
		try {
			if(!pass.equals(repass)) {
				request.setAttribute("error", "Password is not the same");
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			} else {
				UserDao udao= new UserDao();
				User user= udao.checkUsernameExist(uname);
				if(user == null) {
					udao.insertUser(uname, repass, fullname);
					response.sendRedirect("DisplayProductServlet");
				} else {
					request.setAttribute("error", "Username is exist");
					request.getRequestDispatcher("signup.jsp").forward(request, response);
				}
			}
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
