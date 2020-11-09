import com.eatmorepancakes.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordTests {

    @Test
    public void WordObjectTest() {
        Word word = new Word(1, "cat", "kass");
        Assertions.assertNotNull(word);
        Assertions.assertEquals(1, word.getId());
        Assertions.assertEquals("cat", word.getEn());
        Assertions.assertEquals("kass", word.getEt());
    }
}
