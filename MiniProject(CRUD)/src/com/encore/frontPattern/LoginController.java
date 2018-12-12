package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.DTO;
import com.encore.model.Service;
import com.encore.model.StudentDTO;
import com.encore.model.userDTO;

public class LoginController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		String method = (String) data.get("method");
		Service service = new Service();
		String userid = (String) data.get("userid");
		String userpass = (String) data.get("userpass");
		if (method.equals("get")) {
			return;
		} else {
			if(userid.equals("admin")) {
				userDTO user = service.loginCheck(userid, userpass);
				data.put("user", user);
				data.put("loginResult", user == null ? "no" : "yes");				
			}
			else {
				StudentDTO student = service.loginCheckStudent(userid, userpass);
				data.put("login_student", student);
				data.put("loginResult", student == null ? "no" : "yes");	
				
				System.out.println(student.getClass());
			}
		}
	}

}
