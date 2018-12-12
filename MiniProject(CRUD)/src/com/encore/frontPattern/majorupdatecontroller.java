package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.MajorDTO;
import com.encore.model.Service;

public class majorupdatecontroller implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		Service service = new Service();
		
		
		String sid = (String) data.get("major_id");
		int id = Integer.parseInt(sid);
		
		if (((String)data.get("method")).equals("post")) {
			
			String title = (String) data.get("major_title");
			service.updateMajor(id, title);
			
		}else {
			 
			data.put("major", service.selectMajorById(id));
		}
	}

}
