//package utils;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;
//
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReader {
//	
//	public static String filePath = ConfigReader.getTestDataPath();
//
//	public static List<Map<String, String>> getAllSheetData(String sheetName) throws IOException {
//		FileInputStream fis = new FileInputStream(filePath);
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		XSSFSheet sheet = wb.getSheet(sheetName);
//		DataFormatter formatter = new DataFormatter();
//		List<Map<String, String>> listData = new ArrayList<>();
//
//		Row header = sheet.getRow(0);
//		
//		for (int r = 1; r <= sheet.getLastRowNum(); r++) {
//			Row row = sheet.getRow(r);
//          if (row == null) continue;
//			Map<String, String> rowData = new HashMap<>();
//			for (int c = 0; c <= row.getLastCellNum(); c++) {
//				String key = formatter.formatCellValue(header.getCell(c)).trim();
//				String value = formatter.formatCellValue(row.getCell(c)).trim();
//				rowData.put(key, value);
//			}
//			listData.add(rowData);
//		}
//		wb.close();
//		return listData;
//	}	
//	
//	public static Map<String, String> readExcelData(String sheetName, String keyValue) throws IOException {
//		List<Map<String, String>> data = ExcelReader.getAllSheetData(sheetName);
//		for (Map<String, String> row : data) {
//			if (row.get("Key").equalsIgnoreCase(keyValue)) {
//				return row;
//			}
//		}
//		return null;
//	}
//	
//	public static Map<String, String> readExcelDatakey(String sheetName, String keyValue) throws IOException {
//
//		        for (Map<String, String> row : getAllSheetData(sheetName)) {
//		            String key = row.get("Key");
//		            if (key != null && key.equalsIgnoreCase(keyValue)) {
//		                return row;
//		            }
//		        }
//		        return null;
//		    }
//     }
//
//
//
////package com.herBalance.utils;
////
////import java.io.FileInputStream;
////import java.io.IOException;
////import java.util.ArrayList;
////import java.util.HashMap;
////import java.util.List;
////import java.util.Map;
////
////import org.apache.poi.ss.usermodel.DataFormatter;
////import org.apache.poi.ss.usermodel.Row;
////import org.apache.poi.xssf.usermodel.XSSFSheet;
////import org.apache.poi.xssf.usermodel.XSSFWorkbook;
////
////public class ExcelReader {
////
////    public static String filePath = ConfigReader.getTestDataPath();
////
////    public static List<Map<String, String>> getAllSheetData(String sheetName) throws IOException {
////
////        List<Map<String, String>> listData = new ArrayList<>();
////        DataFormatter formatter = new DataFormatter();
////
////        try (FileInputStream fis = new FileInputStream(filePath);
////             XSSFWorkbook wb = new XSSFWorkbook(fis)) {
////
////            XSSFSheet sheet = wb.getSheet(sheetName);
////            Row header = sheet.getRow(0);
////
////            for (int r = 1; r <= sheet.getLastRowNum(); r++) {
////
////                Row row = sheet.getRow(r);
////                if (row == null) continue;
////
////                Map<String, String> rowData = new HashMap<>();
////
////                for (int c = 0; c < header.getLastCellNum(); c++) {
////                    String key = formatter.formatCellValue(header.getCell(c)).trim();
////                    String value = formatter.formatCellValue(row.getCell(c)).trim();
////                    rowData.put(key, value); // value can be ""
////                }
////
////                listData.add(rowData);
////            }
////        }
////        return listData;
////    }
////
////    public static Map<String, String> readExcelData(String sheetName, String keyValue) throws IOException {
////
////        for (Map<String, String> row : getAllSheetData(sheetName)) {
////            String key = row.get("Key");
////            if (key != null && key.equalsIgnoreCase(keyValue)) {
////                return row;
////            }
////        }
////        return null;
////    }
////}


package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static String filePath = ConfigReader.getTestDataPath();

    public static List<Map<String, String>> getAllSheetData(String sheetName) throws IOException {

        List<Map<String, String>> listData = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();

        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            Row header = sheet.getRow(0);

            for (int r = 1; r <= sheet.getLastRowNum(); r++) {

                Row row = sheet.getRow(r);
                if (row == null) continue;

                Map<String, String> rowData = new HashMap<>();

                for (int c = 0; c < header.getLastCellNum(); c++) {

                    String key = formatter.formatCellValue(header.getCell(c)).trim();
                    String value = formatter.formatCellValue(row.getCell(c)).trim();

                    rowData.put(key, value);
                }

                listData.add(rowData);
            }
        }

        return listData;
    }
//
//    public static Map<String, String> getTestData(String sheetName, String testcaseId) throws IOException {
//
//        for (Map<String, String> row : getAllSheetData(sheetName)) {
//
//            String id = row.get("testcase_id");   // <-- match Excel header
//
//            if (id != null && id.equalsIgnoreCase(testcaseId)) {
//                return row;
//            }
//        }
//
//        return null;
//    }
    
    public static Map<String, String> getTestData(String sheetName, String testcaseId) throws IOException {

        for (Map<String, String> row : getAllSheetData(sheetName)) {

            String id = row.get("TestCaseId");   // ✅ match EXACT header

            if (id != null && id.equalsIgnoreCase(testcaseId)) {
                return row;
            }
        }

        return null;
    }

}
