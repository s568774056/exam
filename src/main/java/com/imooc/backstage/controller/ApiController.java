package com.imooc.backstage.controller;

import com.imooc.backstage.domain.Api;
import com.imooc.backstage.domain.Result;
import com.imooc.backstage.repository.ApiRepository;
import com.imooc.backstage.service.ApiService;
import com.imooc.backstage.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 接口列表
 */
@RestController
@RequestMapping("/api")
public class ApiController {

	private final static Logger logger = LoggerFactory.getLogger(ApiController.class);

	@Autowired
	private ApiRepository apiRepository;

	@Autowired
	private ApiService apiService;

	/**
	 * Valid 注解表示要验证这个对象 BindingResult:验证结果
	 */
	@PostMapping(value = "/add")
	public Result<Api> add(@Valid Api api, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}

		return apiService.insert(api);
	}

	// 删除
	@PostMapping(value = "/delete/{id}")
	public Result delete(@PathVariable("id") Integer id) {

		return apiService.apiDelete(id);
	}

	// 修改
	@PostMapping(value = "/update/{id}")
	public Result update(Api api, @PathVariable("id") Integer id) {
		api.setId(id);
		return apiService.update(api);
	}

	// 根据id查询一个api
	@PostMapping(value = "/findById/{id}")
	public Result findOne(@PathVariable("id") Integer id) {
		return  ResultUtil.success(apiRepository.findOne(id));
	}

	/**
	 * 根據條件查询api
	 */
	@PostMapping(value = "/select")
	public Result select(Api api, @RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) {

		return apiService.apiSelect(api, page, size);
	}

	/**
	 * 查询所有
	 */
	@PostMapping(value = "/findAll")
	public Result findAll() {
		return ResultUtil.success(apiRepository.findAll());
	}
}
