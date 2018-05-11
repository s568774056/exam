package com.imooc.backstage.controller;

import com.imooc.backstage.domain.PaperUser;
import com.imooc.backstage.domain.Result;
import com.imooc.backstage.repository.PaperUserRepository;
import com.imooc.backstage.repository.ScoreRepository;
import com.imooc.backstage.service.PaperUserService;
import com.imooc.backstage.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/score")
public class ScoreController {


	private final static Logger logger = LoggerFactory.getLogger(ScoreController.class);

	@Autowired
	private ScoreRepository repository;

	@Autowired
	private PaperUserService service;

	/**
	 * @return
	 * @Valid 注解表示要验证这个对象 BindingResult:验证结果
	 */
	@PostMapping(value = "/add")
	public Result<?> add(@Valid PaperUser paper, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		return service.insert(paper);
	}

	// 删除
	@PostMapping(value = "/delete/{id}")
	public Result delete(@PathVariable("id") Integer id) {

		return service.delete(id);
	}

	// 修改
	@PostMapping(value = "/update/{id}")
	public Result update(PaperUser paper, @PathVariable("id") Integer id) {
		paper.setId(id);
		return service.update(paper);
	}

	// 根据id查询一个api
	@PostMapping(value = "/findById/{id}")
	public Result findOne(@PathVariable("id") Integer id) {
		return ResultUtil.success(repository.findOne(id));
	}

	/**
	 * 根據條件查询
	 */
	@PostMapping(value = "/select")
	public Result select(PaperUser paper, String name,@RequestParam(value = "page", defaultValue = "0") Integer page,
						 @RequestParam(value = "size", defaultValue = "15") Integer size) {

		return service.select(paper, name,page, size);
	}

	/**
	 * @return
	 */
	@PostMapping(value = "/findAll")
	public Result findAll() {
		return ResultUtil.success(repository.findAll());
	}
	@PostMapping(value = "/selectUser")
	public Result selectTopic(PaperUser paper, String name, @RequestParam(value = "page", defaultValue = "0") Integer page,
							  @RequestParam(value = "size", defaultValue = "15")Integer size)  {
		return service.selectUser(paper, name,page, size);
	}
}