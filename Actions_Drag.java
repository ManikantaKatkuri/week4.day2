package week4.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions_Drag {

	public static void main(String[] args) throws InterruptedException {
		// load the browser
		WebDriverManager.chromedriver().setup();
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// navigate to URL 
		driver.get("http://www.leafground.com/pages/drag.html");
		// locate element
		WebElement drag = driver.findElement(By.id("draggable"));
		// actions class
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(drag, 120, 130)
		.perform();
		Thread.sleep(3000);
		driver.close();	
	}

}
