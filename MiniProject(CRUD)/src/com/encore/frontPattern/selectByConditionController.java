package com.encore.frontPattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.encore.model.DTO;
import com.encore.model.Service;

public class selectByConditionController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		Service service = new Service();
		Map<String, String> condition = new HashMap<>();

		String id = (String) data.get("studentid");
		condition.put("studentID", id);
		DTO std = service.selectByCondition(condition).get(0);
		data.put("student", std);

	}
}
