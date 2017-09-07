package com.liu.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "resume")
public class Resume {
	private Long resume_id;
	private String name;
	private Integer age;
	//private List<WorkExp> workExps = new ArrayList<WorkExp>();
	
	@Id
	@GeneratedValue
	public Long getResume_id() {
		return resume_id;
	}
	public void setResume_id(Long resume_id) {
		this.resume_id = resume_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	//@OneToMany(mappedBy="resume_id")//, cascade = CascadeType.ALL)
	/*public List<WorkExp> getWorkExps() {
		return workExps;
	}
	public void setWorkExps(List<WorkExp> workExps) {
		this.workExps = workExps;
	}*/

}
