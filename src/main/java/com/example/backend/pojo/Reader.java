package com.example.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reader {

	@NonNull
	@TableId(type=IdType.NONE)
	private String readerName;

	@NonNull
	private String password;

	private String photo;
	private String email;
}
