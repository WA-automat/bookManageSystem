package com.example.backend.service.book;

/**
 * @author WA_automat
 * @version 1.0
 * @since 2022-10-12
 */
public interface AddBookService {
	// 向指定阅读者的书单中添加一本书
	public String addBook(String reader,
	                      String title,
	                      String author,
	                      String description);
}
