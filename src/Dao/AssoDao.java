package Dao;

import Entity.Asso;
import Entity.Resume;
import Entity.Work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AssoDao {
    public int assoInsert(Connection con, int id, Asso asso) throws Exception {
        boolean flag = false;
        String sql = "INSERT INTO asso_exp(id,assoname,assotime,detail) VALUES(?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.setString(2, asso.getAssoname());
        pstmt.setString(3, asso.getAssotime());
        pstmt.setString(4, asso.getDetail());
        int result = pstmt.executeUpdate();
        if (result > 0) {
            flag = true;
            return 1;
        } else {
            flag = false;
            return 0;
        }
    }

    public List<Asso> lookAsso(Connection con, int id) throws Exception {
        Asso asso = null;
        String sql = "select * from asso_exp where id=?";//id为简历的编号
        PreparedStatement stmt = con.prepareStatement(sql);
        List<Asso> assos = new ArrayList<Asso>();
        stmt.setInt(1, id);
        ResultSet res = stmt.executeQuery();
        while (res.next()) {
            asso = new Asso();
            asso.setAssoid(res.getInt("assoid"));
            asso.setAssoname(res.getString("assoname"));
            asso.setAssotime(res.getString("assotime"));
            asso.setDetail(res.getString("detail"));
            assos.add(asso);
        }
        return assos;
    }

    public int[] findAssoID(Connection con, int  id) throws Exception {
        String sql = "SELECT assoid FROM asso_exp WHERE id = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet res = pstmt.executeQuery();
        int assoid[] = new int[3];
        int i = 0;
        while (res.next()) {
            System.out.println("res="+res.getInt("assoid"));
            assoid[i] = res.getInt("assoid");
            System.out.println("assoid="+assoid);
            i++;
        }
        return assoid;
    }

    public boolean updateAsso(Connection con, int[] assoid, List<Asso> assos) throws Exception {
        boolean flag = false;
        String sql = "UPDATE asso_exp SET assoname = ?,assotime = ?,detail = ? WHERE assoid =?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        int res[] = new int[3];
        for (int i = 0; i < assoid.length; i++) {
            pstmt.setString(1, assos.get(i).getAssoname());
            pstmt.setString(2, assos.get(i).getAssotime());
            pstmt.setString(3, assos.get(i).getDetail());
            pstmt.setInt(4, assoid[i]);
            res[i] = pstmt.executeUpdate();
        }
        int count = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] > 0) {
                count++;
            }
        }
        if (count == res.length) {
            flag = true;
        }
        return flag;
    }

    public List<Asso> lookAssoList(Connection con, int id) throws Exception {
        Asso asso = null;
        String sql = "select * from asso_exp where id=?";//id为简历的编号
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet res = stmt.executeQuery();
        List<Asso> list = new ArrayList<Asso>();
        while (res.next()) {

            if ((!res.getString("assoname").equals(""))||((!res.getString("assotime").equals(""))
                    ||(!res.getString("detail").equals("")))) {
                asso = new Asso();
                asso.setAssoid(res.getInt("assoid"));
                asso.setAssoname(res.getString("assoname"));
                asso.setAssotime(res.getString("assotime"));
                asso.setDetail(res.getString("detail"));
                list.add(asso);
            }
        }

        return list;
    }
}
