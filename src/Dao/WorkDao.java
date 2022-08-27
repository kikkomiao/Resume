package Dao;

import Entity.Resume;
import Entity.Work;

//import javax.jnlp.ClipboardService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WorkDao {
    public int workInsert(Connection con, int id, Work work) throws Exception {
        boolean flag = false;
        String sql = "INSERT INTO work_exp(id,company,worktime,detail) VALUES(?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.setString(2,work.getCompany());
        pstmt.setString(3,work.getWorktime());
        pstmt.setString(4,work.getDetail());

        int result = pstmt.executeUpdate();
        if(result>0){
            flag = true;
            return 1;
        }else{
            flag = false;
            return 0;
        }
    }

    public List<Work> lookWork(Connection con, int id) throws Exception {
        Work work = null;
        String sql = "select * from work_exp where id=?";//id为简历的编号
        PreparedStatement stmt = con.prepareStatement(sql);
        List<Work> works = new ArrayList<Work>();
        stmt.setInt(1, id);
        ResultSet res = stmt.executeQuery();
        while (res.next()) {
            work = new Work();

            work.setWorkid(res.getInt("workid"));
            work.setCompany(res.getString("company"));
            work.setWorktime(res.getString("worktime"));
            work.setDetail(res.getString("detail"));
            works.add(work);
        }
        return works;
    }


    public int[] findWorkID(Connection con,int id)throws Exception {
        String sql = "SELECT workid FROM work_exp WHERE id = ?";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet res = pstmt.executeQuery();
        int workid[] = new int[3];
        int i = 0;
        while (res.next()){
            workid[i] = res.getInt("workid");
            i++;
        }
        return workid;
    }

    public boolean updateWork(Connection con,int[] workid,List<Work> works) throws Exception {

        boolean flag = false;
        String sql="UPDATE work_exp SET company = ?,worktime = ?,detail = ? WHERE workid =?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        int res[] = new int[3];
        for(int i=0;i<workid.length;i++){
            pstmt.setString(1,works.get(i).getCompany());
            pstmt.setString(2, works.get(i).getWorktime());
            pstmt.setString(3, works.get(i).getDetail());
            pstmt.setInt(4,workid[i]);
            res[i] =pstmt.executeUpdate();
        }
        int count = 0;
        for(int i=0;i<res.length;i++){
            if(res[i]>0){
                count ++;
            }
        }
        if(count==res.length){
            flag = true;
        }
        return flag;
    }

    public List<Work> lookWorkList(Connection con, int id) throws Exception {
        Work work = null;
        String sql = "select * from work_exp where id=?";//id为简历的编号
        PreparedStatement stmt = con.prepareStatement(sql);
        List<Work> list = new ArrayList<Work>();
        stmt.setInt(1,id);
        ResultSet res = stmt.executeQuery();
        while (res.next()) {
            if((!res.getString("company").equals("")) || (!res.getString("worktime").equals(""))
                    || (!res.getString("detail").equals(""))) {
                work = new Work();
                work.setWorkid(res.getInt("workid"));
                work.setCompany(res.getString("company"));
                work.setWorktime(res.getString("worktime"));
                work.setDetail(res.getString("detail"));
                list.add(work);
            }
        }
        return list;
    }
}
