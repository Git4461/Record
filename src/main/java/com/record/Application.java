package com.record;

import com.util.PhantomJS;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Ys 2019/11/15 15:39
 */
public class Application {

    public static void main(String[] args) {
        String ajaxCotnent = PhantomJS.getAjaxContent("http://www.baidu.com");
        System.out.println();
        Document parse = Jsoup.parse(ajaxCotnent.substring(ajaxCotnent.indexOf("<html"), ajaxCotnent.indexOf("</html>")+7));
        System.out.println(parse.getElementsByClass("rec-item").size());
    }
}
