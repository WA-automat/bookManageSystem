package com.example.backend.controller;

import com.example.backend.pojo.Book;
import com.example.backend.service.book.AddBookService;
import com.example.backend.service.book.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

// 添加书籍的逻辑Controller
@Controller
public class AddBookController {

	@Autowired
	private AddBookService addBookService;

	@Autowired
	private BookInfoService bookInfoService;

	@RequestMapping(value = "/add/{reader}",
			method = RequestMethod.POST)
	public String addBook(
			@PathVariable("reader") String reader,
			String title,
			String author,
			String description,
			Model model
	) {
		String message = addBookService.addBook(reader, title, author, description);
		if (message.equals("success")) {
			// 转移至readingList页面
			List<Book> booklist = bookInfoService.getInfo(reader);
			model.addAttribute("reader", reader);
			model.addAttribute("booklist", booklist);
			return "readingList";
		} else if (title.equals("") || author.equals("") || description.equals("")) {
			// 当输入的内容为空时，返回错误页面
			model.addAttribute("type", "addBook");
			model.addAttribute("msg", "Do not enter null values");
			model.addAttribute("reader", reader);
			return "errorMessage";
		} else {
			// 当输入的内容已经存在时
			model.addAttribute("type", "addBook");
			model.addAttribute("msg", "Please do not add duplicate books");
			model.addAttribute("reader", reader);
			return "errorMessage";
		}
	}

}
