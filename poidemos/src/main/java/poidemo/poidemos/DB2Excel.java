package poidemo.poidemos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

public class DB2Excel {
	public List<Map<String, Object>> Query4List() throws SQLException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from userinfo";
		Connection conn = Conn2mysql.getDBConnection();
		PreparedStatement prep = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet resu = prep.executeQuery();
		ResultSetMetaData md = (ResultSetMetaData) resu.getMetaData(); // 获得结果集结构信息,元数据
		int columnCount = md.getColumnCount(); // 获得列数
		while (resu.next()) {
			Map<String, Object> rowData = new HashMap<String, Object>();
			for (int i = 1; i <= columnCount; i++) {
				rowData.put(md.getColumnName(i), resu.getObject(i));
			}
			list.add(rowData);

		}
		return list;
	}

	public void DB2Excels(List<Map<String, Object>> list) throws SQLException, IOException {
		String filePath = "e:\\sample.xls";// 文件路径
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建工作表(Sheet)
		HSSFSheet sheet = workbook.createSheet();
		sheet = workbook.createSheet("Test");
		// 创建行,从0开始
		int rownum = 1;
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);// 创建行的单元格,也是从0开始
		cell.setCellValue("ID");// 设置单元格内容
		row.createCell(1).setCellValue("密码");// 设置单元格内容,重载
		row.createCell(2).setCellValue("年龄");
		row.createCell(3).setCellValue("名字");
		DB2Excel db = new DB2Excel();
		// List<Map<String, Object>> list = db.findred();
		for (Map<String, Object> maps : list) {
			row = sheet.createRow(rownum++);
			System.out.println(maps);
			row.createCell(0).setCellValue(maps.get("Id").toString());
			row.createCell(1).setCellValue(maps.get("Pwd").toString());
			row.createCell(2).setCellValue(maps.get("Age").toString());
			row.createCell(3).setCellValue(maps.get("Name").toString());
		}
		FileOutputStream out = new FileOutputStream(filePath);
		workbook.write(out);// 保存Excel文件
		out.close();// 关闭文件流
	}
	public static void main(String[] args) throws SQLException, IOException {
		DB2Excel db = new DB2Excel();
		List<Map<String, Object>> list = db.Query4List();
		db.DB2Excels(list);
		
	}
}
