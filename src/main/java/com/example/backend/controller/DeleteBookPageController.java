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
// 删除书籍的页面Controller
@Api(tags = "Delete book page controller")
@Controller
public class DeleteBookPageController {

	@ApiOperation(value = "Redirected to deleteBookPage")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "reader", value = "username", required = true),
			@ApiImplicitParam(name = "model", value = "thymeleaf's param", required = false),
	})
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
