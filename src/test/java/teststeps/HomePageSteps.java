package teststeps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import pages.HomePage;

import java.io.IOException;

public class HomePageSteps {
	protected HomePage homePage = new HomePage();
	
	@Given("A browser")
    public void createBrowser() throws IOException {
		homePage.goToHome();
    }
	  
	@After
	public void after(Scenario scenario) {
    	homePage.close();
	}

}
