package com.javaquery.util.json;

import com.javaquery.util.time.DatePattern;
import com.javaquery.util.time.Dates;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * @author vicky.thakor
 * @since 1.4
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestJSONObject {
  private static final String STRING_JSON_OBJECT =
      "{\"author\":\"vicky\",\"created\":\"2021-01-20 10:00:10\",\"items\":{\"item\":[{\"ppu\":0.55,\"batters\":{\"batter\":[{\"available\":true,\"id\":\"1001\",\"type\":\"Regular\"},{\"available\":false,\"id\":\"1002\",\"type\":\"Chocolate\"},{\"id\":\"1003\",\"type\":\"Blueberry\"},{\"id\":\"1004\",\"type\":\"Devil's Food\"}]},\"name\":\"Cake\",\"id\":\"0001\",\"type\":\"donut\",\"topping\":[{\"id\":\"5001\",\"type\":\"None\"},{\"id\":\"5002\",\"type\":\"Glazed\"},{\"id\":\"5005\",\"type\":\"Sugar\",\"kg\":652398},{\"id\":\"5007\",\"type\":\"Powdered Sugar\",\"kg\":875},{\"id\":\"5006\",\"type\":\"Chocolate with Sprinkles\"},{\"id\":\"5003\",\"type\":\"Chocolate\"},{\"id\":\"5004\",\"type\":\"Maple\"}]}]}}";
  private static final JSONObject JSONOBJECT = new JSONObject(STRING_JSON_OBJECT);

  @Test
  public void test_optBoolean() {
    Assertions.assertTrue(JSONOBJECT.optBoolean("items.item[0].batters.batter[0].available"));
    Assertions.assertTrue(JSONOBJECT.optBoolean("items.item[0].batters.batter[2].available", true));
  }

  @Test
  public void test_optBigDecimal() {
    Assertions.assertEquals(
        new BigDecimal(652398),
        JSONOBJECT.optBigDecimal("items.item[0].topping[2].kg", new BigDecimal(0)));
    Assertions.assertEquals(
        new BigDecimal(-1),
        JSONOBJECT.optBigDecimal("items.item[0].topping[2].gm", new BigDecimal(-1)));
  }

  @Test
  public void test_optBigInteger() {
    Assertions.assertEquals(
        BigInteger.valueOf(652398L),
        JSONOBJECT.optBigInteger("items.item[0].topping[2].kg", BigInteger.valueOf(0L)));
    Assertions.assertEquals(
        BigInteger.valueOf(-1),
        JSONOBJECT.optBigInteger("items.item[0].topping[2].gm", BigInteger.valueOf(-1L)));
  }

  @Test
  public void test_optDouble() {
    Assertions.assertEquals(875d, JSONOBJECT.optDouble("items.item[0].topping[3].kg"));
    Assertions.assertEquals(-1d, JSONOBJECT.optDouble("items.item[0].topping[2].gm", -1));
  }

  @Test
  public void test_optDate() {
    Date date = Dates.parse("2021-01-20 10:00:10", DatePattern.Y_M_D__HMS);
    Assertions.assertNotNull(JSONOBJECT.optDate("item.created", DatePattern.Y_M_D__HMS));
    Assertions.assertEquals(date, JSONOBJECT.optDate("created", DatePattern.Y_M_D__HMS));
    Assertions.assertEquals(
        date, JSONOBJECT.optDate("items.created", DatePattern.Y_M_D__HMS, date));
  }

  @Test
  public void test_optEnum() {
    Assertions.assertEquals(
        TestJSONEnum.Regular,
        JSONOBJECT.optEnum(TestJSONEnum.class, "items.item[0].batters.batter[0].type"));
    Assertions.assertEquals(
        TestJSONEnum.Chocolate,
        JSONOBJECT.optEnum(
            TestJSONEnum.class, "items.item[0].batters.batter[2].type", TestJSONEnum.Chocolate));
  }

  @Test
  public void test_optFloat() {
    Assertions.assertEquals(875f, JSONOBJECT.optFloat("items.item[0].topping[3].kg"));
    Assertions.assertEquals(-1f, JSONOBJECT.optFloat("items.item[0].topping[2].gm", -1));
  }

  @Test
  public void test_optInt() {
    Assertions.assertEquals(875, JSONOBJECT.optInt("items.item[0].topping[3].kg"));
    Assertions.assertEquals(-1, JSONOBJECT.optInt("items.item[0].topping[2].gm", -1));
  }

  @Test
  public void test_optLong() {
    Assertions.assertEquals(875L, JSONOBJECT.optLong("items.item[0].topping[3].kg"));
    Assertions.assertEquals(-1L, JSONOBJECT.optLong("items.item[0].topping[2].gm", -1));
  }

  @Test
  public void test_optNumber() {
    Assertions.assertEquals(875, JSONOBJECT.optNumber("items.item[0].topping[3].kg"));
    Assertions.assertEquals(-1, JSONOBJECT.optNumber("items.item[0].topping[2].gm", -1));
  }

  @Test
  public void test_optString() {
    Assertions.assertEquals("donut", JSONOBJECT.optString("items.item[0].type"));
    Assertions.assertEquals("test", JSONOBJECT.optString("items.item[0].topping[1].value", "test"));
    Assertions.assertEquals("vicky", JSONOBJECT.optString("author"));
  }

  @Test
  public void test_optJSONObject() {
    org.json.JSONObject jsonObject = JSONOBJECT.optJSONObject("items.item[0].batters.batter[0]");
    Assertions.assertEquals("Regular", jsonObject.optString("type"));
  }

  @Test
  public void test_optJSONObject_1() {
    org.json.JSONObject jsonObject = JSONOBJECT.optJSONObject("items.dummy[0].batters.batter[0]");
    Assertions.assertNull(jsonObject);
  }

  @Test
  public void test_optJSONObject_2() {
    org.json.JSONObject jsonObject = JSONOBJECT.optJSONObject("items.item.batters.batter[0]");
    Assertions.assertNull(jsonObject);
  }

  @Test
  public void test_optJSONArray() {
    org.json.JSONArray jsonArray = JSONOBJECT.optJSONArray("items.item[0].batters.batter");
    Assertions.assertEquals(4, jsonArray.length());
  }

  @Test
  public void test_toString() {
    Assertions.assertEquals(STRING_JSON_OBJECT, JSONOBJECT.toString());
  }

  @AfterAll
  public void test_flush() {
    JSONOBJECT.flush();
  }
}
