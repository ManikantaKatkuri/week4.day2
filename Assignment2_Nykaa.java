package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// Go to https://www.nykaa.com/
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.nykaa.com/");
		Thread.sleep(3000);
		// Mouseover on Brands and Search L'Oreal Paris
		WebElement eleBrands = driver.findElement(By.xpath("//ul[@class='HeaderNav css-f7ogli'][2]//a"));
		Actions builder=new Actions(driver);
		builder.moveToElement(eleBrands).perform();
		WebElement eleBrandSearch = driver.findElement(By.id("brandSearchBox"));
		eleBrandSearch.sendKeys("L'Oreal Paris");
		// Click L'Oreal Paris
		WebElement eleLoreal = driver.findElement(By.linkText("L'Oreal Paris"));
		eleLoreal.click();
		//4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("L'Oreal Paris"))
			System.out.println("Title is Correct");
		else
			System.out.println("Title is Wrong");
		// Click sort By and select customer top rated
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button/span[contains(text(),'popularity')]")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'customer top rated')]/following::div[@class='control-indicator radio '])[1]")).click();
		// Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.id("first-filter")).click(); //click Category
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul[@class='scroll css-1e7z8zv']//span[text()='Hair']")).click();//click Hair
		driver.findElement(By.xpath("//ul[@class='scroll css-1e7z8zv']//span")).click(); //click Hair Care
		driver.findElement(By.xpath("//label[@for='checkbox_Shampoo_316']/div[@class='control-indicator checkbox ']")).click(); //click shampoo
		// Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//label[@for='checkbox_Color Protection_10764']/div[@class='control-indicator checkbox ']")).click();
		// check whether the Filter is applied with Shampoo
		String filterApplied = driver.findElement(By.xpath("//div[@class='css-1emjbq5']/span[@class='filter-value']")).getText();
		System.out.println("Filter applied on: " +filterApplied);
		Thread.sleep(3000);
		// Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[contains(text(),\"L'Oreal Paris Colour Protect Shampoo\")]")).click();
		// GO to the new window and select size as 175ml
		Set<String> childWin1 = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(childWin1);
		driver.switchTo().window(list.get(1));
		//select drop down value size
		WebElement eleSizeDD = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select size = new Select(eleSizeDD);
		size.selectByVisibleText("175ml");
		// Print the MRP of the product
		String price = driver.findElement(By.xpath("//div[@class='css-1d0jf8e']/span[2]")).getText();
		System.out.println("Product Price: " +price);
		// Click on ADD to BAG
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		// Go to Shopping Bag 
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		Thread.sleep(2000);
		// Print the Grand Total amount
		WebElement eleFrame1 = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
		driver.switchTo().frame(eleFrame1);
		String grandTotal = driver.findElement(By.xpath("//div[@class='table-row ']/div[2]")).getText();
		grandTotal.replace("?", "");
		System.out.println("Grand Total: " +grandTotal);
		// Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		// Click on Continue as Guest
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		// Check if this grand total is the same in step 14
		String shoppingbagGrandTotal = driver.findElement(By.xpath("//div[@class='payment-details-tbl grand-total-cell prl20']/div[2]")).getText();
		shoppingbagGrandTotal.replace("?", "");
		System.out.println("Shopping Bag Grand Total: " +shoppingbagGrandTotal);

		if (grandTotal.equals(shoppingbagGrandTotal))
			System.out.println("Shopping Bag total matches with product price");
		else
			System.out.println("Shopping Bag total NOT matches with product price");

		// Close all windows
		driver.quit();

	}

}
