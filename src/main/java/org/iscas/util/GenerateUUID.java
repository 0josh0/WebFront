/**
 * 
 */
package org.iscas.util;

import java.util.UUID;

/**
 * @Title: GenerateUUID
 * @Description:TODO
 * @author Summer
 * @date 2017年4月19日 下午5:36:08
 * 
 */
public class GenerateUUID {

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		// 去掉"-"符号
		String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23)
				+ str.substring(24);
		return temp;
	}
}
