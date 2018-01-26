package com.soft.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 将字符串转换为date对象，注册的时间转换器
 * 
 * @author 17117
 *
 */
public class DateConvertor implements Converter<String, Date> {
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.
	 * Object)
	 */
	@Override
	public Date convert(String str) {

		Date date = null;
		// 转换时间对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// 不为空就转换
			if (str != null && !str.equals(""))
				date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 返回时间类型
		return date;
	}

}
