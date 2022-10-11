package com.example.backend.utils;

import com.example.backend.pojo.Book;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		return o1.compareTo(o2);
	}

}
