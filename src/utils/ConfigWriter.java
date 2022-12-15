 package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigWriter {
    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/configs/configuration.properties";
        FileInputStream fis = new FileInputStream(filePath);
        Properties properties = new Properties();
        properties.load(fis);

        //setup is ready. instead of reading, this time I will write to Properties File.
        properties.setProperty("Phone", "2899808671");
        properties.setProperty("email","tester@gmail.com");

        FileOutputStream fos = new FileOutputStream(filePath);
        properties.store(fos,"adding phone number");

        // do not repeat .store more than once, It will dublicates everyting
        //add email adress. asagidaki gibi yaziyoruz ama bunu commente alip yukariya yapistiriyoruz ki tum satirlari tekrar yazip dublicates yapmasin/
//        properties.setProperty("email","tester@gmail.com");
//        properties.store(fos,"adding email address");



    }
}
