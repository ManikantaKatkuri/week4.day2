package week4.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions_Selectable {

	public static void main(String[] args) throws InterruptedException {
		// load the browser
		WebDriverManager.chromedriver().setup();
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// navigate to URL 
		driver.get("http://www.leafground.com/pages/selectable.html");
		// locate element
		WebElement Item2 = driver.findElement(By.xpath("//ol[@id='selectable']/li[text()='Item 2']"));
		WebElement Item4 = driver.findElement(By.xpath("//ol[@id='selectable']/li[text()='Item 4']"));
		WebElement Item6 = driver.findElement(By.xpath("//ol[@id='selectable']/li[text()='Item 6']"));
		// actions class
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL)
		.click(Item2)
		.click(Item4)
		.click(Item6)
		.keyUp(Keys.CONTROL)
		.perform();
		Thread.sleep(3000);
		driver.close();	
	}

}
