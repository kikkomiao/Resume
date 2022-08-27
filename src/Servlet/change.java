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
@WebServlet("/change")
public class change extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public change() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");//解决乱码问题

		String oldUserPwd = request.getParameter("oldUserPwd");
		String userPwd = request.getParameter("userPwd");
		String confirmUserPwd = request.getParameter("confirmUserPwd");

		User user1 = (User) request.getSession().getAttribute("user");

		int flag = 10;


		try {
			DbUtil db=new DbUtil();
			User user=new User(user1.getUserphone(),MD5.encrypByMd5(MD5.encrypByMd5(oldUserPwd)));
			UserDao userdao = new UserDao();
			Connection con=db.getcon();
			User user2 = userdao.login(con, user);

			if (user2 != null){
				if(userPwd.equals(confirmUserPwd)){
					userdao.update(con,user2,MD5.encrypByMd5(MD5.encrypByMd5(userPwd)));
					request.getSession().removeAttribute("user");
					User user3 = new User(user2.getUserphone(),MD5.encrypByMd5(MD5.encrypByMd5(userPwd)),user2.getUsername());
					request.getSession().setAttribute("user",user3);
					request.getRequestDispatcher("indexView.html").forward(request, response);
				}else {
					flag = 2;
					request.setAttribute("message",flag);
//						System.out.print("***************************************************");
					request.getRequestDispatcher("/page/user/userChangePwd.jsp").forward(request, response);
				}

			}else{
				flag = 3;
				request.setAttribute("message",flag);
//					System.out.print("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				request.getRequestDispatcher("/page/user/userChangePwd.jsp").forward(request, response);

			}



		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
