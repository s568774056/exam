package com.imooc.backstage.controller;

import com.imooc.backstage.domain.Result;
import com.imooc.backstage.domain.Subject;
import com.imooc.backstage.repository.SubjectRepository;
import com.imooc.backstage.service.SubjectService;
import com.imooc.backstage.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	private final static Logger logger = LoggerFactory.getLogger(SubjectController.class);

	@Autowired
	private SubjectRepository repository;

	@Autowired
	private SubjectService service;

	/**
	 * Valid 注解表示要验证这个对象 BindingResult:验证结果
	 */
	@PostMapping(value = "/add")
	public Result<?> add(@Valid Subject subject, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}

		return service.insert(subject);
	}

	// 删除
	@PostMapping(value = "/delete/{id}")
	public Result delete(@PathVariable("id") Integer id) {

		return service.delete(id);
	}

	// 修改
	@PostMapping(value = "/update/{id}")
	public Result update(Subject subject, @PathVariable("id") Integer id) {
		subject.setId(id);
		return service.update(subject);
	}

	// 根据id查询一个api
	@PostMapping(value = "/findById/{id}")
	public Result findOne(@PathVariable("id") Integer id) {
		return ResultUtil.success(repository.findOne(id));
	}

	/**
	 * 根據條件查询api
	 * 
	 * @return
	 */
	@PostMapping(value = "/select")
	public Result select(Subject subject, @RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		return service.select(subject, page, size);
	}

	/**
	 * 查询所有列表
	 */
	@PostMapping(value = "/findAll")
	public Result findAll() {
		return ResultUtil.success(repository.findAll());
	}
}
