package com.other;

import java.io.IOException;

import com.util.PhantomJS;

public class sina_car {

	public static void main(String[] args) throws IOException {
		String s = PhantomJS
				.getAjaxCotnent("https://www.baidu.com/");
		System.out.println(s);
	}
}