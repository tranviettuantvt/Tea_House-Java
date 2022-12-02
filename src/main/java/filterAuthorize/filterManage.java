package filterAuthorize;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet Filter implementation class filterManage
 */
@WebFilter("/filterManage")
public class filterManage extends HttpFilter implements Filter {
    
    public filterManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req= (HttpServletRequest) request;
		HttpServletResponse rep=(HttpServletResponse) response;
		
		String url= req.getRequestURI();
		System.out.println(url);
		if(url.startsWith("/TeaHouse_Project/ManageUserServlet")) {
			User user=(User) req.getSession().getAttribute("user");
			if(user != null) {
				if(user.getRole()==1) {
					chain.doFilter(request, response);
				} else {
					request.getRequestDispatcher("DisplayProductServlet").forward(request, response);
//					rep.sendRedirect("DisplayProductServlet");
				}
			} else {
				request.getRequestDispatcher("login.jsp").forward(request, response);

			}
		} else if(url.startsWith("/TeaHouse_Project/ManageProductServlet")) 
		{
			User user=(User) req.getSession().getAttribute("user");
			if(user != null) {
				if(user.getRole()==1) {
					chain.doFilter(request, response);
				} else {
					request.getRequestDispatcher("DisplayProductServlet").forward(request, response);
				}
			} else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		
        }else {
        	chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
