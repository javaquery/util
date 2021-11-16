# JavaQuery Util Library

Welcome to the JavaQuery util library

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.javaquery/util/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.javaquery/util)

# Overview

Goal is to remove repeated boler plate utility code from your project. This library offers util classes of following
framework and objects.

- <b>Collections</b>: Provides wide range of operation you perform on collection (List, Set and Map) interfaces
  like <code>nullOrEmpty(Collection)</code>, <code>nonNullNonEmpty(Collection)</code>, <code>batches(List<T> source, int
  batchSize)</code>, etc...
- <b>Files</b>: Provides wide range of operation you perform on <code>java.io.File</code> like <code>createNewFile(T
  file)</code>, <code>writeToFile(T file, String data)</code>, <code>appendToFile(T file, String data, boolean
  appendNewLine)</code>, etc...
- <b>Console</b>: Provides replacement of <code>System.out.println()</code> using .log() and <code>
  System.err.println()</code> using error().
- <b>JFile</b>: Extends <code>java.io.File</code> and provide some extra function on file like <code>getExtension</code>
  , <code>read</code>, <code>write</code>.
- <b>JSONObject</b>: Uses <code>org.json.JSONObject</code> and provides facility to optValue at any path in JSONObject,
  like <code>items.item[0].batters.batter[2].available</code>
- <b>Strings</b>: Provides wide range of operation you perform on <code>java.lang.String</code> like <code>nullOrEmpty(
  String str)</code>, <code>joinStrings(String separator, String... strings)</code>, <code>
  removeNotSupportedASCIICharacters(String str)</code>, etc...
- <b>DatePattern</b>: Provides wide range of Date patterns commonly used worldwide like <code>yyyyMMddHHmmss</code>
  , <code>yyyy-MM-dd HH:mm:ss'Z'</code>, <code>yyyy-MM-dd'T'HH:mm:ss.SSSSSSS-HH:MM</code>, etc...
- <b>DateRange</b>: Class can be used to store start-date and end-date.
- <b>Dates</b>: Provides wide range of operation you perform on <code>java.util.Date</code> like <code>addInDate(Date
  date, int type, int amount)</code>, <code>parse(String date, DatePattern datePattern, TimeZone timeZone)</code>
  , <code>format(Date date, DatePattern datePattern, TimeZone timeZone)</code>, etc...
- <b>Assert</b>: Provides wide range of operation for Assertions like <code>nonNull(Object object, Supplier<T>
  exceptionSupplier)</code>, <code>isTrue(boolean expression, Supplier<T> exceptionSupplier)</code>, <code>
  nonNullNonEmpty(Collection<?> collection, Supplier<T> exceptionSupplier)</code>, etc...
- <b>Objects</b>: Provides wide range of operation on <code>java.lang.Object</code> like <code>isNull(Object obj)</code>
  , <code>nonNull(Object obj)</code>.
- <b>Regex</b>: Provides wide range of operation using regular expression like <code>isNumber(String value)</code>
  , <code>isAlphaNumeric(String value)</code>, <code>isValidEmail(String value)</code>.
- <b>UniqueIdGenerator</b>: Generate unique time based random alphanumeric string like Firebase keys.
- <b>LogBuilder</b>: Help you to build Map for Markers used in logging with optional execution time of code or function.

# Maven

```
<dependency>
  <groupId>com.javaquery</groupId>
  <artifactId>util</artifactId>
  <version>1.0.6.1</version>
</dependency>
``` 

# Gradle

```
implementation 'com.javaquery:util:1.0.6.1'
```
