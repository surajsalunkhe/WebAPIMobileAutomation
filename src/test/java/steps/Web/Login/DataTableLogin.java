package steps.Web.Login;

import Base.Web.WebBaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class DataTableLogin {
    private WebBaseClass webBaseClass;
    public DataTableLogin(WebBaseClass webBaseClass){
        this.webBaseClass=webBaseClass;
    }

    @Given("^User at the login page of application$")
    public void user_at_the_login_page_of_application() throws Throwable {
    System.out.println("In login page application");
    }

    @When("^User login with the following username and password$")
    public void user_login_with_the_following_username_and_password(DataTable table) throws Throwable {
//        Map<String,String> data=table.asMap(String.class,String.class);
//        for(String key:data.keySet()){
//            System.out.println(String.format("Key :%s, Value: %s",key,data.get(key)));
//        }
        List<String> lst=table.asList(String.class);
        for(String key:lst){
            System.out.println(String.format("Value: %s",key));
        }
    }

    @Then("^User should be able to login with correct username and password$")
    public void user_should_be_able_to_login_with_correct_username_and_password() throws Throwable {
        System.out.println("In login page enter username and password");
    }

    @Given("^Required data here (.+)$")
    public void required_data_here(String param1) throws Throwable {
        System.out.println(param1);
    }

    @When("^user enter (.+)$")
    public void user_enter(String param2) throws Throwable {
        System.out.println(param2);
    }

    @Then("^I enter (.+)$")
    public void i_enter(String param3) throws Throwable {
        System.out.println(param3);
    }
}
