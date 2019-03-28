package com.aor.numbers;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DivisibleByTest {
    DivisibleByFilter test = new DivisibleByFilter(5);

    @Test
    public void DivisibleTest1(){

        assertTrue(test.accept(-10));
    }

    @Test
    public void DivisibleTest2(){

        assertTrue(test.accept(15));
    }

    @Test
    public void DivisibleTest3(){

        assertTrue(test.accept(0));
    }

    @Test
    public void DivisibleTest4(){

        assertTrue(test.accept(-45));
    }

    @Test
    public void DivisibleTest5(){

        assertFalse(test.accept(24));
    }
}
