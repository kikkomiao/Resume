package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//import Entity.Admin;
import Entity.Resume;
import Entity.User;

public class ResumeDao {

    // 将用户提交的简历插入到数据库
    public int userResumeInsert(Connection con, Resume resume) throws Exception {
        boolean flag = false;
        int ans = -1;
        try {
            String sql = "INSERT INTO resume(title,userphone,name,gender,age,pic,phone,email,target,politic,school,major,time,award,skill) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, resume.getTitle());
            stmt.setString(2, resume.getUserphone());
            stmt.setString(3, resume.getName());
            stmt.setInt(4, resume.getGender());
            stmt.setInt(5, resume.getAge());
            stmt.setString(6, resume.getPic());
            stmt.setString(7, resume.getPhone());
            stmt.setString(8, resume.getEmail());
            stmt.setString(9, resume.getTarget());
            stmt.setInt(10, resume.getPolitic());
            stmt.setString(11, resume.getSchool());
            stmt.setString(12, resume.getMajor());
            stmt.setString(13, resume.getTime());//???
            stmt.setString(14, resume.getAward());
            stmt.setString(15, resume.getSkill());

            int res = stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
                ans = rs.getInt(1);
            rs.close();
            return ans;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ans;
    }


    //通过简历id查)
    public Resume userResumemessage(Connection con, int id) throws Exception {
        Resume resume = null;
        String sql = "select * from resume where id=?";//id为简历的编号
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet res = stmt.executeQuery();
        while (res.next()) {
            resume = new Resume();

            resume.setTitle(res.getString("title"));
            resume.setUserphone(res.getString("userphone"));
            resume.setName(res.getString("name"));
            resume.setGender(res.getInt("gender"));
            resume.setAge(res.getInt("age"));
            resume.setPic(res.getString("pic"));
            resume.setPhone(res.getString("phone"));
            resume.setEmail(res.getString("email"));
            resume.setTarget(res.getString("target"));
            resume.setPolitic(res.getInt("politic"));
            resume.setSchool(res.getString("school"));
            resume.setMajor(res.getString("major"));
            resume.setTime(res.getString("time"));//?？？??????
            resume.setAward(res.getString("award"));
            resume.setSkill(res.getString("skill"));

        }
        return resume;
    }

    //用户查看自己的所有简历的概括 返回简历id title name target
    public List<Resume> userResumeDetail(Connection con, String userphone) throws Exception {
        Resume resume = null;
        String sql = "select id,title,name,target from resume where userphone=?";
        String sql1 = "select id,title,name,target from resume where userphone='"+userphone+"';";
        System.out.println(sql1);
        PreparedStatement stmt = con.prepareStatement(sql);
        List<Resume> list = new ArrayList<Resume>();
        stmt.setString(1, userphone);
        ResultSet res = stmt.executeQuery();
        while (res.next()) {
            resume = new Resume();
            resume.setPhone(userphone);
            resume.setId(res.getInt("id"));
            resume.setTitle(res.getString("title"));
            resume.setName(res.getString("name"));
            resume.setTarget(res.getString("target"));
            list.add(resume);
        }
        return list;
    }

    //普通用户更新简历信息  将原先存在的信息填入html input的values中 问题在性别 政治面貌 时间 照片(添加照片一种 不添加照片一种)  不设置简历重命名功能
    //先用get取到数据库中的信息 用户后再set 没有修改的还是保留着get到的结果 再将结果更新
    public boolean userResumeupdate(Connection con, Resume resume,int id) throws Exception {
        boolean flag = false;
        String sql = "update resume set name=?,gender=?,age=?,pic=?,phone=?,email=?,target=?,politic=?,school=?,major=?,time=?,award=?,skill=? where id=?";
        //  System.out.println(sql);
        PreparedStatement stmt = con.prepareStatement(sql);
        System.out.println("id111111111111111====="+id);
        stmt.setString(1, resume.getName());
        stmt.setInt(2, resume.getGender());
        stmt.setInt(3, resume.getAge());
        stmt.setString(4, resume.getPic());
        stmt.setString(5, resume.getPhone());
        stmt.setString(6, resume.getEmail());
        stmt.setString(7, resume.getTarget());
        stmt.setInt(8, resume.getPolitic());
        stmt.setString(9, resume.getSchool());
        stmt.setString(10, resume.getMajor());
        stmt.setString(11, resume.getTime());//???
        stmt.setString(12, resume.getAward());
        stmt.setString(13, resume.getSkill());
        stmt.setInt(14, id);//!!!

        int res = stmt.executeUpdate();
        if (res > 0) {
            flag = true;
        }
        return flag;
    }

    //普通用户更新简历信息(不更新照片) 不知道能不能用得到
    public boolean userResumeupdate1(Connection con, Resume resume,int id) throws Exception {
        boolean flag = false;
        String sql = "update resume set name=?,gender=?,age=?,phone=?,email=?,target=?,politic=?,school=?,";
        sql += "major=?,time=?,award=?,skill = ? where id=?";
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, resume.getName());
        stmt.setInt(2, resume.getGender());
        stmt.setInt(3, resume.getAge());
        stmt.setString(4, resume.getPhone());
        stmt.setString(5, resume.getEmail());
        stmt.setString(6, resume.getTarget());
        stmt.setInt(7, resume.getPolitic());
        stmt.setString(8, resume.getSchool());
        stmt.setString(9, resume.getMajor());
        stmt.setString(10, resume.getTime());//???
        stmt.setString(11, resume.getAward());
        stmt.setString(12, resume.getSkill());
        stmt.setInt(13, id);//!!!

        int res = stmt.executeUpdate();
        if (res > 0) {//
            flag = true;
        }
        return flag;
    }

    //批量删除数据(多删)
    public int resumedeletemore(Connection con, List<String> list) throws Exception {
        int row = 0;
        String temp1 = "";
        //开始截取
        for (int i = 0; i < list.size(); i++) {
            temp1 += "'" + list.get(i) + "',";
        }
        temp1 = temp1.substring(0, temp1.length() - 1);
        String sql = "delete from user_resume where user_id in(" + temp1 + ");";
        System.out.println(sql);
        PreparedStatement stmt = con.prepareStatement(sql);
        row = stmt.executeUpdate();
        return row;
    }

    public boolean resumedelete(Connection con, int id) throws Exception {
        boolean flag = false;
        String sql = "delete from resume where id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        int res = stmt.executeUpdate();
        if (res > 0) {
            flag = true;
        }
        return flag;
    }
    public Integer count(Connection con,String userphone) throws SQLException {
        Resume resume = new Resume();
        String sql = "select * from resume where userphone=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, userphone);
        ResultSet res = stmt.executeQuery();
        int count = 0;
        while (res.next()) {
            count++;
        }
        return count;
    }

    //分页
    //用户查看自己的所有简历的概括 返回简历id title name target
    public List<Resume> userResumeList(Connection con, String userphone,Integer pageNo,int pageSize) throws Exception {
        List<Resume> list = new ArrayList<Resume>();
        String sql="select * from resume where userphone = '"+userphone+"' limit "+(pageNo-1)*pageSize+","+pageSize;//��ҳ��ѯ��sql���
        try {
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet res=stmt.executeQuery();//执行查询操作
            while(res.next()) {
                Resume resume = new Resume();
                resume.setId(Integer.parseInt(res.getString("id")));
                resume.setTitle(res.getString("title"));
                resume.setUserphone(res.getString("userphone"));
                resume.setName(res.getString("name"));
                resume.setTarget(res.getString("target"));
                list.add(resume);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        Collections.reverse(list);
        return list;
    }
}

