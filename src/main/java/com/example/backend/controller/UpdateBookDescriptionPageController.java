package com.example.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// 用于更新书籍的描述的Controller
@Controller
public class UpdateBookDescriptionPageController {

	@RequestMapping("/updateBook/{reader}/{title}/{author}")
	public String updateBookPage(
			@PathVariable("reader") String reader,
			@PathVariable("title") String title,
			@PathVariable("author") String author,
			Model model
	){

		// 传入变量
		model.addAttribute("reader", reader);
		model.addAttribute("title", title);
		model.addAttribute("author", author);
		return "updateBookPage";

	}

}
