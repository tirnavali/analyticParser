import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;

public class Main{
public static void main(String[]args){
    System.out.println("Hello World");
    try{
        FileInputStream fileInputStream = new FileInputStream(new File("src/main/resources/data.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = wb.getSheetAt(1);
        XSSFRow row = sheet.getRow(0);
        XSSFCell cell = row.getCell(0);
        System.out.printf(cell.toString());

    }catch (Exception e){
        System.out.println(e);
    }
   }
}