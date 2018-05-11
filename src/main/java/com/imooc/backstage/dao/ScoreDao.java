package com.imooc.backstage.dao;

import com.imooc.backstage.dao.impl.BaseDao;

import java.util.List;
import java.util.Map;

public interface ScoreDao extends BaseDao {

	List<Map> selectScore(Map map);
	int countselectScore(Map map);
}
