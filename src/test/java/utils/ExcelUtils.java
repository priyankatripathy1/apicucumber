package utils;

import java.io.IOException;

import groovy.util.logging.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Slf4j
public class ExcelUtils {
    //Variables
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtils(String excelpath, String sheetname) {
        try {

            workbook = new XSSFWorkbook(excelpath);
            sheet = workbook.getSheet(sheetname);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getRowCount() {
        int rowCount = 0;
        rowCount = sheet.getPhysicalNumberOfRows();
        return rowCount;
    }

    public static int getColumnCount() {
        int colCount = 0;
        colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        return colCount;
    }

    public String getCellDataString(int rownum, int colnum) {
        String cellData1 = "";
        cellData1 = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
        System.out.println("CellValue1 : " + cellData1);
        return cellData1;
    }

    public double getCellDataNumeric(int rownum, int colnum) {
        double cellData2 = 0;
        cellData2 = sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
        System.out.println("CellValue1 : " + cellData2);
        return cellData2;
    }

}

