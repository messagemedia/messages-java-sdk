package com.messagemedia.messages.controllers.syncwrapper;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// TODO: Auto-generated Javadoc
/**
 * Base class to help convert an asynchronous callback to synchronous one.
 */
public class SynchronousBase {
    
    /** The lock. */
    private CountDownLatch lock;
    
    /**
     * Initiate class with a task count.
     *
     * @param count Number of tasks we will wait on
     */
    public SynchronousBase(int count) {
        this.lock = new CountDownLatch(count);
    }
    
    /**
     * Initiate class with a count down of one only.
     */
    public SynchronousBase() {
        this(1);
    }

    /**
     * Mark as done one task.
     */
    protected void markAsDone()
    {
        lock.countDown();
    }
    
    /**
     * Wait until all tasks are marked as done.
     *
     * @throws InterruptedException the interrupted exception
     */
    public void await() throws InterruptedException {
        lock.await();
    }
    
    /**
     * Wait until all tasks are marked as done or timeout after given time.
     *
     * @param timeout Time to wait
     * @param unit    Unit for time
     * @return true, if successful
     * @throws InterruptedException the interrupted exception
     */
    public boolean await(long timeout, TimeUnit unit) throws InterruptedException {
        boolean t = lock.await(timeout, unit);
        return t;
    }
    
}

