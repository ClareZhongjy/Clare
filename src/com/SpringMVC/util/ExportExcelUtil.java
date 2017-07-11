package com.SpringMVC.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcelUtil {
	
	
	
	public static XSSFWorkbook generateSExcel(List<Map<String, String>> list, String title) {
		
		 XSSFWorkbook wb = new XSSFWorkbook();
		
		 XSSFSheet sheet = wb.createSheet("sheet1");
		
		return null;  
		
	}
	
	/**
	 * 设置表头样式
	 * @return
	 */
	public XSSFCellStyle getHeadStyle(XSSFWorkbook wb){
		//创建单元格样式
		XSSFCellStyle cellStyle = wb.createCellStyle();
		// 设置单元格颜色
		cellStyle.setFillBackgroundColor(HSSFColor.PALE_BLUE.index);;
		
		cellStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);;
		
		//设置单元格居中对齐
		cellStyle.setAlignment(XSSFCellStyle.VERTICAL_CENTER);
		
		//设置单元格垂直居中对齐
		cellStyle.setVerticalAlignment(XSSFCellStyle.ALIGN_CENTER);
		
		//创建单元格内容显示不下时自动换行
		cellStyle.setWrapText(true);
		
		//设置单元格字体样式
		XSSFFont font = wb.createFont();
		
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("微软雅黑");
		font.setFontHeight((short)200);
		cellStyle.setFont(font);
		
		cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
		
		return cellStyle;
		
	}
	
	/**
	 * 设置表体的单元格样式
	 * @return
	 */
	public XSSFCellStyle getBodyStyle(XSSFWorkbook wb){
		// 创建单元格样式  
		XSSFCellStyle cellStyle = wb.createCellStyle();  
		// 设置单元格居中对齐  
		cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);  
		// 设置单元格垂直居中对齐  
		cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);  
		// 创建单元格内容显示不下时自动换行  
		cellStyle.setWrapText(true);  
		// 设置单元格字体样式  
		XSSFFont font = wb.createFont();  
		// 设置字体加粗  
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);  
		font.setFontName("宋体");  
		font.setFontHeight((short) 200);  
		cellStyle.setFont(font);  
		// 设置单元格边框为细线条  
		cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);  
		cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);  
		cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);  
		cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);  
		
		return cellStyle;  
	}
	
	
	public static HSSFWorkbook generateExcel(List<Map<String, String>> list, String title,String[] cols) {  
        HSSFWorkbook book = new HSSFWorkbook();  
        try{  
          
          
                        HSSFSheet sheet = book.createSheet("Sheet1");  
            sheet.autoSizeColumn(1, true);//自适应列宽度  
            //样式设置  
            HSSFCellStyle style = book.createCellStyle();  
            //style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);  
             // style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
              style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
              style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
              style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
              style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
              style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
              // 生成一个字体  
              HSSFFont font = book.createFont();  
              font.setColor(HSSFColor.VIOLET.index);  
              font.setFontHeightInPoints((short) 12);  
              font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
              // 把字体应用到当前的样式  
              style.setFont(font);  
              
                
              HSSFCellStyle style2 = book.createCellStyle();  
                  //style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
                  //设置上下左右边框  
                  style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
                  style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
                  style2.setBorderRight(HSSFCellStyle.BORDER_THIN);  
                  style2.setBorderTop(HSSFCellStyle.BORDER_THIN);  
                  style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
                    
              //填充表头标题  
              int colSize = list.get(0).entrySet().size();  
              System.out.println("size:" + colSize);  
              //合并单元格供标题使用(表名)  
             // sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, colSize-1));  
             // HSSFRow firstRow = sheet.createRow(0);//第几行（从0开始）  
             // HSSFCell firstCell = firstRow.createCell(0);  
             // firstCell.setCellValue(title);  
             // firstCell.setCellStyle(style);  
                
              //填充表头header  
              HSSFRow row = sheet.createRow(1);  
 
             
              for(int i=0; i< cols.length; i++) {  
                 
                  HSSFCell cell = row.createCell(i);  
                  cell.setCellValue(cols[i]);  
                  cell.setCellStyle(style2);  
              }  
                
              //填充表格内容  
              System.out.println("list:" + list.size());  
              for(int i=0; i<list.size(); i++) {  
                  HSSFRow row2 = sheet.createRow(i+2);//index：第几行  
                  Map<String, String> map = list.get(i);  
                  Set<Entry<String, String>> set2 = map.entrySet();  
                  List<Entry<String, String>> ll = new ArrayList(set2);  
                  for(int j=0; j<ll.size(); j++) {  
                      String val = ll.get(j).getValue();  
                      HSSFCell cell = row2.createCell(j);//第几列：从0开始  
                      cell.setCellValue(val);  
                      cell.setCellStyle(style2);  
                  }  
              }  
                
//           book.write(fos);   
//           fos.close();  
        } catch(Exception ex) {  
            ex.printStackTrace();  
        }  
        return book;  
    }  
}
