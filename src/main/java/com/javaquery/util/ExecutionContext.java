package com.javaquery.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaquery.util.logging.Action;
import com.javaquery.util.logging.ActivityStatus;
import com.javaquery.util.time.Dates;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author vicky.thakor
 * @since 1.2.0
 */
public class ExecutionContext<T, V> {

    @JsonProperty("request_id")
    private String requestId;

    @JsonProperty("reference_id")
    private T referenceId;

    @JsonProperty("user")
    private V userContext;

    private Action action;

    @JsonProperty("activity_status")
    private ActivityStatus activityStatus;

    private Map<String, Object> meta;

    @JsonProperty("max_retries")
    private Integer maxRetries = 5;

    @JsonProperty("retries_attempted")
    private Integer retriesAttempted = 0;

    @JsonProperty("created_at")
    private final Date createdAt;

    public ExecutionContext() {
        this.createdAt = Dates.current();
    }

    public ExecutionContext(String requestId){
        this.requestId = requestId;
        this.createdAt = Dates.current();
    }

    public ExecutionContext(String requestId, T referenceId, Action action) {
        this.requestId = requestId;
        this.referenceId = referenceId;
        this.action = action;
        this.meta = new HashMap<>();
        this.createdAt = Dates.current();
    }

    public ExecutionContext(T referenceId, Action action) {
        this.requestId = UniqueIdGenerator.generate();
        this.referenceId = referenceId;
        this.action = action;
        this.meta = new HashMap<>();
        this.createdAt = Dates.current();
    }

    public ExecutionContext(Action action) {
        this.requestId = UniqueIdGenerator.generate();
        this.action = action;
        this.meta = new HashMap<>();
        this.createdAt = Dates.current();
    }

    public ExecutionContext(T referenceId, Action action, Integer maxRetries) {
        this.requestId = UniqueIdGenerator.generate();
        this.referenceId = referenceId;
        this.action = action;
        this.maxRetries = maxRetries;
        this.meta = new HashMap<>();
        this.createdAt = Dates.current();
    }

    public ExecutionContext(Action action, Integer maxRetries) {
        this.requestId = UniqueIdGenerator.generate();
        this.action = action;
        this.maxRetries = maxRetries;
        this.meta = new HashMap<>();
        this.createdAt = Dates.current();
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public V getUserContext() {
        return userContext;
    }

    public void setUserContext(V userContext) {
        this.userContext = userContext;
    }

    public T getReferenceId() {
        return referenceId;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public ActivityStatus getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(ActivityStatus activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Map<String, Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }

    public Object getMeta(String key, Object defaultValue){
        return meta.getOrDefault(key, defaultValue);
    }

    public void addMeta(String key, Object value){
        this.meta.put(key, value);
    }

    public Integer getMaxRetries() {
        return maxRetries;
    }

    public Integer getRetriesAttempted() {
        return retriesAttempted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void addRetriesAttempted(Integer retriesAttempted) {
        this.retriesAttempted += retriesAttempted;
    }

    @Override
    public String toString() {
        return "ExecutionContext{" +
                "requestId='" + requestId + '\'' +
                ", referenceId=" + referenceId +
                ", action=" + action +
                ", maxRetries=" + maxRetries +
                ", retriesAttempted=" + retriesAttempted +
                ", createdAt=" + createdAt +
                '}';
    }
}
