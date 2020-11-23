package webtesting.browser;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public interface BrowserConfiguration {
	
	public WebDriver getBrowserDriver();
	public boolean isGridSetup(); // True or false based on grid setup
	public URL getHubUrl() throws MalformedURLException;

}
