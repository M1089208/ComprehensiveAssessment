package com.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
		
	
	public int getRowCount(String xlfile,String xlsheet) throws IOException
	{
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(xlsheet);
		int rowcount=sheet.getLastRowNum()+1;
		wb.close();
		fis.close();
		
		return rowcount;
		
	}
	
	public int getCellCount(String xlfile,String xlsheet) throws IOException
	{
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(xlsheet);
		row=sheet.getRow(0);
		int cellcount=row.getLastCellNum();
		System.out.println(cellcount);
		
		return cellcount;
		
	}
	
	public String getCellData(String xlfile,String xlsheet,int row,int colunm) throws IOException
	{
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(xlsheet);
		Cell cell=sheet.getRow(row).getCell(colunm);
		//Cell cell=CellUtil.getCell(sheet.getRow(row), colunm);
		String data="";
		try {
		switch(cell.getCellType())
		{
		case STRING:data=cell.getStringCellValue();
					return data;
		case NUMERIC:data=NumberToTextConverter.toText(cell.getNumericCellValue());
					return data;
		}
		}catch(Exception e)
		{
			data="";
		}
		wb.close();
		fis.close();
		return data;
		
	}

}
