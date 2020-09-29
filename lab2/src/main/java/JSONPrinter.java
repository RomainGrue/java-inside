import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.RecordComponent;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class JSONPrinter {

    /*public static String toJJSON(Person person){
        return """
                {
                "firstName":"%s",
                "lastName":"%s"
                }
                """.formatted(person.firstName(), person.lastName());
    }

    public static String toJSON(Alien alien) {
        return """
      {
        "age": %s,
        "planet": "%s"
      }
      """.formatted(alien.age(), alien.planet());
    }*/

    private static Object strComponent(Method accessor, Record record) {
        Objects.requireNonNull(record);
        try{
            return accessor.invoke(record);
        } catch (IllegalAccessException e) {
            throw (IllegalAccessError) new IllegalAccessError().initCause(e);
        } catch (InvocationTargetException e){
            var cause = e.getCause();
            if(cause instanceof RuntimeException re){
                throw re;
            }
            if(cause instanceof Error err){
                throw err;
            }
            throw new UndeclaredThrowableException(e);
        }
    }

    private static String strCompile(Object o){
        if(o instanceof String){
            return "\""+o.toString()+"\"";
        }
        return o.toString();
    }

    @SuppressWarnings("unchecked")
    public static String toJSON(Record record) {
        Class classe = record.getClass();
        return Arrays.stream(classe.getRecordComponents())
                .map(e -> "\""+e.toString()+"\""+":"+ JSONPrinter.strCompile(JSONPrinter.strComponent(e.getAccessor(), record)))
                .collect(Collectors.joining(",","{","}"));

        //return Arrays.stream(classe.getRecordComponents()).map(RecordComponent::toString).collect(Collectors.joining(","));
        /*String str = "";
        for (RecordComponent recordC : classe.getRecordComponents()){
            str += recordC.getName();
        }
        return str;*/
    }

    public static void main(String[] args) {
        var person = new Person("John", "Doe");
        System.out.println(toJSON(person));
        var alien = new Alien(100, "Saturn");
        System.out.println(toJSON(alien));
    }
}
