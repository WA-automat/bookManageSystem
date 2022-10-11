package com.example.backend.service.Impl.book;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.mapper.BookMapper;
import com.example.backend.pojo.Book;
import com.example.backend.service.book.UpdateDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateDescriptionServiceImpl implements UpdateDescriptionService {

	@Autowired
	private BookMapper bookMapper;

	@Override
	public String updateDescription(String reader, String title, String author, String newDescription) {

		QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("reader", reader);
		queryWrapper.eq("title", title);
		queryWrapper.eq("author", author);
		List<Book> list = bookMapper.selectList(queryWrapper);

		if (!list.isEmpty()) {
			bookMapper.delete(queryWrapper);
			Book book = new Book(null, reader, title, author, newDescription);
			bookMapper.insert(book);
			return "success";
		}
		return "error";

	}
}
