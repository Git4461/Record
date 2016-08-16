package com.util;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class Crawler {
	/**
	 * 获取连接
	 * 
	 * @param url
	 *            连接地址
	 * @return 返回连接对象
	 */
	public static Connection getConnection(String url) {
		return Jsoup
				.connect(url)
				.header("Accept",
						"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
				.header("Accept-Language", "zh-CN,zh;q=0.8")
				.header("Cache-Control", "max-age=0")
				.header("Connection", "keep-alive")
				.header("Upgrade-Insecure-Requests", "1")
				.header("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36 QQBrowser/9.3.6874.400");
	}
}
