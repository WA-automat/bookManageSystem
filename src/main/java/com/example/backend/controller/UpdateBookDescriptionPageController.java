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
 * @since 2022-10-12
 * @version 1.0
 */
// 用于更新书籍的描述的Controller
@Api(tags = "update book page controller")
@Controller
public class UpdateBookDescriptionPageController {

	@ApiOperation(value = "Redirected to updateBookDescriptionPage")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "reader", value = "username", required = true),
			@ApiImplicitParam(name = "title", value = "book's title", required = true),
			@ApiImplicitParam(name = "author", value = "book's author", required = true),
			@ApiImplicitParam(name = "model", value = "thymeleaf's param", required = false),
	})
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
