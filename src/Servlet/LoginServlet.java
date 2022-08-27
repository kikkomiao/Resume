package Servlet;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import Entity.User;
import Jdbc.DbUtil;
import Utils.MD5;
import Dao.UserDao;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String userphone = request.getParameter("userphone") ;
		String userpwd =  request.getParameter("userpwd");
		HttpSession session = request.getSession();//session!!!
//		if(StringUtils.isBlank(userphone)) {
//			request.setAttribute("error", "请输入电话号码！！！");
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//			return;
//		}else if (StringUtils.isBlank(userpwd)) {
//			request.setAttribute("error", "请输入密码！！！");
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//			return;
//		}else  {

					//用户登录验证
					DbUtil db=new DbUtil();
					User user=new User(userphone,MD5.encrypByMd5(MD5.encrypByMd5(userpwd)));
					UserDao dao=new UserDao();
					try{
						//鏁版嵁搴撹繛鎺�
						Connection con=db.getcon();
						User user2 = dao.login(con, user);
						if(user2!=null)
						{
//							System.out.println("11");
							request.setAttribute("user",user2);
							session.setAttribute("user",user2);
							request.getRequestDispatcher("userIndex.jsp").forward(request, response);
//							request.getRequestDispatcher("page/user/userIndex.html").forward(request, response);
						}
						else
						{
							response.sendRedirect("page/error/error.html");;
						}
					}catch(Exception e){
						e.printStackTrace();
					}

				//}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
