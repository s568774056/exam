package com.imooc.backstage.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Author:   007
 * Date:     2018/4/25 20:45
 * desc       描述
 */
@Entity
public class PaperTopic {
    @Id
    @GeneratedValue
    public Integer id;//试卷试题Id
    @NotNull(message = "试卷Id必传")
    public Integer paperId;//试卷Id
    @NotNull(message = "试题Id必传")
    public Integer topicId;//试题Id

    public PaperTopic() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }
}
