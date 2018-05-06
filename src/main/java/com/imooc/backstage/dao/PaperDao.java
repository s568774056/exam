package com.imooc.backstage.dao;

import com.imooc.backstage.domain.Paper;

import java.util.List;
import java.util.Map;

public interface PaperDao {

	int insert(Paper obj);
	int update(Paper obj);
	List<Map> selectPaper(Map map);
}
