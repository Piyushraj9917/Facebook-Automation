package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadCSV {

    @DataProvider(name = "xlsxData")
    public String[][] ReadData(int sheetIndex) throws IOException {
        // Path to the Excel file
        File file = new File("/Users/ahlawat/IdeaProjects/FirstAutomation/src/test/resources/TestData1/Piyush3.xlsx");

        // FileInputStream for reading the file
        FileInputStream fis = new FileInputStream(file);

        // Creating a workbook instance
        Workbook workbook = WorkbookFactory.create(fis);

        // Fetching the sheet by index
        Sheet sheet = workbook.getSheetAt(sheetIndex);

        // Total rows and columns
        int totalRows = sheet.getLastRowNum()+1; // Including header
        System.out.println("Total Rows: " + totalRows);
        Row firstRow = sheet.getRow(0);
        int totalCols = firstRow.getLastCellNum();
        System.out.println("Total Columns: " + totalCols);

        // DataFormatter to handle cell data
        DataFormatter df = new DataFormatter();

        // Creating a 2D array to store the data
        String[][] testData = new String[totalRows][totalCols];

        // Looping through rows and columns
        for (int i = 0; i < totalRows; i++) {
            Row currentRow = sheet.getRow(i);

            for (int j = 0; j < totalCols; j++) {
                if (currentRow != null && currentRow.getCell(j) != null) {
                    testData[i][j] = df.formatCellValue(currentRow.getCell(j));
                    System.out.println( testData[i][j]);
                } else {
                    testData[i][j] = ""; // Handle null cells
                }
            }
        }
        // Closing resources
        workbook.close();
        fis.close();
        return testData;
    }
}
