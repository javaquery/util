package com.javaquery.util.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author vicky.thakor
 * @since 1.2.0
 */
public class TestJHashMap {

    @Test
    public void test_optInt(){
        JHashMap<String, String> jHashMap = new JHashMap<>();
        jHashMap.put("a", "1");
        jHashMap.put("b", "a");
        Assertions.assertEquals(1, jHashMap.optInt("a"));
        Assertions.assertEquals(0, jHashMap.optInt("b"));

        JHashMap<String, Long> jHashMap2 = new JHashMap<>();
        jHashMap2.put("a", 1L);
        Assertions.assertEquals(1, jHashMap2.optInt("a", 10));
        Assertions.assertEquals(20, jHashMap2.optInt("b", 20));
    }

    @Test
    public void test_optLong(){
        JHashMap<String, String> jHashMap = new JHashMap<>();
        jHashMap.put("a", "1");
        jHashMap.put("b", "a");
        Assertions.assertEquals(1L, jHashMap.optLong("a"));
        Assertions.assertEquals(0L, jHashMap.optLong("b"));

        JHashMap<String, Integer> jHashMap2 = new JHashMap<>();
        jHashMap2.put("a", 1);
        Assertions.assertEquals(1, jHashMap2.optLong("a", 10L));
        Assertions.assertEquals(20, jHashMap2.optLong("b", 20L));
    }

    @Test
    public void test_optDouble(){
        JHashMap<String, String> jHashMap = new JHashMap<>();
        jHashMap.put("a", "1");
        jHashMap.put("b", "a");
        Assertions.assertEquals(1D, jHashMap.optDouble("a"));
        Assertions.assertEquals(0D, jHashMap.optDouble("b"));

        JHashMap<String, Integer> jHashMap2 = new JHashMap<>();
        jHashMap2.put("a", 1);
        Assertions.assertEquals(1D, jHashMap2.optDouble("a", 10D));
        Assertions.assertEquals(20D, jHashMap2.optDouble("b", 20D));
    }
}
