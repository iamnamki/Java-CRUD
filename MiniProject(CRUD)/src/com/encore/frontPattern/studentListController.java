package com.encore.frontPattern;

import java.util.Map;

import com.encore.model.Service;

public class studentListController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		Service service = new Service();
		data.put("studentlist", service.combinTable());
		data.put("majorlist", service.selectMajor());
	}

}
