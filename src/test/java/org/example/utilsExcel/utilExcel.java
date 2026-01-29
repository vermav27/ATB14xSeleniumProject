package org.example.utilsExcel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class utilExcel {

    public static String sheetPath = System.getProperty("user.dir") + "/src/test/resources/TEST_DATA_LOGIN_CREDS.xlsx";
    static Workbook myBook;
    static Sheet mySheet;

    public static Object[][] getDataFromExcel(String sheet) {

        try {
            FileInputStream fileInputStream = new FileInputStream(sheetPath); // Open stream
            myBook = WorkbookFactory.create(fileInputStream); //Load File
            mySheet = myBook.getSheet(sheet);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Object[][] data = new Object[mySheet.getLastRowNum()][mySheet.getRow(0).getLastCellNum()];

        for(int i = 0;i< mySheet.getLastRowNum();i++){

            for (int j = 0; j< mySheet.getRow(0).getLastCellNum();j++){
                data[i][j] = mySheet.getRow(i+1).getCell(j).toString();

            }

        }

        return data;
    }

}
