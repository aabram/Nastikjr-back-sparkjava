import com.eatmorepancakes.logging.LogEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogEntryTests {
    @Test
    public void CreateLogEntryTest(){
        var logEntry = new LogEntry("en", "horse", true);
        Assertions.assertEquals("en", logEntry.getLanguage());
        Assertions.assertEquals("horse", logEntry.getWord());
        Assertions.assertTrue(logEntry.isFound());
    }
}
