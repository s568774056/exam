package com.imooc.backstage.service;

import com.imooc.backstage.dao.ApiDao;
import com.imooc.backstage.domain.Api;
import com.imooc.backstage.domain.Result;
import com.imooc.backstage.enums.ResultEnum;
import com.imooc.backstage.repository.ApiRepository;
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
public class ApiService {

	@Autowired
	private ApiRepository apiRepository;
	@Autowired
	private ApiDao apiDao;
	@Transactional
	public Result insert(Api api) {
		try {
			return ResultUtil.success(apiDao.insert(api));
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error(ResultEnum.INSERT_NODATA);
		}
	}
	@Transactional
	public Result update(Api api) {
		try {
			return ResultUtil.success(apiDao.update(api));
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error(ResultEnum.DELETE_NODATA);
		}
	}
	@Transactional
	public Result<?> apiDelete(Integer id) {

		try {
			apiRepository.delete(id);
			return ResultUtil.success("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultUtil.error(ResultEnum.DELETE_NODATA);
		}
	}

	public Result apiSelect(Api api, Integer page, Integer size) {

		Pageable pageable = new PageRequest(page, size);
		return ResultUtil.success(
				apiRepository.countByNameLikeAndAddressLike("%" + api.getName() + "%", "%" + api.getAddress() + "%"),
				apiRepository.findByNameLikeAndAddressLikeOrderByIdDesc("%" + api.getName() + "%",
						"%" + api.getAddress() + "%", pageable));
	}

	public void test(Api api, Integer page, Integer size) {

		Pageable pageable = new PageRequest(page, size);

		List<Api> findByNameLikeOrAddressLikeOrderByIdDesc = apiRepository
				.findByNameLikeAndAddressLikeOrderByIdDesc(api.getName() + "%", api.getAddress() + "%", pageable);
		System.out.println("---------------------------------------------------------------------------");
		for (Api rtn : findByNameLikeOrAddressLikeOrderByIdDesc) {
			System.out.println(rtn.toString());
		}
	}

	/*
	 * public void testUpdate(Api api, Integer page, Integer size) {
	 * 
	 * apiRepository.updateOne(api); }
	 */
}
