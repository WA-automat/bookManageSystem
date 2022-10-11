package com.example.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

// 用户的pojo类
// 目的为链接数据库和java文件
// @Data导入了必要的函数
// @NoArgsConstructor导入无参构造函数
// @AllArgsConstructor导入全参构造函数
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reader {

	@NonNull
	@TableId(type=IdType.NONE)
	private String readerName;

	@NonNull
	private String password;

	private String photo = null;
	private String email = null;

	// 自定义排序方式 (这里按用户名称排序)
	public int compareTo(Reader reader) {
		return this.readerName.compareTo(reader.readerName);
	}

}
