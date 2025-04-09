package inputBox_7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * 1-how to enter & clear text from input box
 * 2-how to capture text from input box
 * 3-what is the difference between getText() and getAttribute('value')
 */
public class getTextvsgetAttributeValue {

	public static void main(String[] args) {
		// Launch Chrome
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/");

		WebElement emailinputbox = driver.findElement(By.id("Email"));
		// * 1-how to enter & clear text from input box
		// emailinputbox.clear();
		// emailinputbox.sendKeys("admin123@gmail.com");

		// 2-how to capture text from input box
		System.out.println("Result from getAttribute() method:"+ emailinputbox.getAttribute("value"));
		
		//3-what is the difference between getText() and getAttribute('value')
		System.out.println("Result from getText() method:"+ emailinputbox.getText());
		//the reason this doent't return a value is because there is not a inner text for this input box website
		
		//Login button=getText example (trying to get text within the button)
		WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
		System.out.println("Result from getAttribute() method:"+button.getAttribute("type"));
		System.out.println("Result from getAttribute() method:"+button.getAttribute("class"));
		System.out.println("Result from getText() method:"+button.getText());
		/*
		 * Difference between getText() and getAttribute('value')
		 * the getText() method returns the innerText of an element
		 * the getAttribute() method fetches the text contained by an attribute in an html document
		 */
		
	
		
		
		

	}

}
