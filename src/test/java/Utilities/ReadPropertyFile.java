package Utilities;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
    public void King() throws IOException {
        FileReader Read = new FileReader("/Users/ahlawat/IdeaProjects/FaceBookAutomation/src/test/resources/ConfigFiles/config.properties");
        Properties Property = new Properties();
        Property.load(Read);
        System.out.println(Property.getProperty("browser"));
        System.out.println(Property.getProperty("testurl"));
    }
}
