package com.imooc.backstage.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 试卷
 * Author:   007
 * Date:     2018/4/25 17:31
 * desc       描述
 */
@Entity
public class Paper {
    @Id
    @GeneratedValue
    public Integer id;//试卷Id
    @NotBlank(message = "试卷名称必传")
    public String name;//试卷名称
    public String createDate;//创建时间
    public String updateDate;//更新时间
    @NotBlank(message = "科目必传")
    public String subjectId;//科目Id

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public Paper() {
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public void setName(String name) {
        this.name = name;
    }


}
