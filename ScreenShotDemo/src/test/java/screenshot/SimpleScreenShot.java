package screenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleScreenShot {

	public static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.marvel.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		System.out.println("Entering Marvel Universe");

		marvelUniverse("MARVEL");
		tearDown();
	}

	public static void marvelUniverse(String screenShotName) {

		driver.findElement(By.xpath("//a[@id='mvl-flyout-button-1']")).click();
		System.out.println("Various marvel characters");
		takeShot("marvel characters");

		driver.findElement(By.xpath("//body/div[@id='__next']/div[@id='terrigen-page']"
				+ "/div[@id='page-wrapper']/div[1]/section[6]/div[1]/div[2]/div[5]/a[1]/div[1]/figure[1]/img[1]"))
				.click();
		System.out.println("Your friendly neighborhood Spiderman.");
		takeShot("spiderman");

		driver.findElement(By.xpath("//span[contains(text(),'In Comics Profile')]")).click();
		System.out.println("Spiderman's profile.");
		takeShot("profile");

		driver.findElement(By.xpath("//a[@id='mvl-flyout-button-3']")).click();
		System.out.println("Upcoming movies.");
		takeShot("movies");

		driver.findElement(By.xpath("//body/div[@id='__next']/div[@id='terrigen-page']/div[@id='page-wrapper']"
				+ "/div[1]/section[6]/div[1]/div[2]/div[9]/a[1]/div[1]/div[1]/figure[1]/img[1]")).click();
		System.out.println("Eternals coming November 05, 2021");
		takeShot("eternals");

		driver.findElement(By.xpath("//body/div[@id='__next']/div[@id='terrigen-page']/div[@id='page-wrapper']"
				+ "/div[1]/section[5]/div[1]/div[2]/div[4]/div[1]/div[1]/a[1]")).click();
		System.out.println("Eternals teaser trailer.");
		takeShot("teaser");
	}

	public static void takeShot(String screenShotName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot.Simple/" + System.currentTimeMillis()
				+ "MARVEL.png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
	}

	public static void tearDown() {
		driver.close();
		System.out.println("Exiting Marvel Universe");
	}
}

