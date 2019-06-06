/**
 * 
 */
package com.fsbay.frame.tencentcloudapi;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.file.FileReader;

/**
 * @author John
 *
 */
public class ImageTools {

	public static void main(String args[]) {
		FileReader fileReader = new FileReader("E:\\我的文档\\爱尔眼科\\人脸识别\\pic\\1.jpg");
		byte[] b = fileReader.readBytes();
		System.out.println(Base64.encode(b));
	}
}
