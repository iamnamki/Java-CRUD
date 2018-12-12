package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.Service;

public class deleteMajorController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		Service service = new Service();
		String sid = (String) data.get("major_id");
		int major_id = Integer.parseInt(sid);
		int i = service.deleteMajor(major_id);
		data.put("message", service.deleteMajor(major_id)>0?i+"건 성공":"실패");

	}

}
