package com.example.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
	// 使用IdType将id设置为自动增加
	@TableId(type = IdType.AUTO)
	private Integer id;

	// 所有属性都不可为空
	@NonNull
	private String reader;          // 读者名称
	@NonNull
	private String title;           // 书名
	@NonNull
	private String author;          // 作者名
	@NonNull
	private String description;     // 对书籍的描述

	// 自定义排序方式 (这里按作者姓名排序)
	public int compareTo(Book book) {
		return this.author.compareTo(book.author);
	}

}
