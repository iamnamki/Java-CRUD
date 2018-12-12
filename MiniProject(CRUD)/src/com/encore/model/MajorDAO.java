package com.encore.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MajorDAO {
	public static void insertMajorInfoDB() {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "insert into major values (?,?) ";
		BufferedReader br = null;
		String str;
		conn = com.encore.util.OracleDBUtil.DBConnect();

		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("major.csv"), "euc-kr"));
			br.readLine();
			while ((str = br.readLine()) != null) {
				String[] line = str.split(",", 2);
				st = conn.prepareStatement(sql);
				st.setInt(1, Integer.parseInt(line[0]));
				st.setString(2, line[1]);
				st.executeQuery();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			com.encore.util.OracleDBUtil.DBDisconnect(null, st, conn);
		}
	}

	public List<MajorDTO> selectMajor() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		MajorDTO major = null;
		List<MajorDTO> majorlist = new ArrayList<>();

		String sql = "select * from major";
		conn = com.encore.util.OracleDBUtil.DBConnect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				major = makeMajor(rs);
				majorlist.add(major);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return majorlist;
	}

	public MajorDTO selectMajorById(int major_id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		MajorDTO major = null;

		String sql = "select * from major where major_id = ?";
		conn = com.encore.util.OracleDBUtil.DBConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, major_id);
			rs = st.executeQuery();
			while (rs.next()) {
				major = makeMajor(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return major;
	}

	private static MajorDTO makeMajor(ResultSet rs) throws SQLException {
		int major_id = rs.getInt(1);
		String major_title = rs.getString(2);
		MajorDTO major = new MajorDTO(major_id, major_title);
		return major;
	}

	public void insertMajor(int major_id, String major_title) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "insert into major values(?,?)";
		conn = com.encore.util.OracleDBUtil.DBConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, major_id);
			st.setString(2, major_title);
			st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int deleteMajor(int major_id2) {
		Connection conn = null;
		PreparedStatement st = null;
		int result = 0;
		String sql = "delete from major where major_id = ? ";
		conn = com.encore.util.OracleDBUtil.DBConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, major_id2);
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public void updateMajor(int major_id3, String major_title3) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "update major set major_title = ? where major_id = ? ";
		conn = com.encore.util.OracleDBUtil.DBConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, major_title3);
			st.setInt(2, major_id3);
			st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
