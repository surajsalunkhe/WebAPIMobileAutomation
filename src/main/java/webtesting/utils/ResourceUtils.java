package webtesting.utils;

public class ResourceUtils {
	public static void main(String args[]){
		System.out.println(getResourcePath("chromedriver"));
	}


	// path based the resurce name
	public static String getResourcePath(String resourceName) {
		String path = getBasePath() + resourceName;
		return path;
	}
	
	// Base path
	public static String getBasePath() {
		String path = ResourceUtils.class.getClassLoader().getResource(".").getPath();
		return path;
	}

}
