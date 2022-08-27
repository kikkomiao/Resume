package Dao;

import Entity.Item;
import Entity.Resume;
import Entity.Work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {
    public int itemInsert(Connection con, int id, Item item) throws Exception {
        boolean flag = false;
        String sql = "INSERT INTO item_exp(id,itemname,itemtime,detail) VALUES(?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,id);
        pstmt.setString(2,item.getItemname());
        pstmt.setString(3,item.getItemtime());
        pstmt.setString(4,item.getDetail());
        int result = pstmt.executeUpdate();
        if(result>0){
            flag = true;
            return 1;
        }else{
            flag = false;
            return 0;
        }
    }

    public List<Item> lookItem(Connection con, int id) throws Exception {
        Item item = null;
        String sql = "select * from item_exp where id=?";//id为简历的编号
        PreparedStatement stmt = con.prepareStatement(sql);
        List<Item> items = new ArrayList<Item>();
        stmt.setInt(1, id);
        ResultSet res = stmt.executeQuery();
        while (res.next()) {
            item = new Item();
            item.setItemid(res.getInt("itemid"));
            item.setItemname(res.getString("itemname"));
            item.setItemtime(res.getString("itemtime"));
            item.setDetail(res.getString("detail"));
            items.add(item);
        }
        return items;
    }

    public int[] findItemID(Connection con,int id)throws Exception {
        String sql = "SELECT itemid FROM item_exp WHERE id = ?";
        PreparedStatement pstmt =con.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet res = pstmt.executeQuery();
        int itemid[] = new int[3];
        int i = 0;
        while (res.next()){
            itemid[i] = res.getInt("itemid");
            i++;
        }
        return itemid;
    }

    public boolean updateItem(Connection con,int[] itemid,List<Item> items) throws Exception {
        boolean flag = false;
        String sql="UPDATE item_exp SET itemname = ?,itemtime = ?,detail = ? WHERE itemid =?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        int res[] = new int[3];
        for(int i=0;i<itemid.length;i++){
            pstmt.setString(1, items.get(i).getItemname());
            pstmt.setString(2, items.get(i).getItemtime());
            pstmt.setString(3, items.get(i).getDetail());
            pstmt.setInt(4,itemid[i]);
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

    public List<Item> lookItemList(Connection con, int id) throws Exception {
        Item item = null;
        String sql = "select * from item_exp where id=?";//id为简历的编号
        PreparedStatement stmt = con.prepareStatement(sql);
        List<Item> list = new ArrayList<Item>();
        stmt.setInt(1, id);
        ResultSet res = stmt.executeQuery();
        while (res.next()) {

            if((!res.getString("itemname").equals("")) || (!res.getString("itemtime").equals(""))
                    ||(!res.getString("detail").equals(""))) {
                item = new Item();
                item.setItemid(res.getInt("itemid"));
                item.setItemname(res.getString("itemname"));
                item.setItemtime(res.getString("itemtime"));
                item.setDetail(res.getString("detail"));

                list.add(item);
            }
        }
        return list;
    }
}
