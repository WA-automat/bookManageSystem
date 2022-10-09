package com.example.backend.service.book;

public interface DeleteBookService {
	// 向指定阅读者的书单中删除一本书
	public String deleteBook(String reader,
	                         String title,
	                         String author);
}
