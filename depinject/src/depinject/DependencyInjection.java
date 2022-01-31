package depinject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DependencyInjection {
    String depInjectFileSource() default "dependency.properties";
    String depInjectClassName() default " ";
}
