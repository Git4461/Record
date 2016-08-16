package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class DataUtil {

	/**
	 * 读取文件
	 * 
	 * @param FILEPATH
	 *            文件路径
	 * @return
	 * @throws IOException
	 */
	public static String readFile(String fileName) throws IOException {
		File f = new File(fileName);
		if (!f.exists()) {
			return null;
		}
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		StringBuffer sb = new StringBuffer();
		String line = "";
		while ((line = br.readLine()) != null) {
			sb.append(line).append("\n");
		}
		fr.close();
		br.close();
		return sb.toString();
	}

	/**
	 * 写入文件
	 * 
	 * @param fileName
	 *            文件名
	 * @param content
	 *            内容
	 * @throws IOException
	 */
	public static void writeIni(String fileName, String content)
			throws IOException {
		FileOutputStream f = new FileOutputStream(new File(fileName));
		f.write(content.getBytes());
		f.close();
	}

	/**
	 * 获取项目根目录
	 * 
	 * @return 返回目录路径
	 */
	public static String getProjectRootDirectory() {
		String directory = System.getProperty("user.dir");
		return directory;
	}
}
