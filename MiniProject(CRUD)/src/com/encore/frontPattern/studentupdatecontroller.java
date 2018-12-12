package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.Service;
import com.encore.model.StudentDTO;

public class studentupdatecontroller implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		Service service = new Service();
		if (data.get("method").equals("get")) {
			String sid = (String) data.get("studentID");
			data.put("majorlist", service.selectMajor());
			int studentid = Integer.parseInt(sid);
			data.put("student", service.selectstudentById(studentid));
		} else {
			StudentDTO student = (StudentDTO)data.get("student");
			data.put("message", service.updateStudent(student)>0?"성공":"실패");
		}

	}

}
