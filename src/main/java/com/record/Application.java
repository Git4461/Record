package com.record;

import com.util.PhantomJS;

/**
 * @author Ys 2019/11/15 15:39
 */
public class Application {

    public static void main(String[] args) {
        String ajaxCotnent = PhantomJS.getAjaxContent("http://www.baidu.com");
        System.out.println(ajaxCotnent);
    }
}
