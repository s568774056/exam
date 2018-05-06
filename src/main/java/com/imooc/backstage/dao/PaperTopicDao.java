package com.imooc.backstage.dao;

import com.imooc.backstage.domain.PaperTopic;

import java.util.List;
import java.util.Map;

public interface PaperTopicDao {

	int insert(PaperTopic obj);
	int update(PaperTopic obj);
	List<Map> selectPaper(Map map);
}
