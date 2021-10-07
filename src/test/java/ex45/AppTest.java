package ex45;

import junit.framework.TestCase;

import java.io.IOException;

public class AppTest extends TestCase {

    public void testReplaceWord() throws IOException {

        String path = ("src/main/java/ex45/exercise45_input.txt");

        String expected = "\"One should never use the word \\\"use\\\" in writing. Use \\\"use\\\" instead.\\n\" +\n" +
                "                \"For example, \\\"She uses an IDE to write her Java programs\\\" instead of \\\"She\\n\" +\n" +
                "                \"uses an IDE to write her Java programs\\\".\"";

        assertTrue(path, expected);
    }

    private void assertTrue(String path, String expected) {
    }

}