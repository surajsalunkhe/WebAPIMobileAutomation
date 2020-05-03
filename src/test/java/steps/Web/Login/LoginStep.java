package steps.Web.Login;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStep {
	
	@Before
	public void setup() {
		System.out.println("browser launched");
	}
	@After
	public void teardown() {
		System.out.println("browser quit");
	}
	
	@Before("@prod")
	public void prodsetup() {
		System.out.println(" prod browser launched");
	}
	@After("@prod")
	public void prodteardown() {
		System.out.println("prod browser quit");
	}
	
	
	@Given("user navigates to facebook website")
	public void user_navigatesto_facebook_website() {
		System.out.println("@Given -- user navigates to the facebook");
	
	}

	@When("user validates the homepage title")
	public void user_validates_the_homepage_title() {
		System.out.println("@when -- user validates the homepage title");
	}

	@Then("^user entered \"([^\"]*)\" username$")
	public void user_entered_valid_username(String username) {
		System.out.println("@Then -- user entered "+username+" username");
	}

	@And("^user entered \"([^\"]*)\" password$")
	public void user_entered_valid_password(String Password) {
		System.out.println("@And -- user entered "+Password+" password");
	}

	@Then("^user \"([^\"]*)\" sucessfully logged in$")
	public void user_shouldbe_sucessfully_logged_in(String validateLogin) {
		System.out.println("@Then -- user "+validateLogin+" successfully logged in");
	}
	@And("^user selected the Age Group$")
	public void user_selected_the_Age_Group( DataTable table) {
		List <Map <String, String>>  data=table.asMaps(String.class, String.class);
		System.out.println("@And-- user selected the Age group "+data.get(0).get("Age")+
				" user selected location as: "+data.get(0).get("Location"));
	}

	

}
