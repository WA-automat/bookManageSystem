package com.example.backend.service.Impl.book;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.mapper.BookMapper;
import com.example.backend.pojo.Book;
import com.example.backend.service.book.DeleteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WA_automat
 * @version 1.0
 * @since 2022-10-12
 */
// 向数据库中删除一个元组
// 用于用户在书单中删除一本书
@Service
public class DeleteBookServiceImpl implements DeleteBookService {

	// 导入数据库映射
	@Autowired
	private BookMapper bookMapper;

	// 覆写方法
	@Override
	public String deleteBook(String reader,
	                         String title,
	                         String author) {

		// 创建一个查询数据库的对象
		// 当某人的书单中没有该书，拒绝删除
		QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("reader", reader);
		queryWrapper.eq("title", title);
		queryWrapper.eq("author", author);
		List<Book> list = bookMapper.selectList(queryWrapper);

		// 正确找到书籍，删除并返回正确信息
		if (!list.isEmpty()) {
			bookMapper.delete(queryWrapper);
			return "success";
		}
		// 当找不到书籍时，返回错误信息
		return "error";

	}
}
