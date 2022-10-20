package com.example.backend.controller;

import com.example.backend.pojo.Book;
import com.example.backend.service.book.SearchBookService;
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
 * @version 1.0
 * @since 2022-10-20
 */
// 搜索框绑定函数
// 用于查询所有人的书籍
@Api(tags = "Search book logic controller")
@Controller
public class SearchBookController {

	// 导入对应的Service
	@Autowired
	private SearchBookService searchBookService;

	// 正则表达式匹配项
	private static final String externPattern =
			"([\\w\\W]*)<([\\w\\W]*)>([\\w\\W]*)</([\\w\\W]*)>([\\w\\W]*)";
	private static final String inlinePattern =
			"([\\w\\W]*)<([\\w\\W]*)/>([\\w\\W]*)";

	@ApiOperation(value = "Query books in the database")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "reader", value = "username", required = true),
			@ApiImplicitParam(name = "pattern", value = "matching pattern string", required = true),
			@ApiImplicitParam(name = "model", value = "thymeleaf's param", required = false)
	})
	@RequestMapping("/{reader}/search")
	public String searchList(
			@PathVariable("reader") String reader,
			String pattern,
			Model model
	) {
		// 防止输入空值
		if (pattern == null) {
			model.addAttribute("type", "readingList");
			model.addAttribute("msg", "Do not search for null values!");
			model.addAttribute("reader", reader);
			return "errorMessage";
		} else if (pattern.equals("")) {
			model.addAttribute("type", "readingList");
			model.addAttribute("msg", "Do not search for null values!");
			model.addAttribute("reader", reader);
			return "errorMessage";
		}

		// 防止XSS注入
		if (pattern.matches(externPattern) || pattern.matches(inlinePattern)) {
			// 当遭受XSS注入时，返回错误页面
			model.addAttribute("type", "readingList");
			model.addAttribute("msg", "XSS!");
			model.addAttribute("reader", reader);
			return "errorMessage";
		}

		// 使用Service得到对应于匹配模式串的书单
		List<Book> searchList = searchBookService.searchBook(pattern);

		// 查询不到任何书籍时，返回错误页面
		if (searchList.isEmpty()) {
			model.addAttribute("type", "readingList");
			model.addAttribute("msg", "No books can be found!");
			model.addAttribute("reader", reader);
			return "errorMessage";
		}

		// 查询到书籍时，返回整个书单
		model.addAttribute("reader", reader);
		model.addAttribute("booklist", searchList);
		model.addAttribute("listType", false);
		return "readingList";

	}

}
