package com.imooc.backstage.domain;

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
public class PaperUser {
    @Id
    @GeneratedValue
    public Integer id;//试卷试题Id
    @NotNull(message = "试卷Id必传")
    public Integer paperId;//试卷Id
    @NotNull(message = "用户Id必传")
    public Integer userId;//用户Id

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public PaperUser() {
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


}
