package com.liu.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="work_exp")
public class WorkExp {
	private Long work_exp_id;
	private Resume resume_id;
	private String resp_desc;
	private Date start_date;
	private Date end_date;
	
	@Id
	@GeneratedValue
	public Long getWork_exp_id() {
		return work_exp_id;
	}
	public void setWork_exp_id(Long work_exp_id) {
		this.work_exp_id = work_exp_id;
	}
	public String getResp_desc() {
		return resp_desc;
	}
	
	@ManyToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(name = "resume_id")
	public Resume getResume_id() {
		return resume_id;
	}
	public void setResume_id(Resume resume_id) {
		this.resume_id = resume_id;
	}
	
	public void setResp_desc(String resp_desc) {
		this.resp_desc = resp_desc;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
}
