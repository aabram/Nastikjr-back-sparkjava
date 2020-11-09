import com.eatmorepancakes.WordService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordServiceTests {
    @Test
    public void getENExactTest(){
        var result = WordService.getExactWordEN("cat");
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void getETPartialTest(){
        var result = WordService.getWordET("veider");
        Assertions.assertEquals(6, result.size());
    }
}
