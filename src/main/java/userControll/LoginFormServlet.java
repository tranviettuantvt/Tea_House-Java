package userControll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;
/**
 * Servlet implementation class LoginFormServlet
 */
@WebServlet("/LoginFormServlet")
public class LoginFormServlet extends HttpServlet {
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
		String pword=request.getParameter("password");
		
		UserDao udao= new UserDao();
		User userr= udao.loginUser(uname, pword);
		
		if(userr == null ) {
			request.setAttribute("error", "Username or Password invalid !");
		    request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("user", userr);
			session.setMaxInactiveInterval(100);
	    	// tao Cookie lay thong tin cua nguoi dung de nho lai
			
		      Cookie user = new Cookie("user", userr.getUsername());
		      Cookie pass = new Cookie("pass", userr.getPassword());
		      if (request.getParameter("chkRemember") != null) {
		        user.setMaxAge(10);
		        pass.setMaxAge(10);
		      } else {
		        user.setMaxAge(0);
		        pass.setMaxAge(0);
		      }
		      response.addCookie(user);
		      response.addCookie(pass);
		      request.getRequestDispatcher("DisplayProductServlet").forward(request, response);  
		}
	}

}
