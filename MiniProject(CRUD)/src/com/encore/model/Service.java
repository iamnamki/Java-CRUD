package com.encore.model;

import java.util.List;
import java.util.Map;

//업무단위로 작성 Table단위가 아님!!
public class Service {
	static DAO dao = new DAO();
	static MajorDAO mdao = new MajorDAO();
	static StudentDAO sdao = new StudentDAO();

	public  List<DTO> combinTable() {
		// TODO Auto-generated method stub
		return dao.combinTable();
	}

	public  List<MajorDTO> selectMajor() {
		return mdao.selectMajor();
	}
	
	public List<StudentDTO> selectstudent() {
		return sdao.selectstudent();
	}

	public  void insertMajor(int major_id, String major_title) {
		mdao.insertMajor(major_id, major_title);
	}

	public  int deleteMajor(int major_id2) {
		return mdao.deleteMajor(major_id2);
	}

	public  void updateMajor(int major_id3, String major_title3) {
		mdao.updateMajor(major_id3, major_title3);

	}

	public List<DTO> selectByCondition(Map<String, String> condition) {
		String[] key = new String[10];
		String[] value = new String[10];
		String sqlPlus = "";

		int i = 0;
		for (String s : condition.keySet()) {
			//key[i] = s;
			//value[i] = condition.get(s);
			sqlPlus += " and " + s + " like '%" + condition.get(s) + "%'";
			//i++;
		}
		System.out.println(sqlPlus);
		System.out.println(dao.selectByCondition(sqlPlus));
		return dao.selectByCondition(sqlPlus);
	}

	public  void insertStudent(int studentID, String name, int major_id, String phone, String address,
			String hobby, String skill) {
		sdao.insertStudent(studentID, name, major_id, phone, address, hobby, skill);

	}

	public userDTO loginCheck(String userid, String userpass) {
		return dao.loginCheck(userid,userpass);
	}

	public MajorDTO selectMajorById(int major_id) {
		return mdao.selectMajorById(major_id);
	}

	public StudentDTO loginCheckStudent(String userid, String userpass) {
		
		return sdao.loginCheckStudent(userid,userpass) ;
	}

	public Object selectstudentById(int studentid) {
		
		return sdao.selectstudentById(studentid);
	}

	public int updateStudent(StudentDTO student) {
		// TODO Auto-generated method stub
		return sdao.updateStudent(student);
	}

	public int deleteStudent(int studentID) {
		return sdao.deleteStudent(studentID);
	}
}
