package screenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class FullPageScreenShot {

	public static WebDriver driver;

	public static void main(String[] args) {

		// Image #1
		openApp();
		driver.findElement(
				By.xpath("//*[@id=\"block-system-main\"]/div/div/div[3]/div[3]/div/div/div[2]/div[1]/div[3]/a"))
				.click();
		captureImage();
		System.out.println("SUPERMAN");
		closeApp();

		// Image #2
		openApp();
		driver.findElement(
				By.xpath("//*[@id=\"block-system-main\"]/div/div/div[3]/div[3]/div/div/div[2]/div[2]/div[3]/a"))
				.click();
		captureImage();
		System.out.println("BATMAN");
		closeApp();

		// Image #3
		openApp();
		driver.findElement(
				By.xpath("//*[@id=\"block-system-main\"]/div/div/div[3]/div[3]/div/div/div[2]/div[3]/div[3]/a"))
				.click();
		captureImage();
		System.out.println("WONDERWOMAN");
		closeApp();

		// Image #4
		openApp();
		driver.findElement(
				By.xpath("//*[@id=\"block-system-main\"]/div/div/div[3]/div[3]/div/div/div[2]/div[4]/div[3]/a"))
				.click();
		captureImage();
		System.out.println("GREEN LANTERN");
		closeApp();

		// Image #5
		openApp();
		driver.findElement(
				By.xpath("//*[@id=\"block-system-main\"]/div/div/div[3]/div[3]/div/div/div[2]/div[5]/div[3]/a"))
				.click();
		captureImage();
		System.out.println("THE FLASH");
		closeApp();

		// Image #6
		openApp();
		driver.findElement(
				By.xpath("//*[@id=\"block-system-main\"]/div/div/div[3]/div[3]/div/div/div[2]/div[6]/div[3]/a"))
				.click();
		captureImage();
		System.out.println("AQUAMAN");
		closeApp();

		// Image #7
		openApp();
		driver.findElement(By.xpath("//a[contains(text(),'Cyborg')]")).click();
		captureImage();
		System.out.println("CYBORG");
		closeApp();

	}

	public static void openApp() {

		// Opens Application
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// Opens Application
		driver.get("https://www.dccomics.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		System.out.println("********** Opening the Application **********");

	}

	// Captures Image
	public static void captureImage() {

		Date currentdate = new Date();
		// System.out.println(currentdate);
		String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(screenshotfilename);

		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(800))
				.takeScreenshot(driver);

		try {
			ImageIO.write(screenshot.getImage(), "PNG",
					new File("/Users/nyla/Git/ScreenShotDemo/ScreenShotDemo/screenshot.FullPage/" + screenshotfilename
							+ ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Closes Application
	public static void closeApp() {

		driver.close();
		System.out.println("********** Closing the Application **********");
	}

}
