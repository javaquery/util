package com.javaquery.util.iface;

import com.javaquery.util.io.JFile;

import java.io.IOException;

/**
 * @author vicky.thakor
 * @since 1.2.1
 */
public interface Writer<T> {
    /**
     * @param data - data to write
     * @param file - file to write
     * @throws IOException exception
     */
    void write(T data, JFile file) throws IOException;
}
