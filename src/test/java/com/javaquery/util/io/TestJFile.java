package com.javaquery.util.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author vicky.thakor
 * @since 1.0.3
 */
public class TestJFile {

    private static final String TEMP_DIR = System.getProperty("java.io.tmpdir");

    @Test
    public void test_getExtension(){
        JFile jFile = new JFile(TEMP_DIR + File.separatorChar + randomFileName(".txt"));
        Assertions.assertEquals("txt", jFile.getExtension());
    }

    @Test
    public void test_getExtension_1(){
        JFile jFile = new JFile(TEMP_DIR + File.separatorChar + randomFileName(null));
        Assertions.assertEquals("", jFile.getExtension());
    }

    @Test
    public void test_rename() throws IOException {
        String renameFile = "hello-world.log";
        JFile jFile = new JFile(TEMP_DIR + File.separatorChar + randomFileName(".txt"));
        if(jFile.createNewFile()){
            jFile = jFile.rename(renameFile);
            Assertions.assertEquals(renameFile, jFile.getName());
        }
        jFile.delete();
    }

    @Test
    public void test_rename_1() {
        JFile jFile = new JFile(TEMP_DIR + File.separatorChar + randomFileName(".txt"));
        Assertions.assertThrows(NullPointerException.class, () -> jFile.rename(null));
    }

    @Test
    public void test_rename_2() {
        JFile jFile = new JFile(TEMP_DIR + File.separatorChar + randomFileName(".txt"));
        Assertions.assertNull(jFile.rename("hello-world.log"));
    }

    @Test
    public void test_write_read_append() {
        JFile jFile = new JFile(TEMP_DIR + File.separatorChar + randomFileName(".txt"));
        jFile.write("hello");

        String data = jFile.read();
        Assertions.assertEquals("hello", data);

        jFile.append("world!", false);
        String appendedData = jFile.read();
        Assertions.assertEquals("helloworld!", appendedData);
        jFile.delete();
    }

    @Test
    public void test_attributes() {
        JFile jFile = new JFile(TEMP_DIR + File.separatorChar + randomFileName(".txt"));
        jFile.addAttribute("hello", "world");
        Assertions.assertEquals("world", jFile.optAttribute("hello", "oh snap!"));

        Map<String, String> map = new HashMap<>(1);
        map.put("1", "2");
        jFile.addAllAttribute(map);
        Assertions.assertEquals(2, jFile.getAttributes().size());
    }

    private String randomFileName(String suffix){
        return UUID.randomUUID().toString().replace("-", "") + suffix;
    }
}
