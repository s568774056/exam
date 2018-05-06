package com.imooc.backstage.service;

import com.imooc.backstage.dao.SubjectDao;
import com.imooc.backstage.domain.Result;
import com.imooc.backstage.domain.Subject;
import com.imooc.backstage.enums.ResultEnum;
import com.imooc.backstage.repository.SubjectRepository;
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
public class SubjectService {

	@Autowired
	private SubjectRepository repository;
	@Autowired
	private TopicRepository topRepository;
	@Autowired
	private SubjectDao subjectDao;
	@Transactional
	public Result insert(Subject subject) {
		try {
			return ResultUtil.success(subjectDao.insert(subject));
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error(ResultEnum.INSERT_NODATA);
		}
	}
	@Transactional
	public Result update(Subject subject) {
		try {
			return ResultUtil.success(subjectDao.update(subject));
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error(ResultEnum.DELETE_NODATA);
		}
	}
	@Transactional
	public Result<?> delete(Integer id) {

		try {
			repository.delete(id);
			topRepository.deleteAllBySubjectId(""+id);
			return ResultUtil.success("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultUtil.error(ResultEnum.DELETE_NODATA);
		}
	}

	public Result<?> select(Subject subject, Integer page, Integer size) {
		Pageable pageable = new PageRequest(page, size);
		return ResultUtil.success(
				repository.countByNameLike("%" + subject.getName() + "%"),
				repository.findByNameLikeOrderByIdDesc("%" + subject.getName() + "%", pageable));
	}
  
}
