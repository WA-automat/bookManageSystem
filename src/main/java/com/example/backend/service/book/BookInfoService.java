package com.example.backend.service.book;

import com.example.backend.pojo.Book;

import java.util.List;

public interface BookInfoService {
	// 获取某个reader的全部书单内容
	public List<Book> getInfo(String reader);
}
