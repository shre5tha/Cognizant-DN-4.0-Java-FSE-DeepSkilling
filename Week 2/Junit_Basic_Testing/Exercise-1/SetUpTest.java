import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SetUpTest {
    String str = "Junit test case set up";

    @Test

    public void testString() {

        System.out.println("Inside testString()");

        assertEquals("Junit test case set up", str);
    }
}
