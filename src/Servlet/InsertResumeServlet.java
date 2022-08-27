package Servlet;

import Dao.AssoDao;
import Dao.ItemDao;
import Dao.ResumeDao;
import Dao.WorkDao;
import Entity.*;
import Jdbc.DbUtil;
//import com.oreilly.servlet.MultipartRequest;

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
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import Jdbc.DbUtil.*;
import lombok.SneakyThrows;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/insert")
public class InsertResumeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public InsertResumeServlet() {
        super();

    }

    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();


        int flag = 0;
        int id = -1;

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

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);
        sfu.setHeaderEncoding("UTF-8");
        sfu.setSizeMax(1024 * 1024 * 10);

        List<FileItem> fileItems = null;
        try {
            fileItems = sfu.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        for (FileItem fi :
                fileItems) {
            if (fi.isFormField()) {
                String fieldName = fi.getFieldName();
                String val = fi.getString("UTF-8");
                if(fieldName.equals("title")){
//                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                      resume.setTitle(val);
//                    if(resume.getTitle()==null){
//                        System.out.println(1111111);
//                    }else if(resume.getTitle().equals("")){
//                        System.out.println("222222222222");
//                    }else{
//                        System.out.println("33333333333");
//                    }
//                    System.out.println(resume.getTitle());
                }
                if (fieldName.equals("name")) {
                    resume.setName(val);
                }
                if (fieldName.equals("target")) {
                    resume.setTarget(val);
                }
                if (fieldName.equals("age")) {//???
                    if (val.equals("")) {
                        resume.setAge(0);
                    } else{
                        resume.setAge(Integer.valueOf(val));
                    }
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
                System.out.println("111111111111111111111111111111111");
                String fileName = fi.getName();
                System.out.println(fileName);
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
                File file = new File(path + "\\" + fileName);
                if (!file.exists()) {
                    try {
                        fi.write(file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    pic = path + "\\" + fileName;
                    System.out.println("pic=" + pic);
                }
                String[] relativePath = null;
                relativePath = path.split("ResumeTest_Web_exploded");
                String temp = relativePath[1].substring(1);
                if(fileName.equals("")){
                    resume.setPic("static\\img\\newpic1.jpg");
                }else{
                    resume.setPic(temp + "\\" + fileName);
                }
            }

        }


        User user = (User) session.getAttribute("user");
        resume.setUserphone(user.getUserphone());
//        resume.setTitle("新建简历");
//        String title = request.getParameter("title");

//        resume.setTitle(title);
        try {
            ResumeDao resumeDao = new ResumeDao();
            DbUtil db = new DbUtil();
            Connection con = db.getcon();
            id = resumeDao.userResumeInsert(con, resume);
            if (id > 0) {
                flag = 1;
//                resume = resumeDao.userResumemessage()
            } else {
                request.setAttribute("message", -1);
                request.getRequestDispatcher("insertResume.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (flag == 1) {
            asso1.setId(id);
            asso2.setId(id);
            asso3.setId(id);
            try {
                AssoDao assoDao = new AssoDao();
                DbUtil db = new DbUtil();
                Connection con = db.getcon();
                int temp = 0;
                temp += assoDao.assoInsert(con, id, asso1);
                temp += assoDao.assoInsert(con, id, asso2);
                temp += assoDao.assoInsert(con, id, asso3);
                if (temp == 3) {
                    flag = 2;
//                resume = resumeDao.userResumemessage()
                } else {
                    request.setAttribute("message", -2);
                    request.getRequestDispatcher("insertResume.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (flag == 2) {
            work1.setId(id);
            work2.setId(id);
            work3.setId(id);

            try {
                WorkDao workDao = new WorkDao();
                DbUtil db = new DbUtil();
                Connection con = db.getcon();
                int temp = 0;
                temp += workDao.workInsert(con, id, work1);
                temp += workDao.workInsert(con, id, work2);
                temp += workDao.workInsert(con, id, work3);
                if (temp == 3) {
                    flag = 3;
//                resume = resumeDao.userResumemessage()
                } else {
                    request.setAttribute("message", -3);
                    request.getRequestDispatcher("insertResume.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (flag == 3) {

            item1.setId(id);
            item2.setId(id);
            item3.setId(id);

            try {
                ItemDao itemDao = new ItemDao();
                DbUtil db = new DbUtil();
                Connection con = db.getcon();
                int temp = 0;
                temp += itemDao.itemInsert(con, id, item1);
                temp += itemDao.itemInsert(con, id, item2);
                temp += itemDao.itemInsert(con, id, item3);
                if (temp == 3) {
                    flag = 4;
                    request.setAttribute("message", flag);
                    request.getRequestDispatcher("indexView.html").forward(request, response);
                } else {
                    request.setAttribute("message", -4);
                    request.getRequestDispatcher("insertResume.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, UnsupportedEncodingException {
        doGet(request, response);
    }

}
