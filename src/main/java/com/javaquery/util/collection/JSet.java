package com.javaquery.util.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author javaquery
 * @since 1.2.7
 */
public class JSet {
    public static <E> Set<E> of(E... elements) {
        return new HashSet<>(Arrays.asList(elements));
    }
}
