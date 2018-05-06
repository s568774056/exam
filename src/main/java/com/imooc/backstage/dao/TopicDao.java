package com.imooc.backstage.dao;

import com.imooc.backstage.domain.Topic;

public interface TopicDao {
	

	int insert(Topic obj);
	int update(Topic obj);
/*
	Api findByKey(Integer id);

	List<Api> findAll();*/
}
