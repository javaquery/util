package com.javaquery.util.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author vicky.thakor
 * @since 1.0.7
 */
public class TestParameterAwareException {

    @Test
    public void test_constructor(){
        ParameterAwareException parameterAwareException = new ParameterAwareException("ERR:1", new Exception(), "a", 1);
        Assertions.assertTrue(parameterAwareException.getMessage().contains("1"));
        Assertions.assertEquals("ERR:1", parameterAwareException.getErrorCode());

        ParameterAwareException parameterAwareExceptionWithMessage = new ParameterAwareException("ERR:2", "Exception Message", new Exception(), "a", 1);
        Assertions.assertTrue(parameterAwareExceptionWithMessage.getMessage().contains("Exception Message"));
        Assertions.assertEquals("ERR:2", parameterAwareExceptionWithMessage.getErrorCode());
        Assertions.assertEquals(1, parameterAwareException.getParameters()[1]);

        ParameterAwareException parameterAwareException2 = new ParameterAwareException("ERR:3", "Exception Message", 2);
        Assertions.assertTrue(parameterAwareException2.getMessage().contains("2"));
        Assertions.assertEquals("ERR:3", parameterAwareException2.getErrorCode());
        Assertions.assertEquals(2, parameterAwareException2.getParameters()[0]);
    }
}
