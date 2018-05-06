package com.imooc.backstage.dao;

import com.imooc.backstage.domain.Api;

public interface ApiDao {
	

	int insert(Api player);
	int update(Api player);
/*
	Api findByKey(Integer id);

	List<Api> findAll();*/
}
