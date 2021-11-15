package com.javaquery.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author vicky.thakor
 * @since 1.0
 */
public class TestObjects {

  @Test
  public void test_isNull() {
    String str = null;
    Assertions.assertTrue(Objects.isNull(str));
  }

  @Test
  public void test_isNull_ExecutableFunction() {
    String str = null;
    Objects.isNull(str, ()-> Assertions.assertTrue(true));
  }

  @Test
  public void test_NonNull() {
    String str = "str";
    Assertions.assertTrue(Objects.nonNull(str));
  }

  @Test
  public void test_NonNull_ExecutableFunction() {
    String str = "str";
    Objects.nonNull(str, ()-> Assertions.assertTrue(true));
  }

  @Test
  public void test_equals() {
    Assertions.assertTrue(Objects.equals("a", "a"));
    Assertions.assertTrue(Objects.equals(10, 10));
    Assertions.assertFalse(Objects.equals(10, 20));
  }
}
