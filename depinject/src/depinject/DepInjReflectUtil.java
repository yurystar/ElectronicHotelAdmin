package depinject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class DepInjReflectUtil {

    public static void initializeDepInjection(Object object) {
        String injectClassStr;
        if (object != null) {
            try {
                for (Field field : object.getClass().getDeclaredFields()) {
                    if (field.isAnnotationPresent(DependencyInjection.class)) {
                        Class<?> type = field.getType();
                        if (type.isInterface()) {
                            DependencyInjection annotation = field.getAnnotation(DependencyInjection.class);
                            String injectClassName = annotation.depInjectClassName();
                            String dependencyFileName = annotation.depInjectFileSource();
                            if (injectClassName.equals(" ")) {
                                injectClassName = field.getName();
                                injectClassStr = DependencyReader
                                        .getPropertyDepInj(dependencyFileName, injectClassName);
                            } else {
                                injectClassStr = annotation.depInjectClassName();
                            }
                            type = Class.forName(injectClassStr);
                            Constructor<?> constructor = type.getDeclaredConstructor();
                            if (!constructor.canAccess(null)) {
                                constructor.setAccessible(true);
                                Object o = constructor.newInstance();
                                field.setAccessible(true);
                                field.set(object, o);
                                field.setAccessible(false);
                            }
                        }
                    }
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException |
                    InstantiationException | ClassNotFoundException exception) {
                System.out.println("Error" + exception);
            }
        }
    }
}
