package com.imooc.backstage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.env.Environment;

import java.math.BigDecimal;

@SpringBootApplication
//添加过滤器
public class BackstageApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackstageApplication.class, args);
		/*SpringApplication app = new SpringApplication(BackstageApplication.class);
		 Environment environment = app.run(args).getEnvironment();*/
		BigDecimal bd=new BigDecimal("0.22");
		System.out.println(bd.compareTo(BigDecimal.ZERO)==1);
		System.out.println(" / ".split("/").length);
	}
}
