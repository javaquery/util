package com.javaquery.util.collection;

import java.util.Arrays;
import java.util.List;

/**
 * @author javaquery
 * @since 1.2.7
 */
public class JList {

    @SafeVarargs
    public static <E> List<E> of(E... elements) {
       return Arrays.asList(elements);
    }
}
