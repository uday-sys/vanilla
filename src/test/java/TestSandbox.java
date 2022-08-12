import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import com.typesafe.config.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSandbox {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private WebDriver driver = DriverFactory.getDriver();

    @Tag("smokeTest")
    @DisplayName("This test is for demo purpose only to show that the basic code works." +
            "You have to use the best practices that you normally use to design your tests")
    @Test
    void assertThatHomePageTitleIsCorrect() {
        driver.get(HOME_PAGE_URL);
        assertEquals("Amazon.com. Spend less. Smile more.", driver.getTitle());
        		System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32 (2)\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","E:\\Selenium Setup\\Workspace1\\FirstSeleniumProject\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.Amazon.in");
		driver.manage().window().maximize();
		driver.findElement(By.id("nav-hamburger-menu")).click();
		driver.findElement(By.xpath("//*[@data-menu-id='9']/div[text()='TV, Appliances, Electronics']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='hmenu-item' and text()='Televisions']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='a-size-base a-color-base' and text()='Samsung']//parent::a/div/label//i")).click();
		driver.findElement(By.xpath("//*[@class='a-dropdown-prompt' and text()='Featured']")).click();
		driver.findElement(By.xpath("//*[@class='a-dropdown-link' and text()='Price: High to Low']")).click();
		driver.findElement(By.xpath("//*[@data-index='2']")).click();
		Set<String> st = driver.getWindowHandles();
		ArrayList<String> al = new ArrayList<String>(st);
		
		driver.switchTo().window(al.get(1));
		Boolean ft ;

		ft= driver.findElement(By.xpath("//*[text()=' About this item ']")).isDisplayed();
		System.out.println(ft);
    }
}
