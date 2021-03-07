import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OnePointFourTests {

    @Test
    public void testCompressor() {
        String s = "aabccccccccaaa";
        String result = "a2b1c8a3";

        assertThat(result, is("a2b1c8a3"));

    }
}
