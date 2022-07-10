package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel{
public static String getData(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {
	FileInputStream file = new FileInputStream("C:\\Users\\EC0000AX\\eclipse-workspace\\KiteZerodha\\src\\test\\resources\\Zerodha.xlsx");
	String value = WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
	System.out.println(value);
	return value;
}
}
