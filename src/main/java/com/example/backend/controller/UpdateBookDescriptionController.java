package com.example.backend.controller;

import com.example.backend.pojo.Book;
import com.example.backend.service.book.BookInfoService;
import com.example.backend.service.book.UpdateDescriptionService;
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
// 更新书籍信息的逻辑Controller
@Api(tags = "update book logic controller")
@Controller
public class UpdateBookDescriptionController {

	@Autowired
	private UpdateDescriptionService updateDescriptionService;

	@Autowired
	private BookInfoService bookInfoService;

	// 正则表达式匹配项
	private static final String externPattern =
			"([\\w\\W]*)<([\\w\\W]*)>([\\w\\W]*)</([\\w\\W]*)>([\\w\\W]*)";
	private static final String inlinePattern =
			"([\\w\\W]*)<([\\w\\W]*)/>([\\w\\W]*)";

	@ApiOperation(value = "Update the books")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "reader", value = "username", required = true),
			@ApiImplicitParam(name = "title", value = "book's title", required = true),
			@ApiImplicitParam(name = "author", value = "book's author", required = true),
			@ApiImplicitParam(name = "newDescription", value = "The new description", required = true),
			@ApiImplicitParam(name = "model", value = "thymeleaf's param", required = false),
	})
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

		// 防止XSS注入
		if (newDescription.matches(externPattern) || newDescription.matches(inlinePattern)) {
			// 当遭受XSS注入时，返回错误页面
			model.addAttribute("type", "readingList");
			model.addAttribute("msg", "XSS!");
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
