package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.Service;

public class studentinfoController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		Service service = new Service();
		data.put("studentlist", service.selectstudent());

	}

}
