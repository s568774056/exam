package com.imooc.backstage.service;

import com.imooc.backstage.dao.TopicDao;
import com.imooc.backstage.domain.Result;
import com.imooc.backstage.domain.Topic;
import com.imooc.backstage.enums.ResultEnum;
import com.imooc.backstage.repository.TopicRepository;
import com.imooc.backstage.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Song
 */
@Service
public class TopicService {

    @Autowired
    private TopicRepository repository;
    @Autowired
    private TopicDao topicDao;
    @Transactional
    public Result insert(Topic topic) {
        try {
            return ResultUtil.success(topicDao.insert(topic));
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
    public Result update(Topic topic) {
        try {
            return ResultUtil.success(topicDao.update(topic));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.DELETE_NODATA);
        }
    }

    public Result select(Topic topic, Integer page, Integer size) {

        Pageable pageable = new PageRequest(page, size);
        if ("".equals(topic.getType())) {
            if("".equals(topic.getSubjectId())){
                return ResultUtil.success(
                        repository.countByNameLike("%" + topic.getName() + "%"),
                        repository.findByNameLikeOrderByIdDesc("%" + topic.getName() + "%",
                                pageable));
            }else{
                return ResultUtil.success(
                        repository.countByNameLikeAndSubjectId("%" + topic.getName() + "%",topic.getSubjectId()),
                        repository.findByNameLikeAndSubjectIdOrderByIdDesc("%" + topic.getName() + "%",topic.getSubjectId(),
                                pageable));
            }

        } else {
            if("".equals(topic.getSubjectId())){
                return ResultUtil.success(
                        repository.countByNameLikeAndType("%" + topic.getName() + "%", topic.getType()),
                        repository.findByNameLikeAndTypeOrderByIdDesc("%" + topic.getName() + "%", topic.getType(),
                                pageable));
            }else{
                return ResultUtil.success(
                        repository.countByNameLikeAndTypeAndSubjectId("%" + topic.getName() + "%", topic.getType(),topic.getSubjectId()),
                        repository.findByNameLikeAndTypeAndSubjectIdOrderByIdDesc("%" + topic.getName() + "%", topic.getType(),topic.getSubjectId(),
                                pageable));
            }
        }
    }
}