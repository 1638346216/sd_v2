package com.soft.utils;

/**
 * 通用工具类
 * 
 * @author 17117
 *
 */
public class MyUtils {
	/**
	 * 获得指定类的实例对象
	 * 
	 * @param clazz
	 *            指定的类型
	 * @return 类型T的实例对象
	 */
	public static <T> T getNewInstance(Class<T> clazz) {
		// 准备默认返回值
		T t = null;
		try {
			// 获得实例对象t
			t = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回t
		return t;
	}

}
