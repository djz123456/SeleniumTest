package TEST;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.*;
import java.util.Scanner;

import org.openqa.selenium.chrome.*;


public class sele {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [][] str = new String[117][3];
		int counter = 0;
		System.out.println("" + str.length);
		try {
			Scanner in = new Scanner(new File("d:/a/input.txt"));
			
			while (in.hasNextLine()){
				String st = in.nextLine();
				
				str[counter] = st.split("\\s+");
				counter++;
			}
		}
		
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		
		
		
		
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		WebDriver driver = new FirefoxDriver();
		for (int i = 0; i < str.length; i++)
		{
			driver.get("http://121.193.130.195:8080/");
			
			WebElement element = driver.findElement(By.id("name"));
			element.sendKeys(str[i][0]);
			element = driver.findElement(By.id("pwd"));
			element.sendKeys(str[i][0].substring(4, 10));
			element.submit();
			element = driver.findElement(By.id("resultString"));
			String html =  element.getAttribute("innerHTML");
			String [] result = html.split(",");
			String addr = result[2].trim();
			
			if (addr.equals(str[i][2]))
			{
				System.out.println( str[i][1] + "is right");
			}
			else 
			{
				System.out.println( str[i][1] + "is wrong");
			}
			
		}
		
		
		
		
	
	}

}
