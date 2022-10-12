package com.example.backend.service.Impl.book;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.mapper.BookMapper;
import com.example.backend.pojo.Book;
import com.example.backend.service.book.AddBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WA_automat
 * @version 1.0
 * @since 2022-10-12
 */
// 向数据库中添加一个元组
// 用于用户在书单中添加一本书
@Service
public class AddBookServiceImpl implements AddBookService {

	// 导入数据库映射
	@Autowired
	private BookMapper bookMapper;

	// 覆写方法
	@Override
	public String addBook(String reader,
	                      String title,
	                      String author,
	                      String description) {

		// 创建一个查询数据库的对象
		// 当某人的书单中已经出现过该书，拒绝添加
		QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("reader", reader);
		queryWrapper.eq("title", title);
		queryWrapper.eq("author", author);
		List<Book> list = bookMapper.selectList(queryWrapper);

		if (list.isEmpty()) {
			// 创建当前的书并添加至某人的书单中
			Book book = new Book(null, reader, title, author, description);
			bookMapper.insert(book);
			return "success";
		}
		// 当出现过该书时，返回错误信息
		return "error";

	}
}
