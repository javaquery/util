package com.javaquery.util.collection;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author javaquery
 * @since 2025-01-20
 */
public class TestJList {

    @Test
    public void test_of(){
        List<String> list = JList.of("a", "b", "c");
        assertEquals(3, list.size());
        assertTrue(list.contains("a"));
        assertTrue(list.contains("b"));
        assertTrue(list.contains("c"));
    }
}
