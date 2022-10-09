package com.example.backend.service.book;

public interface AddBookService {
	// 向指定阅读者的书单中添加一本书
	public String addBook(String reader,
	                      String title,
	                      String author,
	                      String description);
}
