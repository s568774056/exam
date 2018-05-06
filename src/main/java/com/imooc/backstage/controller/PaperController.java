package com.imooc.backstage.controller;

import com.imooc.backstage.domain.Paper;
import com.imooc.backstage.domain.Result;
import com.imooc.backstage.repository.PaperRepository;
import com.imooc.backstage.service.PaperService;
import com.imooc.backstage.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/paper")
public class PaperController {


	private final static Logger logger = LoggerFactory.getLogger(PaperController.class);

	@Autowired
	private PaperRepository repository;

	@Autowired
	private PaperService service;

	/**
	 * @return
	 * @Valid 注解表示要验证这个对象 BindingResult:验证结果
	 */
	@PostMapping(value = "/add")
	public Result<?> add(@Valid Paper paper, BindingResult bindingResult) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		paper.setCreateDate(df.format(new Date()));
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
	public Result update(Paper paper, @PathVariable("id") Integer id) {
		paper.setId(id);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		paper.setUpdateDate(df.format(new Date()));
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
	public Result select(Paper paper, @RequestParam(value = "page", defaultValue = "0") Integer page,
						 @RequestParam(value = "size", defaultValue = "15") Integer size) {

		return service.select(paper, page, size);
	}

	/**
	 * @return
	 */
	@PostMapping(value = "/findAll")
	public Result findAll() {
		return ResultUtil.success(repository.findAll());
	}
}
