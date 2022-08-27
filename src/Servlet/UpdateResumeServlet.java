package Servlet;

import Dao.AssoDao;
import Dao.ItemDao;
import Dao.ResumeDao;
import Dao.WorkDao;
import Entity.*;
import Jdbc.DbUtil;
//import com.oreilly.servlet.MultipartRequest;
//import javafx.scene.input.DataFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import Jdbc.DbUtil.*;
import Utils.PathUtils;
import lombok.SneakyThrows;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/update")
public class UpdateResumeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Object UnsupportedEncodingException;

    public UpdateResumeServlet() {
        super();
    }

    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");//解决乱码问题
        String method = request.getParameter("method");
        if ("findResume".equals(method)) {
            this.findResume(request, response);
        } else if ("updateResume".equals(method)) {
            try {
                this.updateResume(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, UnsupportedEncodingException {
        doGet(request, response);
    }

    protected void findResume(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();

        String id = request.getParameter("id");
        System.out.println("id=" + id);
        int resumeid = Integer.parseInt(id);
        if (session.getAttribute("resumeid") != null)
            session.setAttribute("resumeid", resumeid);
        else {
            session.removeAttribute("resumeid");
            session.setAttribute("resumeid", resumeid);
        }

        try {
            DbUtil db = new DbUtil();
            Connection con = db.getcon();
            ResumeDao resumeDao = new ResumeDao();
            WorkDao workDao = new WorkDao();
            ItemDao itemDao = new ItemDao();
            AssoDao assoDao = new AssoDao();

            Resume resume = resumeDao.userResumemessage(con, resumeid);
            request.setAttribute("resume", resume);

            List<Work> works = workDao.lookWork(con, resumeid);
            request.setAttribute("work1", works.get(0));
            request.setAttribute("work2", works.get(1));
            request.setAttribute("work3", works.get(2));

            List<Item> items = itemDao.lookItem(con, resumeid);
            request.setAttribute("item1", items.get(0));
            request.setAttribute("item2", items.get(1));
            request.setAttribute("item3", items.get(2));
            List<Asso> assos = assoDao.lookAsso(con, resumeid);
            request.setAttribute("asso1", assos.get(0));
            request.setAttribute("asso2", assos.get(1));
            request.setAttribute("asso3", assos.get(2));

            request.getRequestDispatcher("/page/user/changeResume.jsp").forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void updateResume(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();

        int resumeid = (int) session.getAttribute("resumeid");
        User user = (User)session.getAttribute("user");

        System.out.println(user.getUserphone());

        Resume resume = new Resume();
        Asso asso1 = new Asso();
        Asso asso2 = new Asso();
        Asso asso3 = new Asso();
        Work work1 = new Work();
        Work work2 = new Work();
        Work work3 = new Work();
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();

        String relpath = "static/img";
        String path = request.getRealPath(relpath);
        String pic = null;
        int choice = -1;

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);
        sfu.setHeaderEncoding("UTF-8");
        sfu.setSizeMax(1024 * 1024 * 10);

        List<FileItem> fileItems = sfu.parseRequest(request);
        for (FileItem fi :
                fileItems) {
            if (fi.isFormField()) {
                String fieldName = fi.getFieldName();
                String val = fi.getString("UTF-8");
                if (fieldName.equals("name")) {
                    resume.setName(val);
                }
                if (fieldName.equals("target")) {
                    resume.setTarget(val);
                }
                if (fieldName.equals("age")) {//???
                    if (val.equals("")) {
                        resume.setAge(0);
                    } else
                        resume.setAge(Integer.valueOf(val));
                }
                if (fieldName.equals("phone")) {
                    resume.setPhone(val);
                }
                if (fieldName.equals("email")) {
                    resume.setEmail(val);
                }
                if (fieldName.equals("gender")) {
                    resume.setGender(Integer.valueOf(val));
                }
                if (fieldName.equals("politic")) {
                    resume.setPolitic(Integer.valueOf(val));
                }
                if (fieldName.equals("skill")) {
                    resume.setSkill(val);
                }
                if (fieldName.equals("award")) {
                    resume.setAward(val);
                }
                if (fieldName.equals("school")) {
                    resume.setSchool(val);
                }
                if (fieldName.equals("major")) {
                    resume.setMajor(val);
                }
                if (fieldName.equals("time")) {
                    resume.setTime(val);
                }
                if (fieldName.equals("asso_exp1")) {
                    asso1.setDetail(val);
                }
                if (fieldName.equals("asso_exp2")) {
                    asso2.setDetail(val);
                }
                if (fieldName.equals("asso_exp3")) {
                    asso3.setDetail(val);
                }
                if (fieldName.equals("asso_name1")) {
                    asso1.setAssoname(val);
                }
                if (fieldName.equals("asso_name2")) {
                    asso2.setAssoname(val);
                }
                if (fieldName.equals("asso_name3")) {
                    asso3.setAssoname(val);
                }
                if (fieldName.equals("asso_time1")) {
                    asso1.setAssotime(val);
                }
                if (fieldName.equals("asso_time2")) {
                    asso2.setAssotime(val);
                }
                if (fieldName.equals("asso_time3")) {
                    asso3.setAssotime(val);
                }
                if (fieldName.equals("work_exp1")) {
                    work1.setDetail(val);
                }
                if (fieldName.equals("work_exp2")) {
                    work2.setDetail(val);
                }
                if (fieldName.equals("work_exp3")) {
                    work3.setDetail(val);
                }
                if (fieldName.equals("company1")) {
                    work1.setCompany(val);
                }
                if (fieldName.equals("company2")) {
                    work2.setCompany(val);
                }
                if (fieldName.equals("company3")) {
                    work3.setCompany(val);
                }
                if (fieldName.equals("work_time1")) {
                    work1.setWorktime(val);
                }
                if (fieldName.equals("work_time2")) {
                    work2.setWorktime(val);
                }
                if (fieldName.equals("work_time3")) {
                    work3.setWorktime(val);
                }
                if (fieldName.equals("item_exp1")) {
                    item1.setDetail(val);
                }
                if (fieldName.equals("item_exp2")) {
                    item2.setDetail(val);
                }
                if (fieldName.equals("item_exp3")) {
                    item3.setDetail(val);
                }
                if (fieldName.equals("item_name1")) {
                    item1.setItemname(val);
                }
                if (fieldName.equals("item_name2")) {
                    item2.setItemname(val);
                }
                if (fieldName.equals("item_name3")) {
                    item3.setItemname(val);
                }
                if (fieldName.equals("item_time1")) {
                    item1.setItemtime(val);
                }
                if (fieldName.equals("item_time2")) {
                    item2.setItemtime(val);
                }
                if (fieldName.equals("item_time3")) {
                    item3.setItemtime(val);
                }

            } else {
//                System.out.println("111111111111111111111111111111111");
                String fileName = fi.getName();
                fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
                System.out.println(fileName);
                File file = new File(path + "\\" + fileName);
                if (!file.exists()) {
                    fi.write(file);
                    pic = path + "\\" + fileName;
                    System.out.println("pic=" + pic);
//                    choice = 1;
                }
                if(fileName.equals("")){
                    choice = 1;
                }
                String[] relativePath = null;
                relativePath = path.split("ResumeTest_Web_exploded");
                String temp = relativePath[1].substring(1);
                resume.setPic(temp + "\\" + fileName);
            }
        }
        System.out.println(resume);
        System.out.println(resumeid);
        int flag = 0;
        DbUtil db = new DbUtil();
        Connection con = db.getcon();
        ResumeDao resumeDao = new ResumeDao();
//        System.out.println("11111111111111111111111");
        boolean temp = false;
        if(choice==-1){
            temp = resumeDao.userResumeupdate(con, resume, resumeid);
            System.out.println("全部更新");
        }else if(choice==1){
            temp = resumeDao.userResumeupdate1(con, resume, resumeid);
            System.out.println("不更新图片");
        }
        System.out.println(choice);
//        boolean temp = resumeDao.userResumeupdate(con, resume, resumeid);
        System.out.println("temp=" + temp);
        if (temp == true) {
            flag++;
        }

        AssoDao assoDao = new AssoDao();
        int[] assoid = assoDao.findAssoID(con, resumeid);
        List<Asso> assos = new ArrayList<Asso>();
        assos.add(asso1);
        assos.add(asso2);
        assos.add(asso3);
        boolean check1 = assoDao.updateAsso(con, assoid, assos);
        if (check1 == true) {
            flag++;
        }

        ItemDao itemDao = new ItemDao();
        int[] itemid = itemDao.findItemID(con, resumeid);
        List<Item> items = new ArrayList<Item>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        boolean check2 = itemDao.updateItem(con, itemid, items);
        if (check2 == true) {
            flag++;
        }

        WorkDao workDao = new WorkDao();
        int[] workid = workDao.findWorkID(con, resumeid);
        List<Work> works = new ArrayList<Work>();
        works.add(work1);
        works.add(work2);
        works.add(work3);
        boolean check3 = workDao.updateWork(con, workid, works);
        if (check3 == true) {
            flag++;
        }

        if (flag == 4) {
            session.removeAttribute("resumeid");
            request.setAttribute("update", flag);
            response.sendRedirect(PathUtils.getBasePath(request)+"pageQuery?userphone="+user.getUserphone()+"&pageNo=1");
//            request.getRequestDispatcher("page/user/MyResume.jsp").forward(request, response);


        } else {
            request.setAttribute("update", -1);
            request.getRequestDispatcher("page/user/MyResume.jsp").forward(request, response);
        }
    }
}
