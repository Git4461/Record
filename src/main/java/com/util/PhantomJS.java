package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PhantomJS {
	/**
	 * 获取网页内容
	 * 
	 * @param url
	 *            链接
	 * @return 返回网页内容
	 * @throws IOException
	 */
	public static String getAjaxContent(String url){
        StringBuffer sbf = new StringBuffer();
	    try {
            String directory = System.getProperty("user.dir");
            StringBuffer cmd = new StringBuffer();
            cmd.append(directory).append("\\PhantomJS\\phantomjs.exe ")
                    .append(directory).append("\\PhantomJS\\crawler_js\\crawler.js ")
                    .append(url);
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(cmd.toString());
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is,
                    "utf-8"));
            String tmp = "";
            while ((tmp = br.readLine()) != null) {
                sbf.append(tmp).append("\n");
            }
        }catch (Exception e){
	        e.printStackTrace();
        }
		return sbf.toString();
	}
}
