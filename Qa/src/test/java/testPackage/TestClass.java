package testPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {
	
	@Test
	void simple()
	{
		WebDriverManager.edgedriver().setup();
		WebDriver dr = new EdgeDriver();
		dr.get("https://www.youtube.com/");
		dr.manage().window().maximize();
		dr.findElement(By.xpath("//*[@id=\"guide-icon\"]")).click();
		dr.findElement(By.xpath("//yt-formatted-string[normalize-space()='Shorts']")).click();
		dr.close();
	
	}
	@Test
	void excel() throws IOException
	{
		File fl = new File("C:\\Users\\Chandru\\Desktop\\demo.xls");
		FileInputStream fis = new FileInputStream(fl);
		Workbook wb = new HSSFWorkbook(fis);
		org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(7);
		Cell cell = row.getCell(7);
		System.out.println(cell);
		String str = cell.toString();
		WebDriverManager.chromedriver().setup();
		WebDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get(str);
		dr.close();
	}
	
	

}
