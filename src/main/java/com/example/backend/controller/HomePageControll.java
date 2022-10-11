package com.example.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// 主页的页面Controller
@Controller
public class HomePageControll {

	@RequestMapping("/home/{reader}")
	public String home(
			@PathVariable("reader") String reader,
			Model model) {

		// 传入读者变量
		model.addAttribute("reader", reader);
		return "homePage";

	}

}
