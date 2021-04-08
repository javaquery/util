package com.javaquery.util.io;

import com.javaquery.util.Assert;
import com.javaquery.util.collection.Collections;
import com.javaquery.util.string.Strings;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author vicky.thakor
 * @since 1.0.3
 */
public final class JFile extends File {

  private final Map<String, String> attributes;

  public JFile(String pathname) {
    super(pathname);
    attributes = new HashMap<>();
  }

  /** @return file extension */
  public String getExtension() {
    String name = getName();
    if (Strings.nonNullNonEmpty(name)) {
      int lastIndexOfDot = name.lastIndexOf(".");
      if (lastIndexOfDot > 0) {
        return name.substring(lastIndexOfDot + 1);
      }
    }
    return "";
  }

  /**
   * @param name a name to change for current file
   * @return renamed file object if and only if the renaming succeeded; <code>null</code> otherwise
   * @throws SecurityException If a security manager exists and its <code>{@link
   *          java.lang.SecurityManager#checkWrite(java.lang.String)}</code> method denies write
   *     access to either the old or new pathnames
   * @throws NullPointerException If parameter <code>dest</code> is <code>null</code>
   */
  public final JFile rename(String name) {
    Assert.nonNull(name, NullPointerException::new);
    if (exists()) {
      boolean result = renameTo(new File(getParent() + File.separatorChar + name));
      if (result) {
        return new JFile(getParent() + File.separatorChar + name);
      }
    }
    return null;
  }

  /** @return String content of this file. */
  public final String read() {
    return Files.readFromFile(this);
  }

  /** @param data data to write to this file */
  public final void write(String data) {
    Files.writeToFile(this, data);
  }

  /**
   * @param data to append to this file
   * @param appendNewLine <code>true</code> to append new line at the end of data otherwise <code>
   *     false</code>
   */
  public final void append(String data, boolean appendNewLine) {
    Files.appendToFile(this, data, appendNewLine);
  }

  /** @return attributes of file */
  public final Map<String, String> getAttributes() {
    return attributes;
  }

  /**
   * @param key a key of attribute
   * @param value a value of attribute
   */
  public final void addAttribute(String key, String value) {
    attributes.put(key, value);
  }

  /** @param attributes add attributes map to file */
  public final void addAllAttribute(Map<String, String> attributes) {
    if (Collections.nonNullNonEmpty(attributes)) {
      this.attributes.putAll(attributes);
    }
  }

  /**
   * @param key a key to find attribute
   * @param defaultValue default value in case attribute not found
   * @return attribute value if found otherwise defaultValue
   */
  public final String optAttribute(String key, String defaultValue) {
    return attributes.getOrDefault(key, defaultValue);
  }
}
