package com.example.backend.controller;

import com.example.backend.pojo.Book;
import com.example.backend.service.book.BookInfoService;
import com.example.backend.service.book.UpdateDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UpdateBookDescriptionController {

	@Autowired
	private UpdateDescriptionService updateDescriptionService;

	@Autowired
	private BookInfoService bookInfoService;

	@RequestMapping("/update/{reader}/{title}/{author}")
	public String update(
			@PathVariable("reader") String reader,
			@PathVariable("title") String title,
			@PathVariable("author") String author,
			String newDescription,
			Model model
	) {

		// 更新书籍的内容
		updateDescriptionService.updateDescription(
				reader, title, author, newDescription
		);

		// 转移至readingList页面
		List<Book> booklist = bookInfoService.getInfo(reader);
		model.addAttribute("reader", reader);
		model.addAttribute("booklist", booklist);
		return "readingList";

	}

}
