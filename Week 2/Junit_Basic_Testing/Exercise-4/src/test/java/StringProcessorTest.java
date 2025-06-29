import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringProcessorTest {
    private StringProcessor processor;

    @Before
    public void setUp() {
        System.out.println("Setting up test...");
        processor = new StringProcessor();
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning up after test...");
        processor = null;
        System.out.println("Cleanup complete!");
    }

    @Test
    public void concatenate() {
        //Arrange
        String str1 = "Unit";
        String str2 = "Testing";
        String expected = "UnitTesting";

        // Act
        String result = processor.concatenate(str1, str2);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void reverse() {
        // Arrange
        String input = "Nurture";
        String expected = "erutruN";

        // Act
        String result = processor.reverse(input);

        // Assert
        assertEquals(expected, result);
    }
}
