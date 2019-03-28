
package com.aor.numbers;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositiveFilterTest {

    PositiveFilter test = new PositiveFilter();

    @Test
    public void PositiveTest1(){

        assertFalse(test.accept(-10));
    }

    @Test
    public void PositiveTest2(){

        assertTrue(test.accept(15));
    }

    @Test
    public void PositiveTest3(){

        assertTrue(test.accept(0));
    }

    @Test
    public void PositiveTest4(){

        assertFalse(test.accept(-45));
    }

    @Test
    public void PositiveTest5(){

        assertTrue(test.accept(24));
    }

}