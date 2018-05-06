package com.imooc.backstage.service;

import com.imooc.backstage.dao.PaperTopicDao;
import com.imooc.backstage.domain.PaperTopic;
import com.imooc.backstage.domain.Result;
import com.imooc.backstage.enums.ResultEnum;
import com.imooc.backstage.repository.PaperTopicRepository;
import com.imooc.backstage.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Song
 */
@Service
public class PaperTopicService {

    @Autowired
    private PaperTopicRepository repository;
    @Autowired
    private PaperTopicDao paperDao;

    @Transactional
    public Result insert(PaperTopic paper) {
        try {
            return ResultUtil.success(paperDao.insert(paper));
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
    public Result update(PaperTopic paper) {
        try {
            return ResultUtil.success(paperDao.update(paper));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.DELETE_NODATA);
        }
    }

    public Result select(PaperTopic paper, Integer page, Integer size) {

        Pageable pageable = new PageRequest(page, size);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("paper",paper);
        map.put("pageable",pageable);
        List<Map> maps = paperDao.selectPaper(map);
        return ResultUtil.success(maps);
    }

}