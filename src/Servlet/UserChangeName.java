package Servlet;
import Dao.UserDao;
import Entity.User;
import Jdbc.DbUtil;
import Utils.MD5;
import Utils.PathUtils;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class change
 */
@WebServlet("/changename")
public class UserChangeName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserChangeName() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");//解决乱码问题
		String method = request.getParameter("method");
		if ("changeName".equals(method)) {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			System.out.println(user);
			request.setAttribute("newName",user.getUsername());
			this.changeName(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	private void changeName(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String newName = request.getParameter("newName");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String oldName = user.getUsername();
		String userphone = user.getUserphone();
		int flag = -1;
		try {
			DbUtil db=new DbUtil();
//            User user=new User(userphone,newName,oldName);
			UserDao userdao = new UserDao();
            Connection con=db.getcon();
			userdao.updateName(con,user,newName);

			User user2 = userdao.login(con,user);
			session.removeAttribute("user");
			session.setAttribute("user",user2);
			flag = 1;
			request.setAttribute("message",flag);
//			System.out.print("------------------------------------------------");
//			request.getSession().invalidate();
//			response.sendRedirect("login?userphone="+user2.getUserphone()+"&userpwd="+user2.getUserpwd());
//			System.out.print(userphone+"和"+user2.getUserpwd());
//			response.sendRedirect("indexview.jsp");
			request.getRequestDispatcher("userIndex.jsp").forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
