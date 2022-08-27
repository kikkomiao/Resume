package Dao;

import java.sql.*;


import Entity.User;
import Jdbc.DbUtil;

public class UserDao {

	// 普通用户登陆验证֤
	public User login(Connection con, User user) throws Exception {
		User resultUser = null;
		String sql = "select * from user where userphone=? and userpwd=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, user.getUserphone());
		stmt.setString(2, user.getUserpwd());
		ResultSet res = stmt.executeQuery();
		if (res.next()) {//找到了，是合法用户
			resultUser = new User();
			resultUser.setUserphone(res.getString("userphone"));
		resultUser.setUsername(res.getString("username"));
		resultUser.setUserpwd(res.getString("userpwd"));
	}
		return resultUser;
	}

	//只拿账号校验身份ֻ
	public boolean login(Connection con, String userphone) throws Exception {
		boolean flag = false;
		String sql = "select * from user where userphone=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, userphone);
		ResultSet res = stmt.executeQuery();
		if (res.next()) {
			flag = true;
		}
		return flag;
	}

	// 普通用户注册
	public boolean register(Connection con, User user) throws Exception {
		boolean flag = false;
		PreparedStatement stmt = null;
		String sql = "insert into user(userphone,userpwd,username) values(?,?,?)";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, user.getUserphone());
		stmt.setString(2, user.getUserpwd());
		stmt.setString(3, user.getUsername());
		if (stmt.executeUpdate() > 0) {//大于0说明插入成功了
			flag = true;
		}
		return flag;
	}

	public User checkPhone(String userphone) {
		User user = null;
		String sql = "select * from user where userphone= '" + userphone + "';";
		DbUtil db = new DbUtil();
		Connection connection = db.getcon();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				user = new User(userphone, resultSet.getString(2), resultSet.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(connection, statement, resultSet);
		}
		return user;
	}

//修改密码
	public int update(Connection con, User user, String userPwd) {
		User user1 = null;
		String sql = "update  user set userpwd=? where userphone = ?";
		DbUtil db = new DbUtil();
		int res=0;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, userPwd);
			stmt.setString(2, user.getUserphone());
			res = stmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}
		return res;
	}
	public int updateName(Connection con, User user,String newName){
		String sql = "update user set username=? where userphone = ?";
		DbUtil db = new DbUtil();
		int res = 0;
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,newName);
			pstmt.setString(2,user.getUserphone());
			res = pstmt.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return res;
	}
}
