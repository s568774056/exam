package com.imooc.backstage.controller;

import com.imooc.backstage.domain.Result;
import com.imooc.backstage.domain.User;
import com.imooc.backstage.repository.UserRepository;
import com.imooc.backstage.service.UserService;
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
@RequestMapping("/User")
public class UserController {

	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserService service;

	/**
	 * Valid 注解表示要验证这个对象 BindingResult:验证结果
	 */
	@PostMapping(value = "/add")
	public Result add(@Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}

		return service.insert(user);
	}

	// 删除
	@PostMapping(value = "/delete/{id}")
	public Result delete(@PathVariable("id") Integer id) {

		return service.delete(id);
	}

	// 修改
	@PostMapping(value = "/update/{id}")
	public Result update(User user, @PathVariable("id") Integer id) {
		user.setId(id);
		return service.update(user);
	}

	// 根据id查询
	@PostMapping(value = "/findById/{id}")
	public Result findOne(@PathVariable("id") Integer id) {
		return  ResultUtil.success(repository.findOne(id));
	}

	/**
	 * 根據條件查询
	 */
	@PostMapping(value = "/select")
	public Result select(User user, @RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) {

		return service.select(user, page, size);
	}

	/**
	 * 查询所有
	 */
	@PostMapping(value = "/findAll")
	public Result findAll() {
		return ResultUtil.success(repository.findAll());
	}
}
