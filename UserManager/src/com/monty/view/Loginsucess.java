package com.monty.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loginsucess
 */
@WebServlet("/Loginsucess")
public class Loginsucess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginsucess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset='utf-8'");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String pre=request.getHeader("Referer");
		//out.println(pre);
		out.println("<img width='100px' height='100px' src='img/1.jpg'/><br/>");
		out.println("<hr/>");
		String username=request.getParameter("userid");
		out.println("<h1>welcome "+username+"</h1>");
		out.println("<h2>请选择您要进行的操作</h2>");
		out.println("<a href='/UserManager/guanli'>管理用户</a><br/>");
		out.println("<a href='/UserManager/add'>添加用户</a><br/>");
		out.println("<a href='/UserManager/search'>查找用户</a><br/>");
		out.println("<a href='/UserManager/login'>安全退出</a><br/>");
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
