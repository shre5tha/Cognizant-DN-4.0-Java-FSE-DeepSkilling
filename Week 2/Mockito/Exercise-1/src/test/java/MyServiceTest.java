import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MyServiceTest {
        @Test
        public void testExternalAPI() {
            // Creating Mock Object
            ExternalAPI mockObj = Mockito.mock(ExternalAPI.class);

            // Stubbing the method to return predefined values
            when(mockObj.getData()).thenReturn("Mock Data");

            // Writing a test case that uses the mock object
            MyService service = new MyService(mockObj);
            String result = service.fetchData();
            assertEquals("Mock Data", result);
        }
    }
