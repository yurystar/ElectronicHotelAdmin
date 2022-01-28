package com.senla.elhoteladmin.configuration;

import java.lang.reflect.Field;

public class ConfigUtil {
    public static void initializeProperties(Object object) {
        if (object != null) {
            Class<?> clazz = object.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                ConfigProperty annotation = field.getAnnotation(ConfigProperty.class);
                if (annotation != null) {
                    String propertyName = annotation.propertyName();
                    String configFileName = annotation.configFileName();
                    if (propertyName.equals(" ")) {
                        propertyName = field.getName();
                    }
                    field.setAccessible(true);
                    try {
                        Class<?> type = field.getType();
                        String property = PropertiesReader.getProperty(configFileName, propertyName);
                        if (type.equals(Integer.class) || type.equals(int.class)) {
                            field.set(object, Integer.parseInt(property));
                        }
                        if (type.equals(Boolean.class) || type.equals(boolean.class)) {
                            field.set(object, Boolean.parseBoolean(property));
                        }
                        if (type.equals(String.class)) {
                            field.set(object, property);
                        }
                    } catch (IllegalAccessException e) {
                        System.out.println("Ошибка рефлексивного доступа");
                    } finally {
                        field.setAccessible(false);
                    }
                }
            }
        }
    }
}
