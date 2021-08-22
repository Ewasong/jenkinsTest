package top.sorie.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoApplicationTests {

    @Test
    public void testAdd() {
        double result = 10 + 50;
        assertEquals(60, result, 0);
    }
}
