package com.liu.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.liu.bean.Resume;
import com.liu.bean.WorkExp;
import com.liu.service.ResumeService;
import com.liu.util.GsonUtils;

@Controller
@RequestMapping("resume")
public class ResumeCollection {
	Logger LOG = LoggerFactory.getLogger(ResumeCollection.class);

	@Resource
	private ResumeService service;
	
	
	@RequestMapping(value="show_all",method = RequestMethod.GET)
	public void showAllResume(HttpServletResponse response,
			@RequestParam(required = false) Integer pub) throws IOException {
		LOG.debug("show_all, pub:{}", pub!=null?pub:0);
		List<Resume> list = service.transShowAllResume();
		JsonObject result = new JsonObject();
		result.addProperty("status", 1);
		
		if(list!=null&&!list.isEmpty()) {
			JsonArray array = new JsonArray();
			array.add(GsonUtils.parseArray(GsonUtils.toJson(list)));
			result.add("array", array);
		}
		
		writeJson(response, result);
	}
	
	@RequestMapping(value="show_all_exp",method = RequestMethod.GET)
	public void showAllExp(HttpServletResponse response,
			@RequestParam(required = false) Integer pub) throws IOException {
		LOG.debug("show_all_exp, pub:{}", pub!=null?pub:0);
		List<WorkExp> list = service.showAllExp();
		JsonObject result = new JsonObject();
		result.addProperty("status", 1);
		
		if(list!=null&&!list.isEmpty()) {
			JsonArray array = new JsonArray();
			array.add(GsonUtils.parseArray(GsonUtils.toJson(list)));
			result.add("array", array);
		}
		
		writeJson(response, result);
	}
	
	private void writeJson(HttpServletResponse response, JsonElement result) throws IOException {
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result.toString());
	}
}
