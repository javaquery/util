package com.javaquery.util.json;

import com.javaquery.util.Objects;
import com.javaquery.util.string.Strings;
import org.json.JSONArray;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author vicky.thakor
 * @since 1.0.4
 */
public final class JSONObject {

    private org.json.JSONObject ROOT;
    private Map<String, org.json.JSONObject> CACHED_OBJECT;

    /**
     * @param json json string to prepare {@link JSONObject}
     */
    public JSONObject(String json) {
        this(new org.json.JSONObject(json));
    }

    /**
     * @param jsonObject {@link org.json.JSONObject} to prepare {@link JSONObject}
     */
    public JSONObject(org.json.JSONObject jsonObject){
        ROOT = jsonObject;
        CACHED_OBJECT = new HashMap<>();
    }

    /**
     * Get an optional boolean associated with a key. It returns false if there
     * is no such key, or if the value is not Boolean.TRUE or the String "true".
     *
     * @param key A key string.
     * @return The truth.
     */
    public boolean optBoolean(String key) {
        return optBoolean(key, false);
    }

    /**
     * Get an optional boolean associated with a key. It returns the
     * defaultValue if there is no such key, or if it is not a Boolean or the
     * String "true" or "false" (case insensitive).
     *
     * @param key A key string.
     * @param defaultValue The default.
     * @return The truth.
     */
    public boolean optBoolean(String key, boolean defaultValue) {
        KeyPath keyPath = new KeyPath(key);
        return findByKey(keyPath).optBoolean(keyPath.key, defaultValue);
    }

    /**
     * Get an optional BigDecimal associated with a key, or the defaultValue if
     * there is no such key or if its value is not a number. If the value is a
     * string, an attempt will be made to evaluate it as a number. If the value
     * is float or double, then the {@link BigDecimal#BigDecimal(double)}
     * constructor will be used. See notes on the constructor for conversion
     * issues that may arise.
     *
     * @param key A key string.
     * @param defaultValue The default.
     * @return An object which is the value.
     */
    public BigDecimal optBigDecimal(String key, BigDecimal defaultValue) {
        KeyPath keyPath = new KeyPath(key);
        return findByKey(keyPath).optBigDecimal(keyPath.key, defaultValue);
    }

    /**
     * Get an optional BigInteger associated with a key, or the defaultValue if
     * there is no such key or if its value is not a number. If the value is a
     * string, an attempt will be made to evaluate it as a number.
     *
     * @param key A key string.
     * @param defaultValue The default.
     * @return An object which is the value.
     */
    public BigInteger optBigInteger(String key, BigInteger defaultValue) {
        KeyPath keyPath = new KeyPath(key);
        return findByKey(keyPath).optBigInteger(keyPath.key, defaultValue);
    }

    /**
     * Get an optional double associated with a key, or NaN if there is no such
     * key or if its value is not a number. If the value is a string, an attempt
     * will be made to evaluate it as a number.
     *
     * @param key A string which is the key.
     * @return An object which is the value.
     */
    public double optDouble(String key) {
        return optDouble(key, Double.NaN);
    }

    /**
     * Get an optional double associated with a key, or the defaultValue if
     * there is no such key or if its value is not a number. If the value is a
     * string, an attempt will be made to evaluate it as a number.
     *
     * @param key A key string.
     * @param defaultValue The default.
     * @return An object which is the value.
     */
    public double optDouble(String key, double defaultValue) {
        KeyPath keyPath = new KeyPath(key);
        return findByKey(keyPath).optDouble(keyPath.key, defaultValue);
    }

    /**
     * Get the enum value associated with a key.
     *
     * @param <E> Enum Type
     * @param clazz The type of enum to retrieve.
     * @param key A key string.
     * @return The enum value associated with the key or null if not found
     */
    public <E extends Enum<E>> E optEnum(Class<E> clazz, String key) {
        return this.optEnum(clazz, key, null);
    }

    /**
     * Get the enum value associated with a key.
     *
     * @param <E> Enum Type
     * @param clazz The type of enum to retrieve.
     * @param key A key string.
     * @param defaultValue The default in case the value is not found
     * @return The enum value associated with the key or defaultValue
     *            if the value is not found or cannot be assigned to <code>clazz</code>
     */
    public <E extends Enum<E>> E optEnum(Class<E> clazz, String key, E defaultValue) {
        KeyPath keyPath = new KeyPath(key);
        return findByKey(keyPath).optEnum(clazz, keyPath.key, defaultValue);
    }

    /**
     * Get the optional double value associated with an index. NaN is returned
     * if there is no value for the index, or if the value is not a number and
     * cannot be converted to a number.
     *
     * @param key A key string.
     * @return The value.
     */
    public float optFloat(String key) {
        return optFloat(key, Float.NaN);
    }

    /**
     * Get the optional double value associated with an index. The defaultValue
     * is returned if there is no value for the index, or if the value is not a
     * number and cannot be converted to a number.
     *
     * @param key A key string.
     * @param defaultValue The default value.
     * @return The value.
     */
    public float optFloat(String key, float defaultValue) {
        KeyPath keyPath = new KeyPath(key);
        return findByKey(keyPath).optFloat(keyPath.key, defaultValue);
    }

    /**
     * Get an optional int value associated with a key, or zero if there is no
     * such key or if the value is not a number. If the value is a string, an
     * attempt will be made to evaluate it as a number.
     *
     * @param key A key string.
     * @return An object which is the value.
     */
    public int optInt(String key) {
        return optInt(key, 0);
    }

    /**
     * Get an optional int value associated with a key, or the default if there
     * is no such key or if the value is not a number. If the value is a string,
     * an attempt will be made to evaluate it as a number.
     *
     * @param key A key string.
     * @param defaultValue The default.
     * @return An object which is the value.
     */
    public int optInt(String key, int defaultValue) {
        KeyPath keyPath = new KeyPath(key);
        return findByKey(keyPath).optInt(keyPath.key, defaultValue);
    }

    /**
     * Get an optional long value associated with a key, or zero if there is no
     * such key or if the value is not a number. If the value is a string, an
     * attempt will be made to evaluate it as a number.
     *
     * @param key A key string.
     * @return An object which is the value.
     */
    public long optLong(String key) {
        return optLong(key, 0);
    }

    /**
     * Get an optional long value associated with a key, or the default if there
     * is no such key or if the value is not a number. If the value is a string,
     * an attempt will be made to evaluate it as a number.
     *
     * @param key A key string.
     * @param defaultValue The default.
     * @return An object which is the value.
     */
    public long optLong(String key, long defaultValue) {
        KeyPath keyPath = new KeyPath(key);
        return findByKey(keyPath).optLong(keyPath.key, defaultValue);
    }

    /**
     * Get an optional {@link Number} value associated with a key, or <code>null</code>
     * if there is no such key or if the value is not a number. If the value is a string,
     * an attempt will be made to evaluate it as a number ({@link BigDecimal}). This method
     * would be used in cases where type coercion of the number value is unwanted.
     *
     * @param key A key string.
     * @return An object which is the value.
     */
    public Number optNumber(String key) {
        return optNumber(key, null);
    }

    /**
     * Get an optional {@link Number} value associated with a key, or the default if there
     * is no such key or if the value is not a number. If the value is a string,
     * an attempt will be made to evaluate it as a number. This method
     * would be used in cases where type coercion of the number value is unwanted.
     *
     * @param key A key string.
     * @param defaultValue The default.
     * @return An object which is the value.
     */
    public Number optNumber(String key, Number defaultValue) {
        KeyPath keyPath = new KeyPath(key);
        return findByKey(keyPath).optNumber(keyPath.key, defaultValue);
    }

    /**
     * Get an optional string associated with a key. It returns an empty string
     * if there is no such key. If the value is not a string and is not null,
     * then it is converted to a string.
     *
     * @param key A key string.
     * @return A string which is the value.
     */
    public String optString(String key) {
        return optString(key, "");
    }

    /**
     * Get an optional string associated with a key. It returns the defaultValue
     * if there is no such key.
     *
     * @param key A key string.
     * @param defaultValue The default.
     * @return A string which is the value.
     */
    public String optString(String key, String defaultValue) {
        KeyPath keyPath = new KeyPath(key);
        return findByKey(keyPath).optString(keyPath.key, defaultValue);
    }

    /**
     * Get an optional JSONObject associated with a key. It returns null if
     * there is no such key, or if its value is not a JSONObject.
     *
     * @param key A key string.
     * @return A JSONObject which is the value.
     */
    public org.json.JSONObject optJSONObject(String key) {
        KeyPath keyPath = new KeyPath(key);
        org.json.JSONObject jsonObject = findByKey(keyPath);
        org.json.JSONObject result = jsonObject.optJSONObject(keyPath.key);
        if (Objects.isNull(result) && keyPath.key.contains("[") && keyPath.key.endsWith("]")) {
            result = arrayJSONObject(jsonObject, keyPath.key);
        }
        return result;
    }

    /**
     * Get an optional JSONArray associated with a key. It returns null if there
     * is no such key, or if its value is not a JSONArray.
     *
     * @param key A key string.
     * @return A JSONArray which is the value.
     */
    public JSONArray optJSONArray(String key) {
        KeyPath keyPath = new KeyPath(key);
        return findByKey(keyPath).optJSONArray(keyPath.key);
    }

    /**
     * Find {@link org.json.JSONObject} at provided path
     * @param keyPath object containg key and path of object
     * @return A {@link org.json.JSONObject} which hold the value
     */
    private org.json.JSONObject findByKey(KeyPath keyPath) {
        if (Strings.nonNullNonEmpty(keyPath.path)) {
            if (CACHED_OBJECT.containsKey(keyPath.path)) {
                return CACHED_OBJECT.get(keyPath.path);
            } else {
                org.json.JSONObject result = (org.json.JSONObject) recursion(ROOT, keyPath.path);
                CACHED_OBJECT.put(keyPath.path, result);
                return result;
            }
        } else {
            return ROOT;
        }
    }

    /**
     * Do a recursive call to fine Object at provided path
     *
     * @param jsonObject input {@link org.json.JSONObject}
     * @param path a path to find object
     * @return Object at provided path
     */
    private Object recursion(org.json.JSONObject jsonObject, String path) {
        if (path.contains(".")) {
            int dotIndex = path.indexOf(".");
            String subKey = path.substring(0, dotIndex);
            String remainingKey = path.substring(dotIndex + 1);

            if (subKey.contains("[") && subKey.endsWith("]")) {
                org.json.JSONObject jsonArrayValueObject = arrayJSONObject(jsonObject, subKey);
                if (Objects.nonNull(jsonArrayValueObject)) {
                    return recursion(jsonArrayValueObject, remainingKey);
                }
            }

            Object object = jsonObject.opt(subKey);
            if (object instanceof org.json.JSONObject) {
                return recursion(jsonObject.optJSONObject(subKey), remainingKey);
            }
        } else {
            if (path.contains("[") && path.endsWith("]")) {
                return arrayJSONObject(jsonObject, path);
            }

            return jsonObject.optJSONObject(path);
        }
        return jsonObject;
    }

    /**
     * Get {@link org.json.JSONObject} from {@link JSONArray} from provided index
     * @param jsonObject input {@link org.json.JSONObject}.
     * @param keyWithIndex String value of index <code>i.e "[1]"</code>
     * @return org.json.JSONObject from {@link JSONArray}
     */
    private org.json.JSONObject arrayJSONObject(org.json.JSONObject jsonObject, String keyWithIndex) {
        if (keyWithIndex.contains("[") && keyWithIndex.endsWith("]")) {
            int startBracket = keyWithIndex.indexOf("[");
            int endBracket = keyWithIndex.indexOf("]");
            String arrayName = keyWithIndex.substring(0, startBracket);
            int arrayIndex = Integer.parseInt(keyWithIndex.substring(startBracket + 1, endBracket));

            JSONArray jsonArray = jsonObject.optJSONArray(arrayName);
            if(Objects.nonNull(jsonArray)){
                return jsonArray.optJSONObject(arrayIndex);
            }
        }
        return null;
    }

    /**
     * Nullify object for garbage collection
     */
    public void flush() {
        ROOT = null;
        CACHED_OBJECT = null;
    }

    /**
     * To hold key and path to find object.
     */
    private static class KeyPath {
        private final String key;
        private String path;

        public KeyPath(String key) {
            int dotIndex = key.lastIndexOf(".");
            if (dotIndex > 0) {
                this.key = key.substring(dotIndex + 1);
                this.path = key.substring(0, dotIndex);
            } else {
                this.key = key;
            }
        }
    }

    @Override
    public String toString() {
        return ROOT.toString();
    }
}
