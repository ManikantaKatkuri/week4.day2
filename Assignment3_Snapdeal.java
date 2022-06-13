package week4.day2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3_Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// Launch https://www.snapdeal.com/
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.snapdeal.com/");
		Thread.sleep(5000);
		// Go to Mens Fashion
		WebElement ele = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(ele).perform();
		Thread.sleep(2000);
		// Go to Sports Shoes
		driver.findElement(By.xpath("//*[text()='Sports Shoes']")).click();
		// Get the count of the sports shoes
		String noofShoes = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println("Total Count of Sports Shoes: "+noofShoes);
		// Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		// Sort by Low to High
		Thread.sleep(3000);
		WebElement ele2=driver.findElement(By.xpath("//div[contains(text(),'Popularity')]"));		
		// Check if the items displayed are sorted correctly
		builder.moveToElement(ele2).click().perform();
		WebElement ele3=driver.findElement(By.xpath("//li[@class='search-li']"));
		ele3.click();
		// Select the price range (900-1200)
		Thread.sleep(3000);
		WebElement fromEle = driver.findElement(By.name("fromVal"));
		fromEle.clear();
		fromEle.sendKeys("900");
		WebElement toEle = driver.findElement(By.name("toVal"));
		toEle.clear();
		toEle.sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		Thread.sleep(3000);
		//Filter with color Blue 
		driver.findElement(By.xpath("//button[text()='View More ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Blue']/following-sibling::label")).click();
		Thread.sleep(2000);
		// Mouse Hover on first resulting Training shoes
		WebElement firstShoe = driver.findElement(By.xpath("//picture[@class='picture-elem']/img"));
		builder.moveToElement(firstShoe).perform();
		// click QuickView button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		Thread.sleep(3000);
		// Print the cost and the discount percentage
		WebElement cost = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		System.out.println("Cost: "+cost.getText());
		Thread.sleep(2000);
		WebElement discount = driver.findElement(By.xpath("//span[@class='percent-desc ']"));
		System.out.println("Discount: "+discount.getText());
		Thread.sleep(2000);
		// Take the snapshot of the shoes.
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File ("./Shoes.jpg");
		FileUtils.copyFile(source, destination);
		// Close the current window
		driver.close();
		// Close the main window
		driver.close();

	}

}
