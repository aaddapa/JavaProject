import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.AddNumbers;
import org.junit.jupiter.api.Test;

public class AddNumbersTest {
    @Test
    public void testAddition() {
        AddNumbers calculator = new AddNumbers();
        int result = calculator.add(3, 5);
        assertEquals(8, result);
    }
}