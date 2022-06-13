package week4.day2;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {
		// load the browser
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// navigate to URL
		driver.get("http://www.leafground.com/pages/table.html");
		Thread.sleep(3000);
		// Get the count of number of columns
		List<WebElement> colCount = driver.findElements(By.xpath("//table//th"));
		System.out.println("Total No of Columns: "+colCount.size());
		// Get the count of number of rows
		List<WebElement> rowCount = driver.findElements(By.xpath("//table//tr"));
		System.out.println("Total No of Rows: "+rowCount.size());
		// Get the progress value of 'Learn to interact with Elements'
		List<WebElement> elements = driver.findElements(By.xpath("//table//tr[@class='even']/td[2]"));
		for (int i = 0; i < elements.size(); i++) {  
			String str = elements.get(i).getText();
			System.out.println("Learn to interact with Elements - Progress value: "+str);
		}
		// Check the vital task for the least completed progress.
		WebElement checkBox = driver.findElement(By.xpath("//table//tr[6]/td[3]"));
		checkBox.click();
		Thread.sleep(3000);
		driver.close();

	}
}
