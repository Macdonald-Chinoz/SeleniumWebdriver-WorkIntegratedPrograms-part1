package DropDowns_8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {

	public static void main(String[] args) {
	// Launch Chrome
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=account/register");
		
		WebElement drpCountryEle=driver.findElement(By.id("input-country"));
		Select drpCountry=new Select(drpCountryEle);//this selector class instance allows us now to use select metas
		//drpCountry.selectByVisibleText("South Africa");//you select the value which is in the drop-box
		//drpCountry.selectByValue("239");//this meta lets you select the value-box with the option inside it//this returns last option which is zimbabwe
		//drpCountry.selectByIndex(193);//should return south africa//the option it selects when it starts counting from zero amonng the options
		
		//selecting option from drop-down without using methods
		List <WebElement> allOptions=drpCountry.getOptions();
		for (WebElement option:allOptions)//reads each and very option in variable
		{
			 if (option.getText().equals("Zambia"))//looks and finds matching option i want
			 {
				 option.click();//selects/clicks that option
				 break;
			 }
			 
		}
		
	}

}
