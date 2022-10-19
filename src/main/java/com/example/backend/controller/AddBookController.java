package com.example.backend.controller;

import com.example.backend.pojo.Book;
import com.example.backend.service.book.AddBookService;
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
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author WA_automat
 * @version 1.0
 * @since 2022-10-12
 */
// 添加书籍的逻辑Controller
@Api(tags = "Add book logic controller")
@Controller
public class AddBookController {

	// 导入ServiceImpl
	@Autowired
	private AddBookService addBookService;

	// 导入ServiceImpl
	@Autowired
	private BookInfoService bookInfoService;

	// 正则表达式匹配项
	private static final String externPattern =
			"([\\w\\W]*)<([\\w\\W]*)>([\\w\\W]*)</([\\w\\W]*)>([\\w\\W]*)";
	private static final String inlinePattern =
			"([\\w\\W]*)<([\\w\\W]*)/>([\\w\\W]*)";

	@ApiOperation(value = "Add books to the database")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "reader", value = "username", required = true),
			@ApiImplicitParam(name = "title", value = "book's title", required = true),
			@ApiImplicitParam(name = "author", value = "book's author", required = true),
			@ApiImplicitParam(name = "description", value = "Readers' comment on the book", required = true),
			@ApiImplicitParam(name = "model", value = "thymeleaf's param", required = false),
	})
	@RequestMapping(value = "/add/{reader}",
			method = RequestMethod.POST)
	public String addBook(
			@PathVariable("reader") String reader,
			String title,
			String author,
			String description,
			Model model
	) {
		if (title == null || author == null || description == null) {
			// 当输入的内容为null时，返回错误页面
			model.addAttribute("type", "addBook");
			model.addAttribute("msg", "Do not enter null values");
			model.addAttribute("reader", reader);
			return "errorMessage";
		} else if (title.equals("") || author.equals("") || description.equals("")) {
			// 当输入的内容为空时，返回错误页面
			model.addAttribute("type", "addBook");
			model.addAttribute("msg", "Do not enter null values");
			model.addAttribute("reader", reader);
			return "errorMessage";
		}

		// 防止XSS注入
		if (title.matches(externPattern) || author.matches(externPattern) || description.matches(externPattern)
				|| title.matches(inlinePattern) || author.matches(inlinePattern) || description.matches(inlinePattern)) {
			// 当遭受XSS注入时，返回错误页面
			model.addAttribute("type", "addBook");
			model.addAttribute("msg", "XSS!");
			model.addAttribute("reader", reader);
			return "errorMessage";
		}

		// 获取Service结果
		String message = addBookService.addBook(reader, title, author, description);
		if (message.equals("success")) {
			// 转移至readingList页面
			List<Book> booklist = bookInfoService.getInfo(reader);
			// 记得排序
			booklist.sort(new BookComparator());

			model.addAttribute("reader", reader);
			model.addAttribute("booklist", booklist);
			return "readingList";
		} else {
			// 当输入的内容已经存在时
			model.addAttribute("type", "addBook");
			model.addAttribute("msg", "Please do not add duplicate books");
			model.addAttribute("reader", reader);
			return "errorMessage";
		}
	}

}
