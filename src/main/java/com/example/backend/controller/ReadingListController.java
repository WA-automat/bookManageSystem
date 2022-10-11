package com.example.backend.controller;


import com.example.backend.pojo.Book;
import com.example.backend.service.book.BookInfoService;
import com.example.backend.utils.BookComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

// 书单的页面Controller
@Controller
public class ReadingListController {

	// 导入ServiceImpl
	@Autowired
	private BookInfoService bookInfoService;

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
