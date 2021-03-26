package com.javaquery.util.io;

import org.junit.jupiter.api.Test;

/**
 * @author vicky.thakor
 * @since 1.0.4
 */
public class TestConsole {

    @Test
    public void test_log(){
        Console.log("Hello World!");
    }

    @Test
    public void test_error(){
        Console.error("Hello World!");
    }
}
