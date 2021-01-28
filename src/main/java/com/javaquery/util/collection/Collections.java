package com.javaquery.util.collection;

import com.javaquery.util.Objects;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author vicky.thakor
 * @since 1.0
 */
public final class Collections {

    private Collections(){}

    /**
     * Returns {@code true} if the provided Collection [List, Set] is {@code null} or empty otherwise
     * returns {@code false}.
     *
     * @param collection a Collection [List, Set] to be checked against {@code null} or empty
     * @return {@code true} if the provided Collection [List, Set] is {@code null} or empty
     * otherwise {@code false}
     */
    public static boolean nullOrEmpty(Collection collection) {
        return Objects.isNull(collection) || collection.isEmpty();
    }

    /**
     * Returns {@code true} if the provided Collection [List, Set] is non-{@code null} and non-empty otherwise
     * returns {@code false}.
     *
     * @param collection a Collection [List, Set] to be checked against non-{@code null} and non-empty
     * @return {@code true} if the provided Collection [List, Set] is non-{@code null} and non-empty
     * otherwise {@code false}
     */
    public static boolean nonNullNonEmpty(Collection collection) {
        return Objects.nonNull(collection) && !collection.isEmpty();
    }

    /**
     * Returns {@code true} if the provided Map is {@code null} and empty otherwise
     * returns {@code false}.
     *
     * @param map a Map to be checked against {@code null} or empty
     * @return {@code true} if the provided Map is {@code null} and empty otherwise
     * * returns {@code false}
     */
    public static boolean nullOrEmpty(Map map) {
        return Objects.isNull(map) || map.isEmpty();
    }

    /**
     * Returns {@code true} if the provided Map is non-{@code null} and non-empty otherwise
     * returns {@code false}.
     *
     * @param map a Map to be checked against non-{@code null} and non-empty
     * @return {@code true} if the provided Map is non-{@code null} and non-empty
     * otherwise {@code false}
     */
    public static boolean nonNullNonEmpty(Map map) {
        return Objects.nonNull(map) && !map.isEmpty();
    }

    /**
     * Returns stream of batched List from original List by given batch size.
     *
     * @param source    a List to be batched
     * @param batchSize size of batch you want
     * @return Returns stream of batched List from original List by given batch size.
     * <p>
     * reference: http://stackoverflow.com/questions/12026885/common-util-to-break-a-list-into-batch
     */
    public static <T> Stream<List<T>> batches(List<T> source, int batchSize) {
        if (Objects.isNull(source))
            throw new IllegalArgumentException("source can not be null");

        int size = source.size();
        if (batchSize < 0) {
            throw new IllegalArgumentException("batchSize can not be negative");
        } else if (batchSize == 0 && size != 0) {
            return Stream.of(source);
        }
        if (size <= 0)
            return Stream.empty();
        int fullChunks = (size - 1) / batchSize;
        return IntStream
                .range(0, fullChunks + 1)
                .mapToObj(n -> source.subList(n * batchSize, n == fullChunks ? size : (n + 1) * batchSize));
    }
}
