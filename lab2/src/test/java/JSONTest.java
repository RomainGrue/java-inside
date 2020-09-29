
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONTest {
    public Alien alien = new Alien(120, "Xenux");
    public Person person = new Person("Jean", "Dujard");

    /*@Test
    public void shouldReturnRightStringforAlien(){
        assertEquals("int age,java.lang.String planet", JSONPrinter.toJSON(alien));
    }

    @Test
    public void shouldReturnRightStringforPerson(){
        assertEquals("java.lang.String firstName,java.lang.String lastName", JSONPrinter.toJSON(person));
    }*/
    /*@Test
    public void shouldReturnRightStringforAlien(){
        assertEquals("{"int age":120,"java.lang.String planet":Xenux}", JSONPrinter.toJSON(alien));
    }

    @Test
    public void shouldReturnRightStringforPerson(){
        assertEquals("{"java.lang.String firstName":Jean,"java.lang.String lastName":Dujard}", JSONPrinter.toJSON(person));
    }*/
    @Test
    public void shouldReturnRightMapforAlien(){
        Map<String, Object> mapExpected = IncompleteJSONParser.parse("{ \"int age\":120, \"java.lang.String planet\":\"Xenux\" }");
        assertEquals(mapExpected, IncompleteJSONParser.parse(JSONPrinter.toJSON(alien)));
    }

    @Test
    public void shouldReturnRightMapforPerson(){
        Map<String, Object> mapExpected = IncompleteJSONParser.parse("{ \"java.lang.String firstName\":\"Jean\", \"java.lang.String lastName\":\"Dujard\" }");
        assertEquals(mapExpected, IncompleteJSONParser.parse(JSONPrinter.toJSON(person)));
    }
}
