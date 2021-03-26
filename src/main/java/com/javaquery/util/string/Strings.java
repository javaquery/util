package com.javaquery.util.string;

import com.javaquery.util.Objects;
import com.javaquery.util.collection.Collections;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author vicky.thakor
 * @since 1.0
 */
public final class Strings {

    public static final String EMPTY_STRING = "";
    private static final String UNSUPPORTED_ASCII_PATTERN = "[^\\x20-\\x7e]";
    private static final String UNSUPPORTED_UNICODE_PATTERN = "[\\uD83C-\\uDBFF\\uDC00-\\uDFFF]+";

    private Strings() {
    }

    /**
     * Returns {@code true} if the provided String is {@code null} or empty otherwise
     * returns {@code false}.
     *
     * @param str a String to be checked against {@code null} or empty
     * @return {@code true} if the provided String is {@code null} or empty
     * otherwise {@code false}
     */
    public static boolean nullOrEmpty(String str) {
        return Objects.isNull(str) || str.trim().isEmpty();
    }

    /**
     * Returns {@code true} if the provided String is non-{@code null} and non-empty otherwise
     * returns {@code false}.
     *
     * @param str a String to be checked against non-{@code null} and non-empty
     * @return {@code true} if the provided String is non-{@code null} and non-empty
     * otherwise {@code false}
     */
    public static boolean nonNullNonEmpty(String str) {
        return Objects.nonNull(str) && !str.trim().isEmpty();
    }

    /**
     * Returns trimmed
     *
     * @param str a String to trim
     * @return trimmed String if provided String is non-{@code null} otherwise null
     */
    public static String trimString(String str) {
        return Objects.nonNull(str) ? str.trim() : null;
    }

    /**
     * Returns joined string with provided separator
     *
     * @param separator a String used for joining multiple Strings
     * @param strings   array of String to join
     * @return joined String
     */
    public static String joinStrings(String separator, String... strings) {
        if (Objects.nonNull(separator)) {
            StringJoiner stringJoiner = new StringJoiner(separator);
            if (Objects.nonNull(strings)) {
                for (String str : strings) {
                    if (nonNullNonEmpty(str)) {
                        stringJoiner.add(str);
                    }
                }
            }
            return stringJoiner.toString();
        }
        return null;
    }

    /**
     * Returns joined string with provided separator
     *
     * @param separator a String used for joining multiple Strings
     * @param strings   array of String to join
     * @return joined String
     */
    public static String joinStringList(String separator, List<String> strings) {
        if (Objects.nonNull(separator)) {
            StringJoiner stringJoiner = new StringJoiner(separator);
            if (Collections.nonNullNonEmpty(strings)) {
                for (String str : strings) {
                    if (nonNullNonEmpty(str)) {
                        stringJoiner.add(str);
                    }
                }
            }
            return stringJoiner.toString();
        }
        return null;
    }

    /**
     * Returns {@code true} if the provided String is equalsIgnoreCase to [true, yes, y, 1] otherwise
     * returns {@code false}.
     *
     * @param str a String to be checked against equalsIgnoreCase [true, yes, y, 1]
     * @return {@code true} if the provided String is equalsIgnoreCase to [true, yes, y, 1]
     * otherwise {@code false}
     */
    public static boolean optBooleanFromString(String str) {
        return "true".equalsIgnoreCase(str) || "yes".equalsIgnoreCase(str) || "y".equalsIgnoreCase(str)
                || "1".equalsIgnoreCase(str);
    }

    /**
     * Returns String after removing not supported ASCII characters
     *
     * @param str a String to be checked for non ASCII Characters
     * @return Returns String after removing non ASCII characters
     * <p>
     * reference: https://stackoverflow.com/questions/10574289/remove-non-ascii-characters-from-string-in-java
     */
    public static String removeNotSupportedASCIICharacters(String str) {
        if (nonNullNonEmpty(str)) {
            return str.replaceAll(UNSUPPORTED_ASCII_PATTERN, "");
        }
        return null;
    }

    /**
     * Returns String after removing not supported Unicode Characters
     *
     * @param str a String to be checked for not supported Unicode Characters
     * @return Returns String after removing not supported Unicode Characters
     * <p>
     * reference: https://stackoverflow.com/questions/24840667/what-is-the-regex-to-extract-all-the-emojis-from-a-string
     */
    public static String removeNotSupportedUnicodeCharacters(String str) {
        if (nonNullNonEmpty(str)) {
            return str.replaceAll(UNSUPPORTED_UNICODE_PATTERN, "");
        }
        return null;
    }
}
