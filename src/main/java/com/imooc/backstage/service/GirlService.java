package com.imooc.backstage.service;

import com.imooc.backstage.domain.Girl;
import com.imooc.backstage.enums.ResultEnum;
import com.imooc.backstage.exception.SoftwareException;
import com.imooc.backstage.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 廖师兄
 * 2016-11-04 00:08
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    //@Transactional事务注解
    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);


        Girl girlB = new Girl();
        girlB.setCupSize("BBBB");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            //返回"你还在上小学吧" code=100
            throw new SoftwareException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age > 10 && age < 16) {
            //返回"你可能在上初中" code=101
            throw new SoftwareException(ResultEnum.MIDDLE_SCHOOL);
        }

        //如果>16岁,加钱
        //...
    }

    /**
     * 通过Id查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }
}
