package com.SpringMVC.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SpringMVC.entity.Customer;
import com.SpringMVC.service.ICustomerService;
import com.SpringMVC.util.ExportExcelUtil;

@Controller
@RequestMapping("/export")
public class ExportController {
	
	@Autowired
	ICustomerService cs;
	
	
	@RequestMapping("/preExport.do")
	public String preExport(){
		return "export_excel/export_excel";
	}
	
	@RequestMapping("/exportExcel.do")
	@ResponseBody
	public String exportExcel(HttpServletRequest request,
            HttpServletResponse response){
		
		response.reset();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssms");
        String dateStr = sdf.format(new Date());

        // 指定下载的文件名
        response.setHeader("Content-Disposition", "attachment;filename=" +dateStr+".xls");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
   
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        List<Customer> rList = cs.getAllCustomer();
       
        String[] cols = {"ID","年龄","E-mail","姓名"};
        for(int i=0;i<rList.size();i++){
        	Customer c = rList.get(i);
        	Map<String,String> tempMap = new HashMap<String,String>();
        	tempMap.put(cols[0], String.valueOf(c.getId()));
        	tempMap.put(cols[1], String.valueOf(c.getAge()));
        	tempMap.put(cols[2], String.valueOf(c.getEmail()));
        	tempMap.put(cols[3], String.valueOf(c.getName()));
        	list.add(tempMap);
        }
        HSSFWorkbook workbook=ExportExcelUtil.generateExcel(list, "test",cols);
        try {
            OutputStream output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            bufferedOutPut.flush();
            workbook.write(bufferedOutPut);
            bufferedOutPut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
		
	}
}
