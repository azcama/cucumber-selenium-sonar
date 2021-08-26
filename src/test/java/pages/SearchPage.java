package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends HomePage {


	public void search(String search) {
		getDriver().findElement(By.id("searchInput")).click();
		getDriver().findElement(By.id("searchInput")).sendKeys(search);
		getDriver().findElement(By.id("searchInput")).sendKeys(Keys.ENTER);
	}

	public List<WebElement> getResults() {
		return getDriver().findElements(By.id("firstHeading"));
	}
}