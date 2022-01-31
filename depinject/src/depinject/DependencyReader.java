package depinject;

import depinject.exceptionDepInj.DepInjNotFoundException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DependencyReader {
    private static final String DEPENDENCY_PATH = "resources";
    private static Properties properties;

    private static void readPropertiesDepInj(String dependencyFileName) {
        try(FileInputStream stream =
                    new FileInputStream(DEPENDENCY_PATH + File.separator + dependencyFileName)) {
            properties = new Properties();
            properties.load(stream);

        } catch (FileNotFoundException e) {
            System.out.println("Нет такого файла" + dependencyFileName);
        } catch (IOException e) {
            System.out.println("Ошибка чтения");
        }
    }

    public static String getPropertyDepInj(String dependencyFileName, String key) {

        if (properties == null) {
            readPropertiesDepInj(dependencyFileName);
        }
        String property = properties.getProperty(key);
        if (property == null) {
            throw new DepInjNotFoundException();
        }
        return property;
    }
}
