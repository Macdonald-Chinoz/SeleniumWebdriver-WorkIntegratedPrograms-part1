package Checkboxes_9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckboxes {

	public static void main(String[] args) {
// Launch Chrome
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//#1
		//select specific checkbox
		//driver.findElement(By.xpath("//label[normalize-space()='Tuesday']")).click();//selects Tuesday checkbox
		//select all checkboxes
		List<WebElement>checkboxes=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("Total number of checkboxes:"+checkboxes.size());
		
		//#2
		//ticking the checkboxes using for loop
		/*for(int i=0;i<=checkboxes.size();i++)
		{
			checkboxes.get(i).click();
		}
		
		*/
		
		//ticking checkboxes using for each loop
		/*for (WebElement chbox:checkboxes)
		{
			chbox.click();
		}
		*/
		
		//#3-select multiple checkboxes by choice
		//select monday and sunday
		/*
		for (WebElement chbox:checkboxes)
		{
			String checkboxname=chbox.getAttribute("id");
			if (checkboxname.equals("monday") || checkboxname.equals("sunday"))
			{
				chbox.click();
			}
			*/
		//select last 2 checkboxes
		//formula=total number of checkboxes-no of check-boxes select=starting index
		int totalNoCheckboxes=checkboxes.size();
		/*
		
		for(int i=totalNoCheckboxes-3;i<totalNoCheckboxes;i++)
		{
			checkboxes.get(i).click();
		}
		*/
		
		//select first 3 checkboxes
		for(int i=0;i<totalNoCheckboxes;i++)
		{
			if(i<3) 
			{
				checkboxes.get(i).click();
			}
		}

}
}
