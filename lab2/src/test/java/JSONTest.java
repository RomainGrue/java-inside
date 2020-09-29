
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONTest {
    public Alien alien = new Alien(120, "Xenux");
    public Person person = new Person("Jean", "Dujard");

    @Test
    public void shouldReturnRightStringforAlien(){
        assertEquals("120;Xenux", JSONPrinter.toJSON(alien));
    }

    @Test
    public void shouldReturnRightStringforPerson(){
        assertEquals("Jean;Dujard", JSONPrinter.toJSON(alien));
    }
}
