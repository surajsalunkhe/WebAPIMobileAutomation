package hooks;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class generalHooks {
    @Before
    public void setUp(Scenario name){
    System.out.println("------Before Hook-----");
    System.out.println("Name of Scenario\t"+name.getName());
    System.out.println("Status of Scenario\t"+name.getStatus());
    }
    @After
    public void tearDown(Scenario name){
        System.out.println("------After Hook-----");
        System.out.println("Name of Scenario\t"+name.getName());
        System.out.println("Status of Scenario\t"+name.getStatus());
    }
}
