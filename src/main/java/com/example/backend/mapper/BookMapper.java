package com.example.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backend.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author WA_automat
 * @version 1.0
 * @since 2022-10-12
 */
// 定义一个与数据库进行交互的接口
// 接口继承自BaseMapper泛型基类
// 由@Mapper自动实现增删改查的数据库函数
// 在编译后实现
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
