package webtesting.utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.Constants;
import utility.ReadSystemVariables;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ReadPropertiesFile {
    private static String platformToRun;
    private static String environmentToRun;
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadPropertiesFile.class);

    private ReadPropertiesFile() {
    }

    /**
     * Load a properties file by passing in the fileName.
     * @param propFileName
     * @return Properties
     * @throws Exception
     */

    private static Properties loadPropertiesFile(final String propFileName) {
        // create and load default properties
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(propFileName);
            prop.load(input);
            input.close();
        } catch (IOException ex) {
            LOGGER.error("Cannot open properties file: " + propFileName + " exception: \n" + ex);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    LOGGER.error("loadPropertiesFile(): \n" + e);
                }
            }
        }

        return prop;
    }

    /**
     * Based on the key get the Value from the environment.properties file.
     *
     * @param key
     * @return
     */

    public static String getEnvironmentProperty(String key) {
        platformToRun = System.getProperty("platform");
        environmentToRun = System.getProperty("env");

        String value = null;
        List<String> results = new ArrayList<String>();
        File folder = new File("src/test/resources/config/" + platformToRun + "/" + environmentToRun + "/");

        FilenameFilter txtFileFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".properties")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        File[] files = folder.listFiles(txtFileFilter);
        for (File file : files) {
            if (file.isFile()) {
                if (!file.getName().startsWith("locale") && !file.getName().startsWith("temp")) {
                    results.add(file.getPath());
                }
            }
        }
        for (int i = 0; i < results.size(); i++) {
            Properties prop = loadPropertiesFile(results.get(i));
            value = prop.getProperty(key);
            if (value == null || Constants.EMPTY.equals(value)) {
                int count = 0;
                while (count < results.size()) {

                    Properties searchAllProp = loadPropertiesFile(results.get(count));
                    value = searchAllProp.getProperty(key);
                    if (value != null) {
                        break;
                    }
                    count++;
                }

            }
        }
        return value;
    }


    /**
     * Get value for the key from the given properties file. Filename is the complete pathname.
     *
     * @parameter key
     * @parameter completeFileName
     * return value
     **/
    public static String getPropertyValueFromFile(String key, String completeFileName) {

        Properties prop = loadPropertiesFile(completeFileName);
        LOGGER.info("retrieving key <" + key + "> and value <" + prop.getProperty(key) + ">");
        return prop.getProperty(key);

    }
    public static void writeToProperties(String key, String value, String completeFileName) {
        Properties prop = loadPropertiesFile(completeFileName);
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(completeFileName);
            prop.setProperty(key, value);
            prop.store(out, null);
            out.close();
        } catch (FileNotFoundException e) {
            LOGGER.debug("FileNotFoundException: Error setting the value from properties file for key" + key);
        } catch (IOException io) {
            LOGGER.error("IOException: Error setting the value from properties file for key" + key + " exception: \n" + io);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    LOGGER.error("writeToProperties(): \n" + e);
                }
            }
        }

        LOGGER.info("setting key <" + key + "> and value <" + value + ">");
    }


    public static String getDBQueryFromPropertyFile(String key) {
        String filepath = Constants.TEST_RESOURCES_CONFIG + ReadSystemVariables.getEnvironment() + "/" + Constants.DBQUERYFILE_IDENTIFIER + ".properties";
        return getPropertyValueFromFile(key, filepath);

    }

    public static String getDBConfigValueFromPropertyFile(String key) {
        String filepath = Constants.TEST_RESOURCES_CONFIG + ReadSystemVariables.getEnvironment() + "/" + Constants.DBCONFIGFILE_IDENTIFIER + ".properties";
        return getPropertyValueFromFile(key, filepath);
    }

}


