package ex42;

import junit.framework.TestCase;

import java.util.ArrayList;

public class AppTest extends TestCase {

    public void testListSize() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Ling");
        list.add("Johnson");
        list.add("Zarnecki");
        list.add("Jones");
        list.add("Jones");
        list.add("Swift");
        list.add("Xiong");

        assertEquals(7, App.listSize(list));
    }
}