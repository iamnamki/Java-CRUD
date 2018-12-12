package com.encore.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

import com.encore.util.OracleDBUtil;

public class StudentDAO {

	public static void insertStudentInfoDB() {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "Insert into student values(?,?,?,?,?,?,?)";
		conn = com.encore.util.OracleDBUtil.DBConnect();

		BufferedReader br = null;
		String str;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("student.csv"), "euc-kr"));
			br.readLine();
			while ((str = br.readLine()) != null) {
				String[] line = str.split(",", 7);
				st = conn.prepareStatement(sql);
				st.setInt(1, Integer.parseInt(line[0]));
				st.setString(2, line[1]);
				st.setInt(3, Integer.parseInt(line[2]));
				st.setString(4, line[3]);
				st.setString(5, line[4]);
				st.setString(6, line[5]);
				st.setString(7, line[6]);
				st.executeQuery();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			com.encore.util.OracleDBUtil.DBDisconnect(null, st, conn);

		}

	}

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
				String[] line = str.split(",");
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

	public void insertStudent(int studentID, String name, int major_id, String phone, String address, String hobby,
			String skill) {
		List<StudentDTO> studentlist = new ArrayList<>();
		StudentDTO student = new StudentDTO();
		Connection conn;
		Statement st;
		String sql = "insert into student values ('" + studentID + "','" + name + "','" + major_id + "','" + phone
				+ "','" + address + "','" + hobby + "','" + skill + "')";
		int result = 0;
		conn = com.encore.util.OracleDBUtil.DBConnect();
		try {
			st = conn.createStatement();
			st.executeQuery(sql);
			result = st.getUpdateCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("정상적으로 실행 되었습니다.^^");
	}

	public List<StudentDTO> selectstudent() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		StudentDTO student = null;
		List<StudentDTO> studentlist = new ArrayList<>();

		String sql = "select * from student";
		conn = com.encore.util.OracleDBUtil.DBConnect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				student = makestudent(rs);
				studentlist.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentlist;
	}

	private StudentDTO makestudent(ResultSet rs) throws SQLException {
		int studentid = rs.getInt(1);
		String name = rs.getString(2);
		int major_id = rs.getInt(3);
		String phone = rs.getString(4);
		String address = rs.getString(5);
		String hobby = rs.getString(6);
		String skill = rs.getString(7);
		StudentDTO student = new StudentDTO(studentid, name, major_id, phone, address, hobby, skill);
		return student;
	}

	public Object selectstudentById(int studentid) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		StudentDTO student = null;

		String sql = "select * from student where studentid = ?";
		conn = com.encore.util.OracleDBUtil.DBConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, studentid);
			rs = st.executeQuery();
			while (rs.next()) {
				student = makestudent(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	public int updateStudent(StudentDTO student) {
		Connection conn = null;
		PreparedStatement st = null;
		int result = 0;
		String sql = "update student set phone = ?,major_id = ?,address=?,hobby=?,skill=?  where studentid = ? ";
		conn = com.encore.util.OracleDBUtil.DBConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, student.getPhone());
			st.setInt(2, student.getMajor_id());
			st.setString(3, student.getAddress());
			st.setString(4, student.getHobby());
			st.setString(5, student.getSkill());
			st.setInt(6, student.getStudentID());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public StudentDTO loginCheckStudent(String userid, String userpass) {
		// select
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from student where NAME = ? and STUDENTID = ?";
		StudentDTO student = null;

		conn = OracleDBUtil.DBConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, userid);
			st.setString(2, userpass);
			rs = st.executeQuery();
			while (rs.next()) {
				int studentID = Integer.parseInt(rs.getString(1));
				String name = rs.getString(2);
				int major_id = Integer.parseInt(rs.getString(3));
				String phone = rs.getString(4);
				String address = rs.getString(5);
				String hobby = rs.getString(6);
				String skill = rs.getString(7);
				student = new StudentDTO(studentID, name, major_id, phone, address, hobby,skill);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.DBDisconnect(rs, st, conn);
		}
		return student;
	}
	
	public int deleteStudent(int studentID) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "delete from student where studentid = ? ";
		int result = 0;
		conn = com.encore.util.OracleDBUtil.DBConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, studentID);
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
}
