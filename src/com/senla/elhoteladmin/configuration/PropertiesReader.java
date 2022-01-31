package com.senla.elhoteladmin.configuration;

import com.senla.elhoteladmin.configuration.exception.PropertiesNotFoundException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static final String PROPERTIES_PATH = "resources";
    private static Properties properties;

    private static void readProperties(String configFileName) {
        try(FileInputStream stream = new FileInputStream(PROPERTIES_PATH + File.separator + configFileName)) {
            properties = new Properties();
            properties.load(stream);

        } catch (FileNotFoundException e) {
            System.out.println("Нет такого файла" + configFileName);
        } catch (IOException e) {
            System.out.println("Ошибка чтения");
        }
    }

    public static String getProperty(String configFileName, String key) {

        if (properties == null) {
            readProperties(configFileName);
        }
        String property = properties.getProperty(key);
        if (property == null) {
            throw new PropertiesNotFoundException();
        }
        return property;
    }
}
