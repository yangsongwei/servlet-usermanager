package com.monty.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<img width='100px' height='100px' src='img/1.jpg'/><br/>");
		out.println("<hr/>");
		out.println("<h1>ÄãºÃ</h1>");
		out.println("<form action='/UserManager/loginp' method='post'>");
		out.println("id£º<input type='text' name='userid'/><br/>");
		out.println("ÃÜÂë:<input type='password' name='password'/><br/>");
		out.println("<input type='submit' value='µÇÂ¼'/>");
		out.print("<input type='reset' value='ÖØÖÃ'/>");
		out.println("</form>");
		if( request.getAttribute("err")!=null) {	
			out.println("<h2>"+request.getAttribute("err").toString()+"</h2>");
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
