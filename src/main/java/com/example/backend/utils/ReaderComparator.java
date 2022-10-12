package com.example.backend.utils;

import com.example.backend.pojo.Reader;

import java.util.Comparator;

/**
 * @author WA_automat
 * @version 1.0
 * @since 2022-10-12
 */
// 排序辅助类
public class ReaderComparator implements Comparator<Reader> {

	// 按用户姓名排序，调用Reader中的排序方法
	@Override
	public int compare(Reader o1, Reader o2) {
		return o1.compareTo(o2);
	}

}
