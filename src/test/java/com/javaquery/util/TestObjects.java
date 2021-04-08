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
    Assertions.assertTrue(Objects.isNull(null));
  }

  @Test
  public void test_NonNull() {
    Assertions.assertTrue(Objects.nonNull(new Object()));
  }

  @Test
  public void test_equals() {
    Assertions.assertTrue(Objects.equals("a", "a"));
    Assertions.assertTrue(Objects.equals(10, 10));
    Assertions.assertFalse(Objects.equals(10, 20));
  }
}
