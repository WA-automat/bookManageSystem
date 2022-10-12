package com.example.backend.service.book;

/**
 * @author WA_automat
 * @version 1.0
 * @since 2022-10-12
 */
public interface DeleteBookService {
	// 向指定阅读者的书单中删除一本书
	public String deleteBook(String reader,
	                         String title,
	                         String author);
}
