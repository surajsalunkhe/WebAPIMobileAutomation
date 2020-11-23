package TestUtils.loadResources;

public class TestResourceUtils {
	// path based the resurce name
	public static void main(String args[]){
		System.out.println(getResourcePath("chromedriver"));
	}
	public static String getResourcePath(String resourceName) {
		String path = getBasePath() + resourceName;
		return path;
	}
	
	// Base path
	public static String getBasePath() {
		String path = TestResourceUtils.class.getClassLoader().getResource("./grid/").getPath();
		return path;
	}

}
