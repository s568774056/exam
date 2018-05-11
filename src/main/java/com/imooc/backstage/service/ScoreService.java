package com.imooc.backstage.service;

import com.imooc.backstage.dao.PaperUserDao;
import com.imooc.backstage.dao.ScoreDao;
import com.imooc.backstage.domain.PaperUser;
import com.imooc.backstage.domain.Result;
import com.imooc.backstage.enums.ResultEnum;
import com.imooc.backstage.repository.PaperUserRepository;
import com.imooc.backstage.repository.ScoreRepository;
import com.imooc.backstage.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Song
 */
@Service
public class ScoreService {

    @Autowired
    private ScoreRepository repository;
    @Autowired
    private ScoreDao dao;

    @Transactional
    public Result insert(PaperUser paper) {

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("paper",paper);
        try {
            return ResultUtil.success(dao.insert(paper));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.INSERT_NODATA);
        }
    }

    @Transactional
    public Result<?> delete(Integer id) {

        try {
            repository.delete(id);
            return ResultUtil.success("");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.DELETE_NODATA);
        }
    }

    @Transactional
    public Result update(PaperUser paper) {
        try {
            return ResultUtil.success(dao.update(paper));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.DELETE_NODATA);
        }
    }

    public Result select(PaperUser paper,String name, Integer page, Integer size) {

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("paper",paper);
        map.put("name",name);
        map.put("page",page*size);
        map.put("size",size);
        List<Map> maps = dao.selectScore(map);

        return ResultUtil.success(dao.countselectScore(map),maps);
    }

}