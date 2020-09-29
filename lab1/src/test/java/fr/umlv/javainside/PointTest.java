package fr.umlv.javainside;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {
    private Point point = new Point(5,3);

    @Test
    public void shouldReturnRightX() {
        assertEquals(point.x(), 5);
    }

    @Test
    public void shouldReturnRightY() {
        assertEquals(point.y(), 3);
    }

}
