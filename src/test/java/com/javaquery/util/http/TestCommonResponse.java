package com.javaquery.util.http;

import com.javaquery.util.collection.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author vicky.thakor
 * @since 1.2.0
 */
public class TestCommonResponse {

    @Test
    public void ok(){
        CommonResponse<String> commonResponse = CommonResponse.ok("payload");
        Assertions.assertEquals("payload", commonResponse.getPayload());
    }

    @Test
    public void ofWithStatusCodeMessagePayload(){
        CommonResponse<String> commonResponse = CommonResponse.of(HttpStatus.CREATED, "message", "payload");
        Assertions.assertEquals(HttpStatus.CREATED.value(), commonResponse.getStatusCode());
        Assertions.assertEquals("message", commonResponse.getMessage());
        Assertions.assertEquals("payload", commonResponse.getPayload());
    }

    @Test
    public void ofWithStatusCodeMessage(){
        CommonResponse<String> commonResponse = CommonResponse.of(HttpStatus.CREATED, "message");
        Assertions.assertEquals(HttpStatus.CREATED.value(), commonResponse.getStatusCode());
        Assertions.assertEquals("message", commonResponse.getMessage());
    }

    @Test
    public void ofWithStatusCodePayload(){
        CommonResponse<Long> commonResponse = CommonResponse.of(HttpStatus.CREATED, 1L);
        Assertions.assertEquals(HttpStatus.CREATED.value(), commonResponse.getStatusCode());
        Assertions.assertEquals(1L, commonResponse.getPayload());
    }

    @Test
    public void ofWithStatusCodeErrorMessages(){
        CommonResponse<Long> commonResponse = CommonResponse.of(HttpStatus.BAD_REQUEST, Collections.singletonList("errorMessage"));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), commonResponse.getStatusCode());
        Assertions.assertEquals("errorMessage", commonResponse.getErrorMessages().get(0));
    }

    @Test
    public void okWithPaging(){
        CommonResponse<Long> commonResponse = CommonResponse.of(HttpStatus.CREATED, 1L);
        commonResponse.withPage(1L).withLimit(10L).withTotal(100L);
        Assertions.assertEquals(HttpStatus.CREATED.value(), commonResponse.getStatusCode());
        Assertions.assertEquals(1L, commonResponse.getPayload());
        Assertions.assertEquals(1L, commonResponse.getPage());
        Assertions.assertEquals(10L, commonResponse.getLimit());
        Assertions.assertEquals(100L, commonResponse.getTotal());
    }
}
