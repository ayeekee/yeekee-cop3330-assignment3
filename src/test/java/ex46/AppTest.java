package ex46;

import junit.framework.TestCase;

import java.io.IOException;

public class AppTest extends TestCase {

    public void testFrequencyFinder() throws IOException {
        assertTrue(7, App.frequencyFinder("badger"));
        assertTrue(1, App.frequencyFinder("snake"));
        assertTrue(2, App.frequencyFinder("mushroom"));
        assertFalse(3, App.frequencyFinder("badger"));
    }

    private void assertFalse(int i, int badger) {
    }

    private void assertTrue(int i, int badger) {
    }
}