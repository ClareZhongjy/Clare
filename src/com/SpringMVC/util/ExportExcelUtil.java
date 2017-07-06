package com.SpringMVC.util;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcelUtil {
	
	private XSSFWorkbook wb = null;
	
	private XSSFSheet sheet = null;
	
	 
	public ExportExcelUtil(XSSFWorkbook wb, XSSFSheet sheet)  {  
	    this.wb = wb;  
        this.sheet = sheet;  
	}  
	 
	/**
	 * 设置表头样式
	 * @return
	 */
	public XSSFCellStyle getHeadStyle(){
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
	public XSSFCellStyle getBodyStyle(){
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
}
