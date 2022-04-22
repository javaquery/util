package com.javaquery.util.collection;

import com.javaquery.util.Regex;

import java.util.HashMap;

/**
 * @author vicky.thakor
 * @since 1.2.0
 */
public class JHashMap<K, V> extends HashMap<K, V> {

    /**
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or 0 if this map contains no mapping for the key
     */
    public Integer optInt(K key){
        return optInt(key, 0);
    }

    /**
     * @param key the key whose associated value is to be returned
     * @param defaultValue the default mapping of the key
     * @return the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key
     */
    @SuppressWarnings("unchecked")
    public Integer optInt(K key, Integer defaultValue){
        Object value = getOrDefault(key, (V) defaultValue);
        if(value instanceof Number){
            return ((Number) value).intValue();
        }
        String strValue = String.valueOf(value);
        return Regex.isNumber(strValue) ? Integer.parseInt(strValue) : defaultValue;
    }

    /**
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or 0 if this map contains no mapping for the key
     */
    public Long optLong(K key){
        return optLong(key, 0L);
    }

    /**
     * @param key the key whose associated value is to be returned
     * @param defaultValue the default mapping of the key
     * @return the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key
     */
    @SuppressWarnings("unchecked")
    public Long optLong(K key, Long defaultValue){
        Object value = getOrDefault(key, (V) defaultValue);
        if(value instanceof Number){
            return ((Number) value).longValue();
        }
        String strValue = String.valueOf(value);
        return Regex.isNumber(strValue) ? Long.parseLong(strValue) : defaultValue;
    }

    /**
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or 0 if this map contains no mapping for the key
     */
    public Double optDouble(K key){
        return optDouble(key, 0D);
    }

    /**
     * @param key the key whose associated value is to be returned
     * @param defaultValue the default mapping of the key
     * @return the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key
     */
    @SuppressWarnings("unchecked")
    public Double optDouble(K key, Double defaultValue){
        Object value = getOrDefault(key, (V) defaultValue);
        if(value instanceof Number){
            return ((Number) value).doubleValue();
        }
        String strValue = String.valueOf(value);
        return Regex.isNumber(strValue) ? Double.parseDouble(strValue) : defaultValue;
    }
}
