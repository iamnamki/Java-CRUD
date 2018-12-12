package com.encore.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.omg.CORBA.portable.ValueInputStream;

import com.encore.util.OracleDBUtil;
import com.encore.util.studentUtil;

public class DAO {
	public static List<DTO> combinTable() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select major_id, studentid, name, skill, major_title from student join major using(major_id)";
		DTO student = null;
		List<DTO> studentlist = new ArrayList<>();
		conn = com.encore.util.OracleDBUtil.DBConnect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				student = makeStudent(rs);
				studentlist.add(student);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return studentlist;

	}

	private static DTO makeStudent(ResultSet rs) throws SQLException {
		int major_id = rs.getInt(1);
		int studentID = rs.getInt(2);
		String name = rs.getString(3);
		String skill = rs.getString(4);
		String major_title = rs.getString(5);

		DTO student = new DTO(studentID, name, major_id, skill, major_title);
		return student;
	}

	public List<DTO> selectByCondition(String sqlPlus) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<DTO> studentlist = new ArrayList<>();
		DTO student = null;
		conn = com.encore.util.OracleDBUtil.DBConnect();
		String sql = "select * from (select major_id, studentid, name, skill, major_title from student join major using(major_id)) where 1=1 "
				+ sqlPlus;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				student = makeStudent(rs);
				studentlist.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentlist;
	}

	public userDTO loginCheck(String userid, String userpass) {
		// select
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from userinfo where userid =? and userpwd =?";
		userDTO user = null;

		conn = OracleDBUtil.DBConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, userid);
			st.setString(2, userpass);
			rs = st.executeQuery();
			while (rs.next()) {
				String userid1 = rs.getString(1);
				String username = rs.getString(2);
				String userpwd = rs.getString(3);
				String phone = rs.getString(4);
				String email = rs.getString(5);
				int point = rs.getInt(6);
				user = new userDTO(userid1, username, userpwd, phone, email, point);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.DBDisconnect(rs, st, conn);
		}
		return user;
	}

	

}
