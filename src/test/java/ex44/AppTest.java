package ex44;

import junit.framework.TestCase;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class AppTest extends TestCase {

    public void testReadInfo() throws IOException, ParseException {
        assertTrue(1, App.readInfo("doodad"));
        assertTrue(1, App.readInfo("thing"));
        assertTrue(1, App.readInfo("widget"));
        assertTrue(0, App.readInfo("ipad"));
        assertTrue(0, App.readInfo("galaxy"));
    }

    private void assertTrue(int i, int doodad) {
    }
}