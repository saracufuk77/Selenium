package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//NOTE: this class reads from the properties file.
public class ConfigsReader_old {

    static Properties properties;

    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/configs/configuration.properties";
        FileInputStream fis =new FileInputStream(filePath);
        Properties properties = new Properties();
        properties.load(fis);

        final var browser = properties.getProperty("browser");
        System.out.println("browser = " + browser);
    }

    /**
     * This method will locate and prepare the properties File
     * @param filePath specify file path here.
     */

    public static void loadProperties(String filePath){
        try {
            FileInputStream fis =new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method will return value of the specified key from the properties file
     * @param key accepted as a String
     * @return value of the given key
     */

    public static String getProperties(String key){
         return properties.getProperty(key);
    }

}
