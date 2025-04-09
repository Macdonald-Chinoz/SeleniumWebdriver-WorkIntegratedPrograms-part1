package BrowserWindows_10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * 1-Handling Browser windows
 * 2-difference between getWindowHandle() & getWindowHandles() methods
 * 3-switch between multiple browser windows
 * 4-close browser windows
 * 5-close specific browser windows
 */
public class HandlingBrowserWindows {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//to be able to switch to different windows in a browser we have to make use the ID of webpage
		//so now how do we get the id 	
		//1-Handling Browser windows
		//using getWindowHandle()
		//String windowID=driver.getWindowHandle();//it will return the ID of the single browser window
		//System.out.println(windowID);
//it will return a different window ID every-time the application is run-eg-1strun=F52FB72B29C2D547C1AF3B8901483874;2nd run=C7F5EFF6F5078E14FF39CC181ACEE976

		
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		//opens another browser window by clicking on the link+think of this browser now as a child window
		
		//using getWindowHandles();
		Set<String> windowIDs=driver.getWindowHandles();//returns IDs of multiple windows
		//now that we can get this IDs we need to review them and the two ways to do so are:
		
		//First method-Iretator()
		/*Iterator<String> it=windowIDs.iterator();//captures all window IDs
		
		String parentID=it.next();//1st window id is stored here
		String childID=it.next();//2nd window id is stored here
		
		System.out.println("Parent window ID:"+parentID);
		System.out.println("Child window ID:"+childID);*/
		
		//Second method-using list collection/arraylist
		List<String> windowIdsList=new ArrayList(windowIDs); //converts set to list
		/*
		String parentID=windowIdsList.get(0);//parent window id
		String childID=windowIdsList.get(1);//child window id
		
		System.out.println("Parent window ID:"+parentID);
		System.out.println("Child window ID:"+childID);
		
		//how to use window IDs for switching
		driver.switchTo().window(parentID);//orange hm page
		System.out.println("Parent window ID Title"+driver.getTitle());
		
		driver.switchTo().window(childID);//hr management system page
		System.out.println("child window ID Title"+driver.getTitle());
		*/
		
		//to be able to switch windows in one shot-use for each loop
		/*for(String winId:windowIdsList)
		{
			//System.out.println(winId);//prints window ids of both webpages
			String title=driver.switchTo().window(winId).getTitle();
			System.out.println(title);
		}*/
		
		//driver.close();//this meta will only close a single browser window which driver is not pointing to so in this case the parrent window was closed as it is focused on child window
		//driver.quit();//it will close all browser winddows
		
		for(String winId:windowIdsList)
		{
			String title=driver.switchTo().window(winId).getTitle();
			if(title.equals("OrangeHRM"))//the title of parent webpage+if want to close multiple webpages use = ||title.equals(another title)//in if statement then you can close multiple specific browsers
			{
				driver.close();
			}
		}
		

	}

}
