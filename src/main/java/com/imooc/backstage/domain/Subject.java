package com.imooc.backstage.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Subject {

    @Id
    @GeneratedValue
    private Integer id;//科目Id

    @NotBlank(message = "科目名称必传")
    private String name="";//科目名称

    private String detailed="";//科目说明

    public Subject() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetailed() {
		return detailed;
	}


	public void setDetailed(String detailed) {
		this.detailed = detailed;
	}


}
