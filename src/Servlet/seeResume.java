package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AssoDao;
import Dao.ItemDao;
import Dao.ResumeDao;
import Dao.WorkDao;
import Entity.Asso;
import Entity.Item;
import Entity.Resume;
import Entity.Work;
import Jdbc.DbUtil;

/**
 * Servlet implementation class seeResume
 */
@WebServlet("/seeResume")
public class seeResume extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public seeResume() {
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
			ResumeDao resumeDao = new ResumeDao();
			Resume resume = resumeDao.userResumemessage(db.getcon(),Integer.parseInt(id));
			if(resume.getAward() == null || resume.getAward().equals("")){
				request.setAttribute("awardflag", 0);
			}else {
				request.setAttribute("awardflag", 1);
			}
			if (resume.getSkill() == null || resume.getSkill().equals("")){
				request.setAttribute("skillflag", 0);
			}else {
				request.setAttribute("skillflag", 1);
			}
			request.setAttribute("resume", resume);

			WorkDao workDao = new WorkDao();
			List<Work> work = workDao.lookWorkList(db.getcon(),Integer.parseInt(id));
			if(null == work || work.size() == 0){
				request.setAttribute("workflag", 0);
			}else {
				request.setAttribute("workflag", 1);
				request.setAttribute("work", work);
			}
			request.setAttribute("work", work);

			ItemDao itemDao = new ItemDao();
			List<Item> item = itemDao.lookItemList(db.getcon(),Integer.parseInt(id));
			if(null == item || item.size() == 0){
				request.setAttribute("itemflag", 0);
			}else {
				request.setAttribute("itemflag", 1);
				request.setAttribute("item", item);
			}

			AssoDao assoDao = new AssoDao();
			List<Asso> asso = assoDao.lookAssoList(db.getcon(),Integer.parseInt(id));
			request.setAttribute("asso", asso);
			if(null == asso || asso.size() == 0){
				request.setAttribute("assoflag", 0);
			}else {
				request.setAttribute("assoflag", 1);
				request.setAttribute("asso", asso);
			}

			request.getRequestDispatcher("/page/user/ResumeView.jsp").forward(request, response);
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
