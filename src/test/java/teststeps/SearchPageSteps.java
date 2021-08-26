package teststeps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginPageSteps {
	
	private final LoginPage loginPage = new LoginPage();

    @When("User searches {string}")
    public void write_to_search(String search) {
        loginPage.search(search);
    }

    @Then("^A list of results is displayed$")
    public void is_a_list() {
        assertTrue(loginPage.getResults().size() > 0);
    }
}
