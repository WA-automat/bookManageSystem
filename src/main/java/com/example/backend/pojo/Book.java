package com.example.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author WA_automat
 * @version 1.0
 * @since 2022-10-12
 */
// 书的pojo类
// 目的为链接数据库和java文件
// @Data导入了必要的函数
// @NoArgsConstructor导入无参构造函数
// @AllArgsConstructor导入全参构造函数
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Book", description = "Book pojo")
public class Book {

	// id作为读者的主键
	// 使用IdType将id设置为自动增加
	@TableId(type = IdType.AUTO)
	@ApiModelProperty(value = "bookId", required = true)
	private Integer id;

	// 所有属性都不可为空
	@NonNull
	@ApiModelProperty(value = "reader", required = true)
	private String reader;          // 读者名称

	@NonNull
	@ApiModelProperty(value = "book's title", required = true)
	private String title;           // 书名

	@NonNull
	@ApiModelProperty(value = "book's author", required = true)
	private String author;          // 作者名

	@NonNull
	@ApiModelProperty(value = "book's description", required = true)
	private String description;     // 对书籍的描述

	// 自定义排序方式 (这里按作者姓名排序)
	public int compareTo(Book book) {
		return this.author.compareTo(book.author);
	}

}
