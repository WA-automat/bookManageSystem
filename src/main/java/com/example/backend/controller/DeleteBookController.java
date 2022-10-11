package com.example.backend.controller;

import com.example.backend.pojo.Book;
import com.example.backend.service.book.BookInfoService;
import com.example.backend.service.book.DeleteBookService;
import com.example.backend.utils.BookComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

// 删除书籍的逻辑Controller
@Controller
public class DeleteBookController {

	// 导入ServiceImpl
	@Autowired
	private DeleteBookService deleteBookService;

	// 导入ServiceImpl
	@Autowired
	private BookInfoService bookInfoService;

	@RequestMapping(value = "/delete/{reader}",
			method = RequestMethod.POST)
	public String deleteBook(
			@PathVariable("reader") String reader,
			String title,
			String author,
			Model model
	) {
		if (title == null || author == null) {
			// 当删除内容为null时，返回错误页面
			model.addAttribute("type", "deleteBook");
			model.addAttribute("msg", "Do not enter null values");
			model.addAttribute("reader", reader);
			return "errorMessage";
		} else if (title.equals("") || author.equals("")) {
			// 当删除内容为空时，返回错误页面
			model.addAttribute("type", "deleteBook");
			model.addAttribute("msg", "Do not enter null values");
			model.addAttribute("reader", reader);
			return "errorMessage";
		}

		// 获取Service结果
		String message = deleteBookService.deleteBook(reader, title, author);
		if (message.equals("success")) {
			// 转移至readingList页面
			List<Book> booklist = bookInfoService.getInfo(reader);
			// 记得排序
			booklist.sort(new BookComparator());

			model.addAttribute("reader", reader);
			model.addAttribute("booklist", booklist);
			return "readingList";
		} else {
			model.addAttribute("type", "deleteBook");
			model.addAttribute("msg", "Please do not delete that have not been added");
			model.addAttribute("reader", reader);
			return "errorMessage";
		}
	}

}
