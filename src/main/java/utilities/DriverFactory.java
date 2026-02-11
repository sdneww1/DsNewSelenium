//package utilities;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
////import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class DriverFactory {
//
//    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
//
//    public static WebDriver initDriver(String browser) {
//
//        switch (browser.toLowerCase()) {
//            case "chrome":
//                WebDriverManager.chromedriver().setup();
//                tlDriver.set(new ChromeDriver());
//                break;
//
//            case "firefox":
//                WebDriverManager.firefoxdriver().setup();
//                tlDriver.set(new FirefoxDriver());
//                break;
//
//            case "edge":
//                WebDriverManager.edgedriver().setup();
//                tlDriver.set(new EdgeDriver());
//                // Option B: Manual (if WebDriverManager fails)
////                 System.setProperty("webdriver.edge.driver", "C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe");
////                 tlDriver.set(new EdgeDriver());
//                break;
//
//            default:
//                throw new RuntimeException("Browser not supported");
//        }
//
//        getDriver().manage().window().maximize();
//        return getDriver();
//    }
//
//    public static WebDriver getDriver() {
//        return tlDriver.get();
//    }
//}
