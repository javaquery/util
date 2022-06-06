package com.javaquery.util.iface;

import com.javaquery.util.io.JFile;

import java.io.IOException;

/**
 * @author vicky.thakor
 * @since 1.2.1
 */
public interface Reader<T> {
    /**
     * @param file - file to read
     * @return return the result
     * @throws IOException exception
     */
    T read(JFile file) throws IOException;
}
