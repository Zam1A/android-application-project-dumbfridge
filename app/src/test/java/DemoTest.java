import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DemoTest {
    @Test
    void testAddition(){
        assertEquals(6, 3 + 3);
    }

    @Test
    void testAdditionFails(){
        assertNotEquals(0.3, 0.1 + 0.2);
    }
}