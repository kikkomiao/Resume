package Servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ResumeDao;
import Entity.Resume;
import Entity.User;
import Jdbc.DbUtil;
import Utils.PathUtils;

/**
 * Servlet implementation class deleteResume
 */
@WebServlet("/deleteResume")
public class deleteResume extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteResume() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		try {

			DbUtil db=new DbUtil();
			Connection con=db.getcon();
			ResumeDao resumeDao = new ResumeDao();

			resumeDao.resumedelete(con,Integer.parseInt(id));

			response.sendRedirect(PathUtils.getBasePath(request)+"pageQuery?");


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
