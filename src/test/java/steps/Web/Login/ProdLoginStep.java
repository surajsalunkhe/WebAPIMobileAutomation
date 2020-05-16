package steps.Web.Login;
import Base.Web.WebBaseClass;
import io.cucumber.java.en.And;

public class ProdLoginStep {
	private WebBaseClass webBaseClass;
	public ProdLoginStep(WebBaseClass webBaseClass){
		this.webBaseClass=webBaseClass;
	}
	@And("user validates the capcha")
	public void user_validates_the_capcha() {
		System.out.println("@And -- user validates the capcha");
	
	}

}
