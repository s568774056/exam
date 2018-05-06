package com.imooc.backstage.controller;

import com.imooc.backstage.domain.Result;
import com.imooc.backstage.domain.Topic;
import com.imooc.backstage.repository.TopicRepository;
import com.imooc.backstage.service.TopicService;
import com.imooc.backstage.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/topic")
public class TopicController {


	private final static Logger logger = LoggerFactory.getLogger(TopicController.class);

	@Autowired
	private TopicRepository repository;

	@Autowired
	private TopicService service;

	/**
	 * @return
	 * @Valid 注解表示要验证这个对象 BindingResult:验证结果
	 */
	@PostMapping(value = "/add")
	public Result<?> add(@Valid Topic topic, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		if(topic.getType().equals("1")&&topic.getOptionB().equals("")){
			return ResultUtil.error(1, "多选必须输入两个以上的选项");
		}
		return service.insert(topic);
	}

	// 删除
	@PostMapping(value = "/delete/{id}")
	public Result delete(@PathVariable("id") Integer id) {

		return service.delete(id);
	}

	// 修改
	@PostMapping(value = "/update/{id}")
	public Result update(Topic topic, @PathVariable("id") Integer id) {
		topic.setId(id);
		return service.update(topic);
	}

	// 根据id查询一个api
	@PostMapping(value = "/findById/{id}")
	public Result findOne(@PathVariable("id") Integer id) {
		return ResultUtil.success(repository.findOne(id));
	}

	/**
	 * 根據條件查询
	 * 
	 * @return
	 */
	@PostMapping(value = "/select")
	public Result select(Topic topic, @RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) {

		return service.select(topic, page, size);
	}

	/**
	 */
	@PostMapping(value = "/findAll")
	public Result findAll() {
		return ResultUtil.success(repository.findAll());
	}
}
