package com.javaquery.util.number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author javaquery
 * @since 1.2.5
 */
public class TestNumbers {

    @Test
    public void test_roundDecimal(){
        Double number = 10.123456789;
        Assertions.assertEquals(10.12, Numbers.roundDecimal(number, 2));
        Assertions.assertEquals(10.1235, Numbers.roundDecimal(number, 4));
        Assertions.assertEquals(10.58, Numbers.roundDecimal(10.576D, 2));
    }
}
