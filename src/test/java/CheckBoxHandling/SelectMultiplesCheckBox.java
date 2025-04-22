
package CheckBoxHandling;


import java.util.List;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

@Test
public class SelectMultiplesCheckBox{
	Playwright playwright;
	BrowserType browsertype ;
	Browser browser ;
	BrowserContext browserContext ;
	Page page; 
	
	@BeforeSuite
	public void startBrowser()
	{
		playwright = Playwright.create();
		browsertype = playwright.chromium();
		browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		browserContext = browser.newContext(new Browser.NewContextOptions());
		page =browser.newPage();
		System.out.println("Version :" +browser.version());
	}
	@Test(priority=0)
	public void OpenUrl() throws InterruptedException
	{
		page.navigate("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		Thread.sleep(500);
	}
	@Test(priority=1)
	public void Checkbox() throws InterruptedException
	{
	List<ElementHandle> checkboxs = page.querySelectorAll("//input[@type='checkbox']");
	for (ElementHandle el : checkboxs) {
		if (!el.isChecked()) {
			el.click();
			Thread.sleep(5000);
		}
	}
	Thread.sleep(5000);
	}
	
	@AfterSuite
	public void closeBrowser()
	{
		page.close();
		browser.close();
		playwright.close();
	}

}