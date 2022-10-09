package com.example.backend.service.Impl.book;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.mapper.BookMapper;
import com.example.backend.pojo.Book;
import com.example.backend.service.book.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 访问数据库
// 获取数据库中某reader的书单
@Service
public class BookInfoServiceImpl implements BookInfoService {

	@Autowired
	private BookMapper bookMapper;

	@Override
	public List<Book> getInfo(String reader) {

		// 取出reader等于实参的元组
		QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("reader", reader);
		return bookMapper.selectList(queryWrapper);

	}

}
