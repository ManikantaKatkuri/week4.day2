package week4.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions_Sortable {

	public static void main(String[] args) throws InterruptedException {
		// load the browser
		WebDriverManager.chromedriver().setup();
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// navigate to URL 
		driver.get("http://www.leafground.com/pages/sortable.html");
		// locate element
		WebElement item1 = driver.findElement(By.xpath("//ul[@id='sortable']/li[text()='Item 1']"));
		WebElement item3 = driver.findElement(By.xpath("//ul[@id='sortable']/li[text()='Item 3']"));	
		WebElement item5 = driver.findElement(By.xpath("//ul[@id='sortable']/li[text()='Item 5']"));
		WebElement item6 = driver.findElement(By.xpath("//ul[@id='sortable']/li[text()='Item 6']"));	
		// actions class
		Actions builder = new Actions(driver);
		builder.dragAndDrop(item6, item3)
		.clickAndHold(item5).moveToElement(item1)
		.perform();
		Thread.sleep(5000);
		driver.close();	

	}

}
