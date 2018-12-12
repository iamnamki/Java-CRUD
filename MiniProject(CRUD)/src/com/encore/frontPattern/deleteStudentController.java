package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.Service;

public class deleteStudentController implements CommonController {
	@Override
	public void execute(Map<String, Object> data) {
		Service service = new Service();
		String sid = (String) data.get("studentID");
		int studentID = Integer.parseInt(sid);
		int i = service.deleteStudent(studentID);
		data.put("message", service.deleteStudent(studentID)>0?i+"건 성공":"실패");
	}

}
