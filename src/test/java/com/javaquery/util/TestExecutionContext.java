package com.javaquery.util;

import com.javaquery.util.logging.Action;
import com.javaquery.util.logging.ActivityStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author vicky.thakor
 * @since 1.2.0
 */
public class TestExecutionContext {

    public enum ExecutionContextAction implements Action{
        ONE
    }

    public class UserContext{

        private Long userId;

        private Long tenantId;

        public UserContext(Long userId, Long tenantId) {
            this.userId = userId;
            this.tenantId = tenantId;
        }

        public Long getUserId() {
            return userId;
        }

        public Long getTenantId() {
            return tenantId;
        }
    }

    @Test
    public void defaultConstructor(){
        ExecutionContext<Object, Object> executionContext = new ExecutionContext<>();
        executionContext.setUserContext(new UserContext(50L, 20L));
        executionContext.setRequestId(UniqueIdGenerator.generate());

        UserContext userContext = (UserContext) executionContext.getUserContext();
        Assertions.assertEquals(50L, userContext.getUserId());
        Assertions.assertNotNull(executionContext.getCreatedAt());
        Assertions.assertNotNull(executionContext.getRequestId());
    }

    @Test
    public void constructorWithRequestId(){
        ExecutionContext<Long, Long> executionContext = new ExecutionContext<>(UniqueIdGenerator.generate());
        Assertions.assertNotNull(executionContext.getRequestId());
    }

    @Test
    public void constructorWithRequestIdReferenceIdAction(){
        ExecutionContext<Long, Long> executionContext = new ExecutionContext<>(UniqueIdGenerator.generate(), 1L, ExecutionContextAction.ONE);
        executionContext.setUserContext(50L);
        executionContext.setActivityStatus(ActivityStatus.STARTED);
        Assertions.assertNotNull(executionContext.getRequestId());
        Assertions.assertEquals(ExecutionContextAction.ONE, executionContext.getAction());
        Assertions.assertEquals(1L, executionContext.getReferenceId());
        Assertions.assertNotNull(executionContext.getMeta());
        Assertions.assertNotNull(executionContext.getCreatedAt());

        Assertions.assertEquals(50L, executionContext.getUserContext());
        Assertions.assertEquals(ActivityStatus.STARTED, executionContext.getActivityStatus());
        Assertions.assertNotNull(executionContext.getCreatedAt());
    }

    @Test
    public void constructorWithReferenceIdAction(){
        ExecutionContext<String, Void> executionContext = new ExecutionContext<>("test", ExecutionContextAction.ONE);
        Assertions.assertNotNull(executionContext.getRequestId());
        Assertions.assertEquals(ExecutionContextAction.ONE, executionContext.getAction());
        Assertions.assertEquals("test", executionContext.getReferenceId());
        Assertions.assertNotNull(executionContext.getMeta());
        Assertions.assertNotNull(executionContext.getCreatedAt());
    }

    @Test
    public void constructorWithAction(){
        ExecutionContext<String, Void> executionContext = new ExecutionContext<>(ExecutionContextAction.ONE);
        Assertions.assertNotNull(executionContext.getRequestId());
        Assertions.assertEquals(ExecutionContextAction.ONE, executionContext.getAction());
        Assertions.assertNull(executionContext.getReferenceId());
        Assertions.assertNotNull(executionContext.getMeta());
        Assertions.assertNotNull(executionContext.getCreatedAt());
    }

    @Test
    public void constructorWithActionAndMeta(){
        ExecutionContext<String, Void> executionContext = new ExecutionContext<>(ExecutionContextAction.ONE);
        executionContext.addMeta("key", "value");
        Assertions.assertNotNull(executionContext.getRequestId());
        Assertions.assertEquals(ExecutionContextAction.ONE, executionContext.getAction());
        Assertions.assertNull(executionContext.getReferenceId());
        Assertions.assertEquals("value", executionContext.getMeta("key", null));
        Assertions.assertNotNull(executionContext.getCreatedAt());

        /* set meta */
        executionContext.setMeta(new HashMap<>());
        Assertions.assertNull(executionContext.getMeta("key", null));
    }

    @Test
    public void constructorWithActionAndRetriesAttempted(){
        ExecutionContext<String, Void> executionContext = new ExecutionContext<>(ExecutionContextAction.ONE);
        executionContext.addRetriesAttempted(1);
        Assertions.assertNotNull(executionContext.getRequestId());
        Assertions.assertEquals(ExecutionContextAction.ONE, executionContext.getAction());
        Assertions.assertNull(executionContext.getReferenceId());
        Assertions.assertNotNull(executionContext.getMeta());
        Assertions.assertEquals(1, executionContext.getRetriesAttempted());
        Assertions.assertNotNull(executionContext.getCreatedAt());
    }

    @Test
    public void constructorWithReferenceIdActionMaxRetries(){
        ExecutionContext<Long, Void> executionContext = new ExecutionContext<>(1L, ExecutionContextAction.ONE, 3);
        Assertions.assertNotNull(executionContext.getRequestId());
        Assertions.assertEquals(ExecutionContextAction.ONE, executionContext.getAction());
        Assertions.assertEquals(1L, executionContext.getReferenceId());
        Assertions.assertEquals(3, executionContext.getMaxRetries());
        Assertions.assertNotNull(executionContext.getMeta());
        Assertions.assertNotNull(executionContext.getCreatedAt());
    }

    @Test
    public void constructorWithActionMaxRetries(){
        ExecutionContext<Long, Void> executionContext = new ExecutionContext<>(ExecutionContextAction.ONE, 3);
        Assertions.assertNotNull(executionContext.getRequestId());
        Assertions.assertEquals(ExecutionContextAction.ONE, executionContext.getAction());
        Assertions.assertNull(executionContext.getReferenceId());
        Assertions.assertEquals(3, executionContext.getMaxRetries());
        Assertions.assertNotNull(executionContext.getMeta());
        Assertions.assertNotNull(executionContext.getCreatedAt());
    }
}
