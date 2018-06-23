package com.monty.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.monty.db.Db;
import com.monty.domain.User;
import com.monty.service.Userservice;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Loginp
 */
public class Loginp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginp() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw=response.getWriter();
		int username=Integer.parseInt(request.getParameter("userid"));
		String psw=request.getParameter("password");
		User user=new User();
		user.setId(username);
		user.setPassword(psw);
		//创建userservice对象
		Userservice us=new Userservice();
		try {
			if(us.checkUser(user)) {
					request.getRequestDispatcher("/loginsuccess").forward(request, response);
				}else {
					request.setAttribute("err", "输入id或用户名错误");
					request.getRequestDispatcher("/login").forward(request, response);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
