package com.example.backend.controller;

import com.example.backend.pojo.Book;
import com.example.backend.service.book.BookInfoService;
import com.example.backend.service.book.UpdateDescriptionService;
import com.example.backend.utils.BookComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UpdateBookDescriptionController {

	@Autowired
	private UpdateDescriptionService updateDescriptionService;

	@Autowired
	private BookInfoService bookInfoService;

	@RequestMapping(value = "/update/{reader}/{title}/{author}",
			method = RequestMethod.POST)
	public String update(
			@PathVariable("reader") String reader,
			@PathVariable("title") String title,
			@PathVariable("author") String author,
			String newDescription,
			Model model
	) {

		if (newDescription == null) {
			// 当更新的description为null时，返回错误信息
			model.addAttribute("type", "readingList");
			model.addAttribute("msg", "Do not enter null values");
			model.addAttribute("reader", reader);
			return "errorMessage";
		} else if (newDescription.equals("")) {
			// 当更新的description为空时，返回错误信息
			model.addAttribute("type", "readingList");
			model.addAttribute("msg", "Do not enter null values");
			model.addAttribute("reader", reader);
			return "errorMessage";
		}

		// 更新书籍的内容
		updateDescriptionService.updateDescription(
				reader, title, author, newDescription
		);

		// 转移至readingList页面
		List<Book> booklist = bookInfoService.getInfo(reader);
		// 记得排序
		booklist.sort(new BookComparator());

		model.addAttribute("reader", reader);
		model.addAttribute("booklist", booklist);
		return "readingList";

	}

}
