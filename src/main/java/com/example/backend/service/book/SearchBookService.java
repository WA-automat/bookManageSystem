package com.example.backend.service.book;

import com.example.backend.pojo.Book;

import java.util.List;

/**
 * @author WA_automat
 * @version 1.0
 * @since 2022-10-19
 */
public interface SearchBookService {
	// 通过一个字符串查找对应的一些信息
	public List<Book> searchBook(String str);
}
