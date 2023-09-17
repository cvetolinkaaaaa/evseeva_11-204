import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckValueAnnotationValidator {


    public static boolean isValid(Class clazz, Object object) throws Exception{
        List<Field> fieldList = new ArrayList<>(List.of(clazz.getDeclaredFields()));
        List<Field> neededFields = new ArrayList<>();
        for (Field field : fieldList){
            List<Annotation> annotations = List.of(field.getAnnotations());
            if(annotations.stream().anyMatch(a -> a.annotationType().equals(CheckValue.class))){
                neededFields.add(field);
            }
        }
        for (Field field : neededFields){
            field.setAccessible(true);
            CheckValue checkValue = field.getAnnotation(CheckValue.class);
            String regex = checkValue.value();
            Pattern pattern = Pattern.compile(regex);
            String value = (String) field.get(object);
            Matcher matcher = pattern.matcher(value);
            if (!matcher.matches()) return false;
        }
        return true;
    }

}