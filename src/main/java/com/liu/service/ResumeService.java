package com.liu.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.liu.bean.Resume;
import com.liu.bean.WorkExp;
import com.liu.dao.ResumeDao;
import com.liu.dao.WorkExpDao;

@Component
public class ResumeService {
	Logger LOG = LoggerFactory.getLogger(ResumeService.class);
	
	@Resource
	private ResumeDao resumeDao;
	@Resource
	private WorkExpDao expDao;
	
	public List<Resume> transShowAllResume(){
		return resumeDao.getAll();
	}
	
	public List<WorkExp> showAllExp(){
		return expDao.getAll();
	}
}
