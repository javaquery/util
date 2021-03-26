package com.javaquery.util.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author vicky.thakor
 * @since 1.4
 */
public final class Console {

    private static final Logger LOGGER = LoggerFactory.getLogger(Console.class);

    /**
     * Print object to output stream. Internally it uses <code>System.out.println(obj);</code>
     * @param object object to print on console
     */
    public static void log(Object object){
        System.out.println(object);
    }

    /**
     * Print object to output stream. Internally it uses <code>System.err.println(obj);</code>
     * @param object object to print on console
     */
    public static void error(Object object){
        System.err.println(object);
    }

    /**
     * Read <code>String</code> from console.
     * @return String input provided in console
     */
    public static String read(){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            return reader.readLine();
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }
}
