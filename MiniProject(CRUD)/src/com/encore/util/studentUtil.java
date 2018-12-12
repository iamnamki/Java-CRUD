package com.encore.util;

import javax.servlet.http.HttpServletRequest;

import com.encore.model.DTO;
import com.encore.model.StudentDTO;

public class studentUtil {
	public static DTO UtilStudent(HttpServletRequest request) {
		int major_id = Integer.parseInt(request.getParameter("major_id"));
		int studentID = Integer.parseInt(request.getParameter("studentID"));
		String name = request.getParameter("name");
		String skill = request.getParameter("skill");
		String major_title = request.getParameter("major_title");

		DTO student = new DTO(studentID, name, major_id, skill, major_title);
		return student;
	}

	public static StudentDTO MakeStudent(HttpServletRequest request) {

		int studentID = Integer.parseInt(request.getParameter("studentID"));
		String name = request.getParameter("name");
		int major_id = Integer.parseInt(request.getParameter("major_id"));
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String hobby = request.getParameter("hobby");
		String skill = request.getParameter("skill");

		StudentDTO student = new StudentDTO(studentID, name, major_id, phone, address, hobby, skill);
		return student;

	}
}
