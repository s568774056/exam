package com.imooc.backstage.dao;

import com.imooc.backstage.dao.impl.BaseDao;

import java.util.List;
import java.util.Map;

public interface PaperUserDao extends BaseDao {

	List<Map> selectPaper(Map map);
	int countSelectPaper(Map map);

	List<Map> selectUser(Map map);
	int countSelectUser(Map map);
}
