package com.example.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// 删除书籍的页面Controller
@Controller
public class DeleteBookPageController {

	@RequestMapping("/deleteBook/{reader}")
	public String deleteBookPage(
			@PathVariable("reader") String reader,
			Model model
	) {

		// 传入读者变量
		model.addAttribute("reader", reader);
		return "deleteBookPage";

	}

}
