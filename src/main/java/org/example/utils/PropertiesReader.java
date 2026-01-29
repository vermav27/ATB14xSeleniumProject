package org.example.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    // it will read data.properties file. Here key will be given and its corresponding data from
    // data.properties file will be returned.

    public static String readKey(String key){

        Properties p;
        try {
            String userDir = System.getProperty("user.dir");
            String filePath =  userDir + "/src/main/resources/data.properties";
            FileInputStream fileInputStream = new FileInputStream(filePath);
            p = new Properties();
            p.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return p.getProperty(key);

    }


}
