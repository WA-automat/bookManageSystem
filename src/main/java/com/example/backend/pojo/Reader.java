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
// 用户的pojo类
// 目的为链接数据库和java文件
// @Data导入了必要的函数
// @NoArgsConstructor导入无参构造函数
// @AllArgsConstructor导入全参构造函数
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Reader", description = "Reader pojo")
public class Reader {

	@NonNull
	@TableId(type=IdType.NONE)
	@ApiModelProperty(value = "username", required = true)
	private String readerName;

	@NonNull
	@ApiModelProperty(value = "user's password", required = true)
	private String password;

	@ApiModelProperty(value = "user's photo", required = false)
	private String photo = null;
	@ApiModelProperty(value = "user's email", required = false)
	private String email = null;

	// 自定义排序方式 (这里按用户名称排序)
	public int compareTo(Reader reader) {
		return this.readerName.compareTo(reader.readerName);
	}

}
