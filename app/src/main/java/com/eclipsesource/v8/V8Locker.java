package com.eclipsesource.v8;

public class V8Locker {
    private boolean released = false;
    private V8 runtime;
    private Thread thread = null;

    V8Locker(V8 v8) {
        this.runtime = v8;
        acquire();
    }

    public Thread getThread() {
        return this.thread;
    }

    public synchronized void acquire() {
        if (this.thread != null && this.thread != Thread.currentThread()) {
            throw new Error("Invalid V8 thread access: current thread is " + Thread.currentThread() + " while the locker has thread " + this.thread);
        } else if (this.thread != Thread.currentThread()) {
            this.runtime.acquireLock(this.runtime.getV8RuntimePtr());
            this.thread = Thread.currentThread();
            this.released = false;
        }
    }

    public synchronized boolean tryAcquire() {
        boolean z = false;
        synchronized (this) {
            if (this.thread == null || this.thread == Thread.currentThread()) {
                if (this.thread == Thread.currentThread()) {
                    z = true;
                } else {
                    this.runtime.acquireLock(this.runtime.getV8RuntimePtr());
                    this.thread = Thread.currentThread();
                    this.released = false;
                    z = true;
                }
            }
        }
        return z;
    }

    public synchronized void release() {
        if (!((this.released && this.thread == null) || this.runtime.isReleased())) {
            checkThread();
            this.runtime.releaseLock(this.runtime.getV8RuntimePtr());
            this.thread = null;
            this.released = true;
        }
    }

    public void checkThread() {
        if (this.released && this.thread == null) {
            throw new Error("Invalid V8 thread access: the locker has been released!");
        } else if (this.thread != Thread.currentThread()) {
            throw new Error("Invalid V8 thread access: current thread is " + Thread.currentThread() + " while the locker has thread " + this.thread);
        }
    }

    public boolean hasLock() {
        return this.thread == Thread.currentThread();
    }
}
