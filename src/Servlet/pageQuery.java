package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ResumeDao;
import Entity.Resume;
import Entity.User;
import Jdbc.DbUtil;

/**
 * Servlet implementation class pageQuery
 */
@WebServlet("/pageQuery")
public class pageQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		User user = (User) request.getSession().getAttribute("user");
		Integer pageNo = getIntParameter(request,"pageNo");

		DbUtil db=new DbUtil();
		Connection con=db.getcon();

		int pageSize = 12;
		Integer totalCount = 0;

		ResumeDao resumeDao =  new ResumeDao();

		if(pageNo == null) {
			pageNo = 1;
		}

		try {
			totalCount = resumeDao.count(con,user.getUserphone());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		int totalPage = totalCount/pageSize;
		if((totalCount%pageSize!=0) || (totalPage == 0)) {
			totalPage++;
		}

		Integer nextPage = 0;
		if(nextPage < totalPage) {
			nextPage = pageNo + 1;
		}else {
			nextPage = pageNo;
		}

		Integer prePage = 0;
		if(pageNo > 1) {
			prePage = pageNo - 1;
		}else {
			prePage = pageNo;
		}

		boolean isFirstPage = false;
		if(pageNo > 1) {
			isFirstPage = false;
		}else {
			isFirstPage = true;
		}

		boolean isLastPage = false;
		if(pageNo < totalPage) {
			isLastPage = false;
		}else {
			isLastPage = true;
		}


		try {

			List<Resume> list =  resumeDao.userResumeList(con, user.getUserphone(),pageNo,pageSize);

			request.setAttribute("list", list);

			request.setAttribute("isFirstPage", isFirstPage);
			request.setAttribute("isLastPage", isLastPage);

			request.setAttribute("pageSize", pageSize);
			request.setAttribute("totalCount", totalCount);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("prePage", prePage);
			request.setAttribute("nextPage", nextPage);
			request.setAttribute("pageNo", pageNo);
			request.getRequestDispatcher("page/user/MyResume.jsp").forward(request, response);
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	private Integer getIntParameter(HttpServletRequest request, String name) {
		if(request.getParameter(name) != null){
			return Integer.parseInt(request.getParameter(name));
		}else{
			return null;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
