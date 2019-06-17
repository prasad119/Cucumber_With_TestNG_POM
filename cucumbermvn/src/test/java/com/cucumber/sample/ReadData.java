package com.cucumber.sample;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.cucumber.util.Global;

public class ReadData {
	static Map<String,String> data = null;
	
	public static void main(String h[]){
		data = readTestDataFromExcel("Login test1");
		System.out.println(data);
		
	}
	
	public static Map<String,String> readTestDataFromExcel(String tcName){
		try
		{
			int counter=0;
			Row row2 = null;
			Map<String,String> mapOfTestCasesFromColumnOne = new HashMap<String,String>();
			List<String> list1 = new ArrayList<String>();
			List<String> list2 = new ArrayList<String>();
			Workbook workbook = WorkbookFactory.create(new File(Global.excelTestDataFile));
			Sheet sheet = workbook.getSheet(Global.sheetName1);
			DataFormatter dataFormatter = new DataFormatter();
			for (Row row: sheet) {
				counter++;
				if(dataFormatter.formatCellValue(row.getCell(0)).equalsIgnoreCase(tcName)){
					row2 = sheet.getRow(counter);
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						list1.add(dataFormatter.formatCellValue(cell));
					}
					Iterator<Cell> cellIterator2 = row2.cellIterator();
					while (cellIterator2.hasNext()) {
						Cell cell = cellIterator2.next();
						list2.add(dataFormatter.formatCellValue(cell));
					}
					break;
				}
			}
			list1.remove(0);
			for(int i =0;i<list1.size();i++){
				mapOfTestCasesFromColumnOne.put(list1.get(i), list2.get(i));
			}
			return mapOfTestCasesFromColumnOne;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
}
