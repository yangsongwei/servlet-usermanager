package com.monty.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.monty.db.Db;
import com.monty.domain.User;
import com.monty.service.Userservice;

/**
 * Servlet implementation class Guanli
 */
@WebServlet("/Guanli")
public class Guanli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Guanli() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset='utf-8'");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw=response.getWriter();
		pw.println("<h1>管理用户</h1>");
		int pagenow=1;
		int pagesize=3;
		if(request.getParameter("pagenow")!=null) {
			pagenow=Integer.parseInt(request.getParameter("pagenow"));
		}
		Userservice us=new Userservice();
		ArrayList<User> a=us.fenye(pagenow, pagesize);
		pw.println("<table border='1px' cellspacing='0'>");
		pw.println("<tr><th>id</th><th>姓名</th><th>Email</th><th>grade</th><th>修改用户</th><th>删除用户</th></tr>");
			for(User u:a){
				pw.println("<tr>"+
							"<td>"+u.getId()+"</td>"+
							"<td>"+u.getName()+"</td>"+
							"<td>"+u.getEmail()+"</td>"+
							"<td>"+u.getGrade()+"</td>"+
							"<td>"+"<a href='/UserManager/delete?id="+u.getId()+"'>"+"删除用户</a>"+
							"<td>"+"<a href='/UserManager/update?id="+u.getId()+"'>"+"修改用户</a>"+
						"</tr>");
			}
			pw.println("</table>");
			pw.println("跳转到");
			for(int i=1;i<=us.get_pagecount(pagenow, pagesize);i++) {
				pw.println("<a href='/UserManager/guanli?pagenow="+i+"'><"+i+"></a>");
			}
		pw.flush();
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
