package com.example.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// 添加书籍的页面Controller
@Controller
public class AddBookPageController {

	@RequestMapping("/addBook/{reader}")
	public String addBookPage(
			@PathVariable("reader") String reader,
			Model model
	) {
		// 传入读者变量
		model.addAttribute("reader", reader);
		return "addBookPage";
	}

}
