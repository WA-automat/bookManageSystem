package com.example.backend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author WA_automat
 * @version 1.0
 * @since 2022-10-12
 */
// 主页的页面Controller
@Api(tags = "Home page controller")
@Controller
public class HomePageControll {

	// 将reader路径重定向至home页面
	@ApiOperation(value = "Redirected '/' to HomePage")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "reader", value = "username", required = true),
			@ApiImplicitParam(name = "model", value = "thymeleaf's param", required = false),
	})
	@RequestMapping("/{reader}")
	public String index(
			@PathVariable("reader") String reader,
			Model model
	) {

		// 传入读者变量
		model.addAttribute("reader", reader);
		return "homePage";

	}


	@ApiOperation(value = "Redirected to HomePage")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "reader", value = "username", required = true),
			@ApiImplicitParam(name = "model", value = "thymeleaf's param", required = false),
	})
	@RequestMapping("/home/{reader}")
	public String home(
			@PathVariable("reader") String reader,
			Model model) {

		// 传入读者变量
		model.addAttribute("reader", reader);
		return "homePage";

	}

}
