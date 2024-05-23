package com.javaquery.util.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author vicky.thakor
 * @since 1.2.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> implements Serializable {

    @JsonProperty("status_code")
    private final int statusCode;

    @JsonProperty("message")
    private final String message;

    private final T payload;

    @JsonProperty("error_messages")
    private final List<String> errorMessages;

    private Long page;
    private Long limit;
    private Long total;

    private CommonResponse(int statusCode, String message, T payload, List<String> errorMessages) {
        this.statusCode = statusCode;
        this.message = message;
        this.payload = payload;
        this.errorMessages = errorMessages;
    }

    public static <T> CommonResponse<T> ok(T payload){
        return CommonResponse.of(HttpStatus.OK, payload);
    }

    public static <T> CommonResponse<T> of(HttpStatus statusCode, String message, T payload){
        return new CommonResponse<>(statusCode.value(), message, payload, Collections.emptyList());
    }

    public static <T> CommonResponse<T> of(HttpStatus statusCode, String message){
        return new CommonResponse<>(statusCode.value(), message, null, Collections.emptyList());
    }

    public static <T> CommonResponse<T> of(HttpStatus statusCode, T payload){
        return new CommonResponse<>(statusCode.value(), null, payload, Collections.emptyList());
    }

    public static <T> CommonResponse<T> of(HttpStatus statusCode, List<String> errorMessages){
        return new CommonResponse<>(statusCode.value(), null, null, errorMessages);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public T getPayload() {
        return payload;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public Long getPage() {
        return page;
    }

    public CommonResponse<T> withPage(Long page){
        this.page = page;
        return this;
    }

    public Long getLimit() {
        return limit;
    }

    public CommonResponse<T> withLimit(Long limit){
        this.limit = limit;
        return this;
    }

    public Long getTotal() {
        return total;
    }

    public CommonResponse<T> withTotal(Long total){
        this.total = total;
        return this;
    }
}