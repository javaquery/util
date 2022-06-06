package com.javaquery.util.iface;

/**
 * @author vicky.thakor
 * @since 1.2.1
 */
public interface Processor<T, R> {

    /**
     * Process T object and return the value.
     * @param t - input object
     * @return return value
     */
    R process(T t);
}
