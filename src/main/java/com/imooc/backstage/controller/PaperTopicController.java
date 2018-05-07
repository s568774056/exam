package com.imooc.backstage.controller;

import com.imooc.backstage.domain.PaperTopic;
import com.imooc.backstage.domain.Result;
import com.imooc.backstage.repository.PaperTopicRepository;
import com.imooc.backstage.service.PaperTopicService;
import com.imooc.backstage.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/paperTopic")
public class PaperTopicController {


	private final static Logger logger = LoggerFactory.getLogger(PaperTopicController.class);

	@Autowired
	private PaperTopicRepository repository;

	@Autowired
	private PaperTopicService service;

	/**
	 * @return
	 * @Valid 注解表示要验证这个对象 BindingResult:验证结果
	 */
	@PostMapping(value = "/add")
	public Result<?> add(@Valid PaperTopic paper, BindingResult bindingResult) {
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
	public Result update(PaperTopic paper, @PathVariable("id") Integer id) {
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
	public Result select(PaperTopic paper, String name, @RequestParam(value = "page", defaultValue = "0") Integer page,
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
}
