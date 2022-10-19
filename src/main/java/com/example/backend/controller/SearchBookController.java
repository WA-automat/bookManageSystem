package com.example.backend.controller;

import com.example.backend.pojo.Book;
import com.example.backend.service.book.SearchBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchBookController {

	@Autowired
	private SearchBookService searchBookService;

	@RequestMapping("/search/{pattern}")
	public List<Book> searchList(@PathVariable("pattern") String pattern) {
		return searchBookService.searchBook(pattern);
	}

}
