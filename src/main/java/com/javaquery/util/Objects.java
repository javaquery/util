package com.javaquery.util;

/**
 * @author vicky.thakor
 * @since 1.0
 */
public final class Objects {

  private Objects() {}

  /**
   * Returns {@code true} if the provided reference is {@code null} otherwise returns {@code false}.
   *
   * @param obj a reference to be checked against {@code null}
   * @return {@code true} if the provided reference is {@code null} otherwise {@code false}
   */
  public static boolean isNull(Object obj) {
    return obj == null;
  }

  /**
   * Returns {@code true} if the provided reference is non-{@code null} otherwise returns {@code
   * false}.
   *
   * @param obj a reference to be checked against {@code null}
   * @return {@code true} if the provided reference is non-{@code null} otherwise {@code false}
   */
  public static boolean nonNull(Object obj) {
    return obj != null;
  }

  /**
   * Returns {@code true} if the arguments are equal to each other and {@code false} otherwise.
   * Consequently, if both arguments are {@code null}, {@code true} is returned and if exactly one
   * argument is {@code null}, {@code false} is returned. Otherwise, equality is determined by using
   * the {@link Object#equals equals} method of the first argument.
   *
   * @param a an object
   * @param b an object to be compared with {@code a} for equality
   * @return {@code true} if the arguments are equal to each other and {@code false} otherwise
   * @see Object#equals(Object)
   */
  public static boolean equals(Object a, Object b) {
    return (a == b) || (a != null && a.equals(b));
  }
}
