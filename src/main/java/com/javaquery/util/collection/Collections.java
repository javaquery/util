package com.javaquery.util.collection;

import com.javaquery.util.Assert;
import com.javaquery.util.Objects;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author vicky.thakor
 * @since 1.0
 */
public final class Collections {

    private Collections() {
    }

    /**
     * Returns {@code true} if the provided Collection [List, Set] is {@code null} or empty otherwise
     * returns {@code false}.
     *
     * @param collection a Collection [List, Set] to be checked against {@code null} or empty
     * @return {@code true} if the provided Collection [List, Set] is {@code null} or empty
     * otherwise {@code false}
     */
    public static boolean nullOrEmpty(Collection<?> collection) {
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
    public static boolean nonNullNonEmpty(Collection<?> collection) {
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
    public static boolean nullOrEmpty(Map<?, ?> map) {
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
    public static boolean nonNullNonEmpty(Map<?, ?> map) {
        return Objects.nonNull(map) && !map.isEmpty();
    }

    /**
     * Returns stream of batched List from original List by given batch size.
     *
     * @param source    a List to be batched
     * @param batchSize size of batch you want
     * @param <T> the type of List to be returned.
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

    /**
     * Note: Code imported from apache commons collection
     * <p>
     * Returns {@code true} iff the given {@link Collection}s contain
     * exactly the same elements with exactly the same cardinalities.
     * <p>
     * That is, iff the cardinality of <i>e</i> in <i>a</i> is
     * equal to the cardinality of <i>e</i> in <i>b</i>,
     * for each element <i>e</i> in <i>a</i> or <i>b</i>.
     * </p>
     *
     * @param collectionOne the first collection, must not be null
     * @param collectionTwo the second collection, must not be null
     * @return {@code true} iff the collections contain the same elements with the same cardinalities.
     * @throws NullPointerException if either collection is null
     * @since 1.0.3
     */
    public static boolean isCollectionEqual(final Collection<?> collectionOne, final Collection<?> collectionTwo) {
        Assert.nonNull(collectionOne, NullPointerException::new);
        Assert.nonNull(collectionTwo, NullPointerException::new);

        if (collectionOne.size() != collectionTwo.size()) {
            return false;
        }

        final CardinalityHelper<Object> helper = new CardinalityHelper<>(collectionOne, collectionTwo);
        if (helper.cardinalityA.size() != helper.cardinalityB.size()) {
            return false;
        }
        for (final Object obj : helper.cardinalityA.keySet()) {
            if (helper.freqA(obj) != helper.freqB(obj)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Note: Code imported from apache commons collection
     * Returns a {@link Map} mapping each unique element in the given
     * {@link Collection} to an {@link Integer} representing the number
     * of occurrences of that element in the {@link Collection}.
     * <p>
     * Only those elements present in the collection will appear as
     * keys in the map.
     * </p>
     *
     * @param <O>      the type of object in the returned {@link Map}. This is a super type of &lt;I&gt;.
     * @param iterable the collection to get the cardinality map for, must not be null
     * @return the populated cardinality map
     * @throws NullPointerException if coll is null
     * @since 1.0.3
     */
    public static <O> Map<O, Integer> getCardinalityMap(final Iterable<? extends O> iterable) {
        Assert.nonNull(iterable, NullPointerException::new);
        final Map<O, Integer> count = new HashMap<>();
        for (final O obj : iterable) {
            count.merge(obj, 1, Integer::sum);
        }
        return count;
    }

    /**
     * Note: Code imported from apache commons collection
     * Helper class to easily access cardinality properties of two collections.
     *
     * @param <O> the element type
     * @since 1.0.3
     */
    private static class CardinalityHelper<O> {

        /**
         * Contains the cardinality for each object in collection A.
         */
        final Map<O, Integer> cardinalityA;

        /**
         * Contains the cardinality for each object in collection B.
         */
        final Map<O, Integer> cardinalityB;

        /**
         * Create a new CardinalityHelper for two collections.
         *
         * @param a the first collection
         * @param b the second collection
         */
        CardinalityHelper(final Iterable<? extends O> a, final Iterable<? extends O> b) {
            cardinalityA = Collections.getCardinalityMap(a);
            cardinalityB = Collections.getCardinalityMap(b);
        }

        /**
         * Returns the maximum frequency of an object.
         *
         * @param obj the object
         * @return the maximum frequency of the object
         */
        public final int max(final Object obj) {
            return Math.max(freqA(obj), freqB(obj));
        }

        /**
         * Returns the minimum frequency of an object.
         *
         * @param obj the object
         * @return the minimum frequency of the object
         */
        public final int min(final Object obj) {
            return Math.min(freqA(obj), freqB(obj));
        }

        /**
         * Returns the frequency of this object in collection A.
         *
         * @param obj the object
         * @return the frequency of the object in collection A
         */
        public int freqA(final Object obj) {
            return getFreq(obj, cardinalityA);
        }

        /**
         * Returns the frequency of this object in collection B.
         *
         * @param obj the object
         * @return the frequency of the object in collection B
         */
        public int freqB(final Object obj) {
            return getFreq(obj, cardinalityB);
        }

        private int getFreq(final Object obj, final Map<?, Integer> freqMap) {
            final Integer count = freqMap.get(obj);
            if (count != null) {
                return count;
            }
            return 0;
        }
    }
}
