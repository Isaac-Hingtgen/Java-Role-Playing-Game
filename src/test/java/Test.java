package test.java;

import main.java.ser316.rpg.Start;

import static org.junit.Assert.*;

public class Test {

    Start start = null;
    @org.junit.Before
    public void setUp() throws Exception {
        start = new Start();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void foo() {
        int num = 4;
        assertEquals(num, start.foo(num));
    }
}