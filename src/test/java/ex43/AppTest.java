package ex43;

import junit.framework.TestCase;

import java.io.File;

public class AppTest extends TestCase {

    public void testMakeFile() {
        File file = new File("src/main/java/ex43/website/");
        assertTrue(file.exists());
    }
}