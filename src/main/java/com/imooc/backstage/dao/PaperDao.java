package com.imooc.backstage.dao;

import com.imooc.backstage.dao.impl.BaseDao;
import com.imooc.backstage.domain.Paper;

import java.util.List;
import java.util.Map;

public interface PaperDao extends BaseDao {

	List<Map> selectPaper(Map map);
	int countSelectPaper(Map map);

}
