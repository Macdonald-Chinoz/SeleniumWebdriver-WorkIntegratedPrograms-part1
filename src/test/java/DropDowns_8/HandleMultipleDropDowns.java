package DropDowns_8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropDowns {

	static WebDriver driver;//making this a global variable
	public static void main(String[] args) {
	// Launch Chrome
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales");
	
	/*	Option1-you slect the element and pick the options
	Select noOfEmployeesDrp=new Select(driver.findElement(By.name("NoOfEmployees")));
	noOfEmployeesDrp.selectByVisibleText("200 - 1,000");
	
	Select countryDrp=new Select(driver.findElement(By.name("Country")));//any other drp option
	countryDrp.selectByVisibleText("Guatemala");
	*/
		//option2-use use a logic=of taking web elements of the drop-downs
		WebElement noOfEmployeesEle=driver.findElement(By.name("NoOfEmployees"));
		selectOptionFromDropDown(noOfEmployeesEle,"200 - 1,000");//calls the method to execute the loop
		
		WebElement countryEle=driver.findElement(By.name("Country"));
		selectOptionFromDropDown(countryEle,"Guatemala");
		
	
		
	}
	public static void selectOptionFromDropDown(WebElement ele,String value)
	{
		Select drp=new Select(ele);
		
		//selecting option from drop-down without using methods
		List <WebElement> allOptions=drp.getOptions();
		for (WebElement option:allOptions)//reads each and very option in variable
		{
			if (option.getText().equals(value))//looks and finds matching option i want
				{
					option.click();//selects/clicks that option
					break;
				}
		}

	}
}
