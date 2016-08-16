package com.other;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.util.DataUtil;
import com.util.PhantomJS;

public class sina_car {

	private static String excelPath = "D:\\win7我的文档-桌面-收藏夹\\Desktop\\sina\\data.xlsx";

	public static void main(String[] args) throws Exception {
		for (int j = 97; j < 123; j++) {
			String content = "";
			String data = DataUtil
					.readFile("D:\\win7我的文档-桌面-收藏夹\\Desktop\\sina\\source\\"
							+ (char) j + ".html");
			Document d = Jsoup.parse(data);
			Element et = d.getElementById("J_seekList");
			Elements chexing = et.getElementsByClass("pro-sale");

			for (Element e : chexing) {
				String chexingString = e.text();// 车型
				content += chexingString + "\r\n";
				Element e2 = e.nextElementSibling();
				for (int i = 0; e2 != null && e2.tagName() != "div"; i += 1) {
					String leiBieStringName = "";
					if (i % 2 == 0) {
						leiBieStringName = e2.child(0).text();
						content += "\t" + leiBieStringName + "\r\n";
					} else {
						Elements esUl = e2.getElementsByTag("li");
						for (Element li : esUl) {
							String beizhu = li.child(0).text();
							String name = li.child(1).child(0).ownText();
							content += "\t\t" + name + "\t" + beizhu + "\r\n";
						}
					}
					e2 = e2.nextElementSibling();
				}

			}
			if (!content.trim().equals(""))
				DataUtil.writeIni("D:\\win7我的文档-桌面-收藏夹\\Desktop\\sina\\"
						+ (char) j + ".txt", content);
		}
	}

	@SuppressWarnings("resource")
	public static void createExcelFile(String path) throws Exception {
		Workbook workbook = new XSSFWorkbook();
		if (workbook != null) {
			Sheet sheet = workbook.createSheet("Sheet1");
			Row row0 = sheet.createRow(0);
			// Cell.CELL_TYPE_STRING
			Cell c1 = row0.createCell(0, Cell.CELL_TYPE_STRING);
			c1.setCellValue("车型");
			Cell c2 = row0.createCell(1, Cell.CELL_TYPE_STRING);
			c2.setCellValue("分类");
			Cell c3 = row0.createCell(2, Cell.CELL_TYPE_STRING);
			c3.setCellValue("型号");
			Cell c4 = row0.createCell(3, Cell.CELL_TYPE_STRING);
			c4.setCellValue("备注");

			FileOutputStream outputStream = new FileOutputStream(excelPath);
			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();
		}
	}

	/**
	 * 获取数据源
	 */
	public static void getSourceData() {
		for (int i = 97; i < 123; i++) {
			Thread t = new Thread(new sinaCarThread(
					"http://data.auto.sina.com.cn/#leter:::" + (char) i
							+ "?callback",
					"D:\\win7我的文档-桌面-收藏夹\\Desktop\\sina\\source\\" + (char) i
							+ ".html"));
			t.start();
		}
	}

}

class sinaCarThread implements Runnable {
	private String url;
	private String fileName;

	public sinaCarThread(String url, String fileName) {
		this.url = url;
		this.fileName = fileName;
	}

	@Override
	public void run() {
		try {
			String html = PhantomJS.getAjaxCotnent(url);
			DataUtil.writeIni(fileName, html);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}