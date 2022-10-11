package com.example.backend.utils;

import com.example.backend.pojo.Book;

import java.util.Comparator;

// 排序辅助类
public class BookComparator implements Comparator<Book> {

	// 按作者姓名排序，调用Book中的排序方法
	@Override
	public int compare(Book o1, Book o2) {
		return o1.compareTo(o2);
	}

}
