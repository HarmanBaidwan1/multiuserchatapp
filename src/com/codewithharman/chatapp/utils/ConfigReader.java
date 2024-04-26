package com.codewithharman.chatapp.utils;

import java.util.ResourceBundle;

//this Config Reader class will read config.properties like files
public class ConfigReader {
    ConfigReader() {
    }

    private static ResourceBundle rb = ResourceBundle.getBundle("config");

    // a public method which will interact
    public static String getValue(String key) {
        return rb.getString(key);
    }
}
