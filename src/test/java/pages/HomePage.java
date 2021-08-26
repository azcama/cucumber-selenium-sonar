package pages;

import java.io.IOException;
import java.sql.ResultSet;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import database.SeleniumDatabase;
import webbrowser.WebDriverFactory;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class HomePage {

	private static WebDriver driver;

	private String url = "https://www.wikipedia.org/";

	private By headerUserByCSS = By.cssSelector(".header-user");
	private By logoutByID = By.id("logout");

	private SeleniumDatabase dbTest = new SeleniumDatabase();
	private List<Integer> elementsToRemove = new ArrayList<>();

	private static final Logger LOGGER = Logger.getLogger(HomePage.class.getName());

	private void startDrivers() throws IOException {
		setLog();

		setDriver(WebDriverFactory.createWebDriver());

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	private void setLog() {
		LOGGER.setLevel(Level.WARNING);
	}

	public void goToHome() throws IOException {
		startDrivers();
		getDriver().get(url);
	}

	public void addElementToRemove(int elementToRemove) {
		elementsToRemove.add(elementToRemove);
	}

	public ResultSet searchInDatabase(String search) {
		try {
			dbTest.setUp();
			return dbTest.doQuery(search);
		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
		}
		return null;
	}


	public void close() {
		dbTest.close();
		getDriver().quit();
	}

	protected static WebDriver getDriver() {
		return driver;
	}

	private static void setDriver(WebDriver driver) {
		HomePage.driver = driver;
	}

}
