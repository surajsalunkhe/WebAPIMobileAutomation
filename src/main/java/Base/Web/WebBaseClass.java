package Base.Web;

public class WebBaseClass {
    private String featureName;
    private String scenarioName;

    public String getFeatureName() {
        return featureName;
    }

    public String getScenarioName() {
        return scenarioName;
    }
    public WebBaseClass(){
        featureName="BDD";
        scenarioName="DI";
    }

}
