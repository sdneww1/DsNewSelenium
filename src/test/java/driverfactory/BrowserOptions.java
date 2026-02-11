package driverfactory;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserOptions {

	public ChromeOptions chromeOption() {
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.setAcceptInsecureCerts(true);
		options.addArguments("--start-maximized", "--incognito", "--no-sandbox", "--disable-dev-shm-usage");
		return options;
	}

	public EdgeOptions edgeOption() {
		EdgeOptions options = new EdgeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.setAcceptInsecureCerts(true);
		options.addArguments("--start-maximized", "--incognito", "--no-sandbox", "--disable-dev-shm-usage",
				"--remote-allow-origins=*");
		return options;
	}

	public FirefoxOptions firefoxOption() {
		FirefoxOptions options = new FirefoxOptions();
		if (System.getenv("JENKINS_URL") != null)
			options.addArguments("--headless");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.setAcceptInsecureCerts(true);
		return options;
	}
}
