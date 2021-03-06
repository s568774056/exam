package com.imooc.backstage.service;

import com.imooc.backstage.dao.PaperDao;
import com.imooc.backstage.domain.Paper;
import com.imooc.backstage.domain.Result;
import com.imooc.backstage.enums.ResultEnum;
import com.imooc.backstage.repository.PaperRepository;
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
public class PaperService {

    @Autowired
    private PaperRepository repository;
    @Autowired
    private PaperDao paperDao;

    @Transactional
    public Result insert(Paper paper) {
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
    public Result update(Paper paper) {
        try {
            return ResultUtil.success(paperDao.update(paper));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.DELETE_NODATA);
        }
    }

    public Result select(Paper paper, Integer page, Integer size) {


        Map<String,Object> map=new HashMap<String,Object>();
        map.put("paper",paper);
        map.put("page",page*size);
        map.put("size",size);
        List<Map> list = paperDao.selectPaper(map);
        return ResultUtil.success(paperDao.countSelectPaper(map),list);
    }
}