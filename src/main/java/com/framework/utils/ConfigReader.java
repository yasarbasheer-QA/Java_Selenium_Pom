package com.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties prop = new Properties();
    private static final String Base_Path = "src/main/resources/Config.properties";

static {
    try {
        FileInputStream file = new FileInputStream
                (Base_Path);
        prop.load(file);
    } catch (IOException e){
       throw new RuntimeException(e);
}

}
    public static String get(String key){
        return prop.getProperty(key);


}
}
