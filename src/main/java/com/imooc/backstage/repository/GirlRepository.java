package com.imooc.backstage.repository;

import com.imooc.backstage.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by
 * 2016-11-03 23:17
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    //通过年龄来查询
    public List<Girl> findByAge(Integer age);
}
