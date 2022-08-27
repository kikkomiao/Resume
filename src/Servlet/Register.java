package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.User;
import Jdbc.DbUtil;
import Utils.MD5;
import Dao.UserDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register(){
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	// TODO Auto-generated method stub


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String username = request.getParameter("username");
		String userphone = request.getParameter("userphone");
		String userpwd = request.getParameter("userpwd");
		String userpwd2 = request.getParameter("pass2");
		int flag = 10;

		DbUtil db=new DbUtil();
		UserDao userDao=new UserDao();
		User user = userDao.checkPhone(userphone);
		System.out.println(user);

		if(user!=null) {
			System.out.println("111111111111111111111");
			flag = 1;
			request.setAttribute("message", flag);
			request.getRequestDispatcher("register.jsp").forward(request, response);
//			response.sendRedirect("register.jsp");
		}else if(user==null) {
			User user1 = new User();
			user1.setUserphone(userphone);
			user1.setUsername(username);
			user1.setUserpwd(MD5.encrypByMd5(MD5.encrypByMd5(userpwd)));

			try {
				System.out.printf("222222222222222222222222222");
				userDao.register(db.getcon(), user1);
				System.out.printf("");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag = 2;
			request.setAttribute("message", flag);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}


}
