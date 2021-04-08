package com.javaquery.util.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @author vicky.thakor
 * @since 1.0
 */
public class TestCollections {

  private static final List<String> EMPTY_LIST = new ArrayList<>(1);
  private static final List<String> NULL_LIST = null;
  private static final Set<String> EMPTY_SET = new HashSet<>(1);
  private static final Map<String, String> EMPTY_MAP = new HashMap<>(1);
  private static final Map<String, String> NULL_MAP = null;

  @Test
  public void test_nullOrEmpty() {
    Assertions.assertTrue(Collections.nullOrEmpty(NULL_LIST));
    Assertions.assertTrue(Collections.nullOrEmpty(EMPTY_LIST));
    Assertions.assertFalse(Collections.nullOrEmpty(java.util.Collections.singletonList("A")));
    Assertions.assertTrue(Collections.nullOrEmpty(NULL_MAP));
    Assertions.assertTrue(Collections.nullOrEmpty(EMPTY_MAP));
  }

  @Test
  public void test_nullOrEmpty_2() {
    Map<String, String> map = new HashMap<>(1);
    map.put("Hello", "World");
    Assertions.assertFalse(Collections.nullOrEmpty(map));
  }

  @Test
  public void test_nonNullNonEmpty() {
    Assertions.assertTrue(Collections.nonNullNonEmpty(java.util.Collections.singletonList("A")));
    Assertions.assertFalse(Collections.nonNullNonEmpty(NULL_LIST));
    Assertions.assertFalse(Collections.nonNullNonEmpty(EMPTY_SET));
  }

  @Test
  public void test_nonNullNonEmptyMap() {
    Map<String, String> map = new HashMap<>(1);
    map.put("Hello", "World");
    Assertions.assertTrue(Collections.nonNullNonEmpty(map));

    Assertions.assertFalse(Collections.nonNullNonEmpty(NULL_MAP));
    Assertions.assertFalse(Collections.nonNullNonEmpty(EMPTY_MAP));
  }

  @Test
  public void test_batches_1() {
    List<String> listABCD = new ArrayList<>();
    listABCD.add("A");
    listABCD.add("B");
    listABCD.add("C");
    listABCD.add("D");
    listABCD.add("E");

    AtomicInteger batchCounter = new AtomicInteger(0);
    List<String> result = new ArrayList<>(5);
    Collections.batches(listABCD, 2)
        .forEach(
            listOfString -> {
              batchCounter.getAndIncrement();
              result.addAll(listOfString);
            });
    Assertions.assertEquals(3, batchCounter.get());
    Assertions.assertEquals(5, result.size());
    Assertions.assertTrue(result.contains("E"));
  }

  @Test
  public void test_batches_2() {
    List<String> listABCD = new ArrayList<>();
    listABCD.add("A");
    listABCD.add("B");

    AtomicInteger batchCounter = new AtomicInteger(0);
    List<String> result = new ArrayList<>(2);
    Collections.batches(listABCD, 0)
        .forEach(
            listOfString -> {
              batchCounter.getAndIncrement();
              result.addAll(listOfString);
            });
    Assertions.assertEquals(1, batchCounter.get());
    Assertions.assertEquals(2, result.size());
    Assertions.assertTrue(result.contains("A"));
  }

  @Test
  public void test_batches_3() {
    Stream<List<String>> stringStream = Collections.batches(EMPTY_LIST, 1);
    Assertions.assertEquals(0, stringStream.count());

    Assertions.assertThrows(IllegalArgumentException.class, () -> Collections.batches(null, 2));
    Assertions.assertThrows(
        IllegalArgumentException.class, () -> Collections.batches(EMPTY_LIST, -2));
  }

  @Test
  public void test_isCollectionEqual() {
    List<String> listOne = new ArrayList<>();
    listOne.add("apple");

    List<String> listTwo = new ArrayList<>();
    listTwo.add("apple");

    Assertions.assertTrue(Collections.isCollectionEqual(listOne, listTwo));
  }

  @Test
  public void test_isCollectionEqual_1() {
    Set<String> setOne = new HashSet<>();
    setOne.add("apple");
    setOne.add("orange");

    Set<String> setTwo = new HashSet<>();
    setTwo.add("apple");

    Assertions.assertFalse(Collections.isCollectionEqual(setOne, setTwo));
  }

  @Test
  public void test_isCollectionEqual_2() {
    Set<String> setOne = new HashSet<>();
    setOne.add("orange");

    Set<String> setTwo = new HashSet<>();
    setTwo.add("apple");

    Assertions.assertFalse(Collections.isCollectionEqual(setOne, setTwo));
  }

  @Test
  public void test_isCollectionEqual_3() {
    List<String> setOne = new ArrayList<>();
    setOne.add("orange");
    setOne.add("orange");

    Set<String> setTwo = new HashSet<>();
    setTwo.add(null);
    setTwo.add("apple");

    Assertions.assertFalse(Collections.isCollectionEqual(setOne, setTwo));
  }
}
