package com.encore.frontPattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.encore.model.DTO;
import com.encore.model.Service;

public class selectByConditionController2 implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		Service service = new Service();
		Map<String, String> condition = new HashMap<>();
		String name = (String) data.get("name");
		String major_id = (String) data.get("major_id");
		condition.put("name", name);
		condition.put("major_id", major_id);
		List<DTO> stds = service.selectByCondition(condition);
		System.out.println(stds);
		data.put("students", stds);
	}
}
