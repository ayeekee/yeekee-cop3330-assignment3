package ex41;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    public void testSortedNames() {
        ArrayList<String> original = new ArrayList<>();
        original.add("Ling, Mai");
        original.add("Johnson, Jim");
        original.add("Zarnecki, Sabrina");
        original.add("Jones, Chris");
        original.add("Jones, Aaron");
        original.add("Swift, Geoffrey");
        original.add("Xiong, Fong");

        ArrayList<String> sorted = new ArrayList<>();

        sorted = App.sortedNames(original);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("Johnson, Jim");
        expected.add("Jones, Aaron");
        expected.add("Jones, Chris");
        expected.add("Ling, Mai");
        expected.add("Swift, Geoffrey");
        expected.add("Xiong, Fong");
        expected.add("Zarnecki, Sabrina");
        
        assertArrayEquals(expected, sorted);
    }

    private void assertArrayEquals(ArrayList<String> expected, ArrayList<String> sorted) {
    }
}
