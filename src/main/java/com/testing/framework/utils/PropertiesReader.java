package com.testing.framework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    //File -- Read the data from the data.properties file in a key, value pair

    public static String readKey(String key) {
        Properties p = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/data.properties");
            p = new Properties();
            try {
                p.load(fileInputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return p.getProperty(key);
    }
}
