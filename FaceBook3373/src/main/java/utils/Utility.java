package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;





public class Utility {
	
	
	public static String fetchDataFromExcelSheet (String sheet,int row, int cell) throws IOException { 
	
	String path = "C:\\Users\\HOME\\Desktop\\Test1.xlsx";
	
	FileInputStream file = new FileInputStream(path);
	Workbook book = WorkbookFactory.create(file);
	
	String data = book.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	return data ;
	}
	
	public static String captureScreenshot(WebDriver driver ,String testID  ) throws IOException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		LocalDateTime now = LocalDateTime.now();
		
		File dest = new File("C:\\Users\\HOME\\Desktop\\ScrrenshotSelenium\\" + ( dtf +testID) + "Testid.jpg");
				
		FileHandler.copy(src, dest);
		return testID;
		
		 
		
	}
}
