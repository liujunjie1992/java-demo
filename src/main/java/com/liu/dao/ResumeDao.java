package com.liu.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.liu.bean.Resume;
import com.liu.dao.base.BaseDaoSupport;

@Component
public class ResumeDao extends BaseDaoSupport<Resume> {

	public List<Resume> getAll() {
		String hql = "from Resume";
		List<Resume> list = find(hql);
		return list;
	}
	
}
