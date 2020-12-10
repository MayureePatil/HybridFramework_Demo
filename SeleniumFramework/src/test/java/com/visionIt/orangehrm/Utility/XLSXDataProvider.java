package com.visionIt.orangehrm.Utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXDataProvider {

	
	XSSFWorkbook wb;
	
	public XLSXDataProvider()
	{
		try {
			File file=new File("./TestData/testData.xlsx");
			FileInputStream fins=new FileInputStream(file);
			wb=new XSSFWorkbook(fins);
			
		}
		catch(Exception e)
		{
			System.out.println("Excel file not found"+e.getMessage());
		}
		
	}
	public String getStringcellData(String sheetname,int row,int col) {
		
		return wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
	}
	public int getNumericCellData(String sheetname,int row,int col)
	{
		return (int) wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
	}

	public Object[][] excelTestData(String sheetname)
	{
		 XSSFSheet sheet=wb.getSheet(sheetname);
		int rowCount= sheet.getLastRowNum();
		 int colCount=sheet.getRow(0).getLastCellNum();
	Object[][]	data= new Object[rowCount][colCount];
	
	for(int i=0;i<rowCount;i++)
	{
		for(int j=0;j<colCount;j++)
		{
			data[i][j]=sheet.getRow(i+1).getCell(j).toString();
		}
		
	}
		 return data;	 
	}

}
