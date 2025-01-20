package com.javaquery.util.collection;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author javaquery
 * @since 2025-01-20
 */
public class TestJSet {

    @Test
    public void test_of(){
        Set<String> set = JSet.of("a", "b", "c");
        assertEquals(3, set.size());
        assertTrue(set.contains("a"));
        assertTrue(set.contains("b"));
        assertTrue(set.contains("c"));
    }
}
