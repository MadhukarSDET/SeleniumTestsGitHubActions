package utilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {

	public static void main(String[] args) throws IOException {
		readExcelData();
	}

	public static void readExcelData() throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook(
				"C:\\Users\\madhu\\Pictures\\Testng-selenium-github\\src\\test\\java\\resources\\data.xlsx");
		XSSFSheet sheet = workbook.getSheet("login");
		int rows = sheet.getPhysicalNumberOfRows();

		XSSFRow headerRow = sheet.getRow(0);

		int cols = headerRow.getPhysicalNumberOfCells(); // number cells in header row = number cols

		System.out.println("rows:" + rows);
		System.out.println("columns:" + cols);

		for (int i = 0; i < rows; i++) {

			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < row.getLastCellNum(); j++) {

				XSSFCell cell = row.getCell(j);

				String value = cell.getStringCellValue();

				System.out.print(value + "  ");

			}

			System.out.println();
		}
	}

}
