package class09;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class connnectWithPropertiesFile {
    public static void main(String[] args) throws IOException {
        //step1: locate the properteis file within the project
//        String filePath="C:\\Users\\Owner\\JavaProjects\\UfukJavaProjectsVersion2\\SeleniumProject\\configs\\configuration.properties";//<====Full Path

        //Full path :properties dosyasi uzerinde sag tikla, take the absolute/full path and paste the filePath.
        //user.dir + root path


        final var projectLocation = System.getProperty("user.dir");
        System.out.println("projectLocation = " + projectLocation);

        String filePath = System.getProperty("user.dir") + "/configs/configuration.properties";
        //bir usttekinin ikinci kismi configuration.properteis file sag tiklayip path from content root alinir ve basina "/" ile concatanate edilir.
        System.out.println("filePath = " + filePath);

//        //Retrieving file path different ways
//        //1.way : Full Path : go to file, right click, copy the absolute path
//        String filepath1 = "C:\\Users\\Owner\\JavaProjects\\UfukJavaProjectsVersion2\\SeleniumProject\\src\\class04\\xpathDemo.java";
//        System.out.println("filepath1 = " + filepath1);
//        //2.way : concateneting project file path (System.getproperty("user.dir") take the project file otomaticaly) + class file path (Root content path)
//        String filepath2 = System.getProperty("user.dir")+"/src/class04/xpathDemo.java";
//        System.out.println("filepath2 = " + filepath2);
//        //always use the second way. It is a good practise. And you do not have to change user all times.


        FileInputStream fis = new FileInputStream(filePath); //Filepath handler, establish connection stream with my file

        Properties properties = new Properties();
        properties.load(fis);

        //now it is ready to use
        final var url = properties.getProperty("url");
        System.out.println("url = " + url);

        final var browser = properties.getProperty("browser");
        System.out.println("browser = " + browser);


        //getting keys or values or both
        System.out.println("---------Values----------");
        Collection values = properties.values();
        for (Object value : values) {
            System.out.println(value);
        }

//        System.out.println("-------Keys--------");
//        Collection keys = properties.keySet();
//        for (Object key : keys) {
//            System.out.println(key);
//        }

        System.out.println("-------Keys--------");
        Set<Object> keys2 = properties.keySet();
        for (Object key : keys2) {
            System.out.println(key);
        }

        System.out.println("------Keys and Values together----------");
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Object entry : entries) {
            System.out.println(entry);
        }


    }
}
