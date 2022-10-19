package com.example.backend.service.Impl.book;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.mapper.BookMapper;
import com.example.backend.pojo.Book;
import com.example.backend.service.book.SearchBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WA_automat
 * @version 1.0
 * @since 2022-10-19
 */
// 在数据库中查找与搜索字符串有关的书籍
@Service
public class SearchBookServiceImpl implements SearchBookService {

	// 导入数据库映射
	@Autowired
	private BookMapper bookMapper;

	@Override
	public List<Book> searchBook(String str) {

		// 创建一个查询数据库的对象
		// 使用like进行正则匹配取出结果
		QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
		queryWrapper.like("title", str)
				.or()
				.like("author", str)
				.or()
				.like("description", str);

		// 根据查询获取结果
		return bookMapper.selectList(queryWrapper);
	}

}
