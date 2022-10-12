package com.example.backend.controller;


import com.example.backend.pojo.Book;
import com.example.backend.service.book.BookInfoService;
import com.example.backend.utils.BookComparator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author WA_automat
 * @since 2022-10-12
 * @version 1.0
 */
// 书单的页面Controller
@Api(tags = "reading list page controller")
@Controller
public class ReadingListController {

	// 导入ServiceImpl
	@Autowired
	private BookInfoService bookInfoService;

	@ApiOperation(value = "Redirected to readingList")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "reader", value = "username", required = true),
			@ApiImplicitParam(name = "model", value = "thymeleaf's param", required = false),
	})
	@RequestMapping("/readingList/{reader}")
	public String test(
			@PathVariable String reader,
			Model model
	) {

		// 获取该读者的书单列表，并向Thymeleaf传入读者与书单
		List<Book> booklist = bookInfoService.getInfo(reader);
		// 记得排序
		booklist.sort(new BookComparator());

		// 导入变量
		model.addAttribute("reader", reader);
		model.addAttribute("booklist", booklist);
		return "readingList";

	}

}
