package com.liu.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.liu.bean.Resume;
import com.liu.bean.WorkExp;
import com.liu.dao.base.BaseDaoSupport;

@Component
public class WorkExpDao  extends BaseDaoSupport<WorkExp> {

	public List<WorkExp> getAll() {
		String hql = "from WorkExp";
		List<WorkExp> list = find(hql);
		return list;
	}

}
