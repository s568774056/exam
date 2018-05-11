package com.imooc.backstage.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Topic {

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	    @Id
	    @GeneratedValue
	    private Integer id;
	    @NotBlank(message = "科目名称必传")
	    private String subjectId="";
	    @NotBlank(message = "题目名称必传")
	    private String name="";
	    @NotBlank(message = "题目类型必传")
	    private String type="";//0:单选,1多选
	    @NotBlank(message = "选项A必传")
	    private String optionA="";//选项A
	    @NotBlank(message = "选项B必传")
	    private String optionB="";//选项B
	    private String optionC="";//选项C
	    private String optionD="";//选项D
	    private String optionE="";//选项E
	    private String optionF="";//选项F
	    private String answer="";//答案 以|分割
	    
	    
		public String getAnswer() {
			return answer;
		}
		public void setAnswer(String answer) {
			this.answer = answer;
		}
		public Topic() {
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
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getOptionA() {
			return optionA;
		}
		public void setOptionA(String optionA) {
			this.optionA = optionA;
		}
		public String getOptionB() {
			return optionB;
		}
		public void setOptionB(String optionB) {
			this.optionB = optionB;
		}
		public String getOptionC() {
			return optionC;
		}
		public void setOptionC(String optionC) {
			this.optionC = optionC;
		}
		public String getOptionD() {
			return optionD;
		}
		public void setOptionD(String optionD) {
			this.optionD = optionD;
		}
		public String getOptionE() {
			return optionE;
		}
		public void setOptionE(String optionE) {
			this.optionE = optionE;
		}
		public String getOptionF() {
			return optionF;
		}
		public void setOptionF(String optionF) {
			this.optionF = optionF;
		}
}
