package com.imooc.backstage.dao;

import com.imooc.backstage.dao.impl.BaseDao;
import com.imooc.backstage.domain.PaperTopic;

import java.util.List;
import java.util.Map;

public interface PaperTopicDao extends BaseDao {

	List<Map> selectPaper(Map map);
	int countSelectPaper(Map map);

	List<Map> selectTopic(Map map);
	int countSelectTopic(Map map);
}
