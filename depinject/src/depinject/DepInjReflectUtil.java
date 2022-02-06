package depinject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class DepInjReflectUtil {
    private static Map<Class,Object> instanceMap = new HashMap<>();


    public static void initializeDepInjection(Object object) {
        String injectClassStr;
//        Map<Class,Object> instanceMap = new HashMap<>();

        if (object != null) {
            try {
                for (Field field : object.getClass().getDeclaredFields()) {
                    if (field.isAnnotationPresent(DependencyInjection.class)) {
                        Class<?> typeIface = field.getType();
                        if (typeIface.isInterface()) {
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

                            Class<?> injectClass = Class.forName(injectClassStr);
                            if (instanceMap.get(injectClass) != null) {
                                field.setAccessible(true);
                                field.set(object, instanceMap.get(injectClass));
                                field.setAccessible(false);
                                return;
                            } else {
                            Constructor<?> constructor = injectClass.getDeclaredConstructor();
//                            if (!constructor.canAccess(null)) {
//                                constructor.setAccessible(true);
                                Object injectObj = constructor.newInstance();
                                instanceMap.put(injectClass, injectObj);
//                                constructor.setAccessible(false);
                                field.setAccessible(true);
                                field.set(object, injectObj);
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
