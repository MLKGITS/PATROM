package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import javax.servlet.http.HttpSession;*/

import beans.LoginBean;
import dao.LoginDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String pages = "/WEB-INF/login.jsp";


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getServletContext().getRequestDispatcher(pages).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//doGet(request, response);
	
	/*	
		PrintWriter out = response.getWriter();
	String name = request.getParameter("name");
	String pass = request.getParameter("pass");
	*/
		PrintWriter out = response.getWriter();
		
	LoginBean loginBean = new LoginBean();
	
	loginBean.setUsername(request.getParameter("name"));
	loginBean.setUserpass(request.getParameter("pass"));
	
	System.out.println(loginBean.getUsername());
	System.out.println(loginBean.getUserpass());
	
	LoginDao loginDao = new LoginDao();
	loginDao.validate(loginBean);
	
	if (loginDao.validate(loginBean)) {
		
		response.sendRedirect("/CamShar/whome");
	}else {
		out.println(" Password or User Error");
	}
	
	
	/*
	if(name.equals("abc") && pass.equals("asd")){
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		
		response.sendRedirect("/CamShar/whome");
		
	}else {
		out.println(" Password or User Error");
	}
		*/
	
	}
}
