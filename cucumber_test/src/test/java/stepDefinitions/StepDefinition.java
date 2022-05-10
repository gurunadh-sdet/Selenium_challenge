package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefinition {

    @Given("^User is on landing page$")
    public void user_is_on_landing_page() throws Throwable {
    	 System.out.println("User is on landing page");
       
    }

    @When("Login with user name {string} and password {string}")
    public void login_with_user_name_and_password(String string1, String string2) {
        System.out.println(string1);
        System.out.println(string2);
    }

    @Then("^home page should be displayed$")
    public void home_page_shpuld_be_displayed() throws Throwable {
    	 System.out.println("home page should be displayed");
    }
    
    @Then("cards displayed to be {string}")
    public void cards_displayed_to_be(String string) {
    	 System.out.println(string);
    }


}