package poidemo.poidemos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class DemoPoi {
	public static void main(String[] args) throws IOException {
		String filePath = "e:\\sample.xls";// 文件路径
		// 创建Excel文件(Workbook)
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建工作表(Sheet)
		HSSFSheet sheet = workbook.createSheet();
		sheet = workbook.createSheet("Test");
		// 创建行,从0开始
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);// 创建行的单元格,也是从0开始
		cell.setCellValue("李志伟");// 设置单元格内容
		row.createCell(1).setCellValue(false);// 设置单元格内容,重载
		row.createCell(2).setCellValue(new Date());// 设置单元格内容,重载
		row.createCell(3).setCellValue(12.345);// 设置单元格内容,重载
		// 创建文档描述
		workbook.createInformationProperties();// 创建文档信息
		DocumentSummaryInformation dsi = workbook.getDocumentSummaryInformation();// 摘要信息
		dsi.setCategory("类别:Excel文件");// 类别
		dsi.setManager("管理者:李志伟");// 管理者
		dsi.setCompany("公司:--");// 公司
		SummaryInformation si = workbook.getSummaryInformation();// 摘要信息
		si.setSubject("主题:--");// 主题
		si.setTitle("标题:测试文档");// 标题
		si.setAuthor("作者:李志伟");// 作者
		si.setComments("备注:POI测试文档");// 备注
		FileOutputStream out;
		try {
			out = new FileOutputStream(filePath);
			workbook.write(out);// 保存Excel文件
			out.close();// 关闭文件流
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("OK!");
	}
}
