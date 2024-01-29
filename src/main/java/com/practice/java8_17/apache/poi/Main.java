package com.practice.java8_17.apache.poi;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.readExcel("D:\\Dataset\\dh\\Data for LR.xlsx"));
    }

    public Map<Double, Double> readExcel(String path) {
        Map<Double, Double> data = new HashMap<Double, Double>();
        Map<Integer, String> temp = new HashMap<Integer, String>();
        try {

            FileInputStream excelFile = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet dataTypeSheet = workbook.getSheetAt(0);

            int minRow = dataTypeSheet.getRow(0).getFirstCellNum();
            int maxRow = dataTypeSheet.getColumnWidth(0);
            System.out.println("minCol= " + minRow + ",maxCol= " + maxRow);
            int count = 0;
            for (int i = minRow; i < maxRow; i++) {
                Row currentRow = dataTypeSheet.getRow(i);
                if (currentRow != null) {
                    count = 0;
                    Iterator<Cell> cellIterator = currentRow.iterator();
                    double key = 0;
                    while (cellIterator.hasNext()) {

                        Cell currentCell = cellIterator.next();
                        if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                            String _key = temp.get(count);

                            if (count == 0) {
                                data.put(currentCell.getNumericCellValue(), 0.0);
                                key = currentCell.getNumericCellValue();
                            } else {
                                data.replace(key, 0.0, currentCell.getNumericCellValue());
                            }
                        }
                        count++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void writeExcel(String File_name) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
        Object[][] datatypes = {
                {"Datatype", "Type", "Size(in bytes)"},
                {"int", "Primitive", 2},
                {"float", "Primitive", 4},
                {"double", "Primitive", 8},
                {"char", "Primitive", 1},
                {"String", "Non-Primitive", "No fixed size"}
        };

        int rowNum = 0;
        System.out.println("Creating excel");

        for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(File_name);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");

    }
}

