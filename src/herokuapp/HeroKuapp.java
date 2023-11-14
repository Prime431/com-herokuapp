package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class HeroKuapp {
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;

    public static void main(String[] args) {
        // using scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Browser name : ");
        String browserName = scanner.nextLine();

        selectingBrowser(browserName);
        loginCheck();
        scanner.close();
    }
    public static void selectingBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
    }
    public static void loginCheck() {
        driver.get(baseUrl);
        System.out.println("Title of the Page : " + driver.getTitle());
        System.out.println("Current URL : " + driver.getCurrentUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // implicit timeout
        System.out.println("Page Source : " + driver.getPageSource());
        driver.findElement(By.id("username")).sendKeys("vishal@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Password");
        // login click
        System.out.println("Print the current URL : " + driver.getCurrentUrl());
        driver.navigate().refresh();
        driver.close();

    }
}
