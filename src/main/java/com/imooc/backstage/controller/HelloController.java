package com.imooc.backstage.controller;

import com.imooc.backstage.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@Value("${girl.cupSize}")
	private String cupSize;//从配置文件中获取值
    @Autowired
    private GirlProperties girlProperties;

    //required = false不是必传
    @PostMapping(value = "/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
    	System.out.println("{girl.cupSize}:  "+cupSize);
        return "id: " + myId;
//        return girlProperties.getCupSize();
    }
    @GetMapping(value = "/index")
    public String index() {
        return "index";
//        return girlProperties.getCupSize();
    }
}
