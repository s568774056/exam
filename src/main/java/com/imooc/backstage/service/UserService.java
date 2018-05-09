package com.imooc.backstage.service;

import com.imooc.backstage.dao.UserDao;
import com.imooc.backstage.domain.Result;
import com.imooc.backstage.domain.User;
import com.imooc.backstage.enums.ResultEnum;
import com.imooc.backstage.repository.UserRepository;
import com.imooc.backstage.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Song
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserDao userDao;
    @Transactional
    public Result insert(User user) {

        try {
            List list=repository.findByName(user.getName());
            if(list.size()>0){
                return ResultUtil.error(ResultEnum.INSERT_TOPICDATA);
            }
            return ResultUtil.success(userDao.insert(user));
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
    public Result update(User user) {
        try {
            return ResultUtil.success(userDao.update(user));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.DELETE_NODATA);
        }
    }

    public Result select(User user, Integer page, Integer size) {

        Pageable pageable = new PageRequest(page, size);
        return ResultUtil.success(
                repository.countByNameLike("%" + user.getName() + "%"),
                repository.findByNameLikeOrderByIdDesc("%" + user.getName() + "%", pageable));
        }
    }