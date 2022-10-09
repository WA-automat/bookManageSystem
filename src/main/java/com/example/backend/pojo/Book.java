package com.example.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 书的pojo类
// 目的为链接数据库和java文件
// @Data导入了必要的函数
// @NoArgsConstructor导入无参构造函数
// @AllArgsConstructor导入全参构造函数
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	// id作为读者的主键
	@TableId(type = IdType.AUTO)
	private Integer id;

	private String reader;          // 读者名称
	private String title;           // 书名
	private String author;          // 作者名
	private String description;     // 对书籍的描述

}
