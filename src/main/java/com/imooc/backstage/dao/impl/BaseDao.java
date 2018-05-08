package com.imooc.backstage.dao.impl;

import com.imooc.backstage.domain.User;

public interface BaseDao<T> {

    int insert(T obj);
	int update(T obj);
}
