package ex43;

import junit.framework.TestCase;

import java.io.File;

public class AppTest extends TestCase{

    public void testMakeDirectory() {
        String testPath = "src/test/java/ex43/AppTest.java";
        File test = App.makeDirectory(testPath);
        assertEquals(true, test.isFile());
    }
}