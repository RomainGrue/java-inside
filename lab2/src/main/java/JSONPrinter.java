import java.lang.reflect.RecordComponent;
import java.util.Arrays;
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

    public static String toJSON(Record record){
        Class classe = record.getClass();
        return Arrays.stream(classe.getRecordComponents()).map(RecordComponent::toString).collect(Collectors.joining(";"));
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
