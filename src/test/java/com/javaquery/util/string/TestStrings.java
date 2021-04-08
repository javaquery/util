package com.javaquery.util.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author vicky.thakor
 * @since 1.0
 */
public class TestStrings {

  private static final String HELLO = "Hello World!";

  @Test
  public void test_nullOrEmpty() {
    Assertions.assertTrue(Strings.nullOrEmpty(null));
    Assertions.assertTrue(Strings.nullOrEmpty(""));
    Assertions.assertFalse(Strings.nullOrEmpty(HELLO));
  }

  @Test
  public void test_nonNullNonEmpty() {
    Assertions.assertTrue(Strings.nonNullNonEmpty(HELLO));
    Assertions.assertFalse(Strings.nonNullNonEmpty(null));
    Assertions.assertFalse(Strings.nonNullNonEmpty(""));
  }

  @Test
  public void test_trimString() {
    String str = " Hello World! ";
    Assertions.assertEquals(HELLO, Strings.trimString(str));
  }

  @Test
  public void test_joinStrings() {
    String result = "Hello,World,!";
    Assertions.assertEquals(result, Strings.joinStrings(",", "Hello", "World", "!"));

    Assertions.assertNull(Strings.joinStrings(null, "Hello", "World", "!"));
    Assertions.assertEquals("", Strings.joinStrings(","));
  }

  @Test
  public void test_joinStringList() {
    String result = "Hello,World,!";
    Assertions.assertEquals(
        result, Strings.joinStringList(",", Arrays.asList("Hello", "World", "!")));

    Assertions.assertNull(Strings.joinStringList(null, Arrays.asList("Hello", "World", "!")));
    Assertions.assertEquals("", Strings.joinStringList(",", null));
  }

  @Test
  public void test_optBooleanFromString() {
    Assertions.assertTrue(Strings.optBooleanFromString("TRUE"));
    Assertions.assertTrue(Strings.optBooleanFromString("yes"));
    Assertions.assertFalse(Strings.optBooleanFromString(HELLO));
  }

  @Test
  public void test_removeNotSupportedASCIICharacters() {
    String str = "�ttrigeSomerzischeruchtanb";
    Assertions.assertEquals(
        "ttrigeSomerzischeruchtanb", Strings.removeNotSupportedASCIICharacters(str));

    Assertions.assertNull(Strings.removeNotSupportedASCIICharacters(null));
  }

  @Test
  public void test_removeNotSupportedUnicodeCharacters() {
    String str = "Thats a nice joke\uD83D\uDE06\uD83D\uDE06\uD83D\uDE06 \uD83D\uDE1B";
    Assertions.assertEquals("Thats a nice joke ", Strings.removeNotSupportedUnicodeCharacters(str));

    Assertions.assertNull(null, Strings.removeNotSupportedUnicodeCharacters(null));
  }
}
