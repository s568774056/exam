package com.imooc.backstage.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Api {
	
	    @Id
	    @GeneratedValue
	    private Integer id;

	    @NotBlank(message = "接口名称必传")
	    private String name="";
	    
	    @NotBlank(message = "接口地址必传")
	    private String address="";

	    private String detailed="";//地址说明

	    public Api() {
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

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getDetailed() {
			return detailed;
		}

		public void setDetailed(String detailed) {
			this.detailed = detailed;
		}

		@Override
		public String toString() {
			return "Api [id=" + id + ", name=" + name + ", address=" + address + ", detailed=" + detailed + "]";
		}


}
