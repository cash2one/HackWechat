package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8;
import java.util.LinkedList;

public class V8Executor extends Thread {
    private Exception exception;
    private volatile boolean forceTerminating;
    private boolean longRunning;
    private String messageHandler;
    private LinkedList<String[]> messageQueue;
    private String result;
    private V8 runtime;
    private final String script;
    private volatile boolean shuttingDown;
    private volatile boolean terminated;

    public V8Executor(String str, boolean z, String str2) {
        this.terminated = false;
        this.shuttingDown = false;
        this.forceTerminating = false;
        this.exception = null;
        this.messageQueue = new LinkedList();
        this.script = str;
        this.longRunning = z;
        this.messageHandler = str2;
    }

    public V8Executor(String str) {
        this(str, false, null);
    }

    protected void setup(V8 v8) {
    }

    public String getResult() {
        return this.result;
    }

    public void postMessage(String... strArr) {
        synchronized (this) {
            this.messageQueue.add(strArr);
            notify();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        synchronized (this) {
            this.runtime = V8.createV8Runtime();
            this.runtime.registerJavaMethod(new ExecutorTermination(this), "__j2v8__checkThreadTerminate");
            setup(this.runtime);
        }
        if (!this.forceTerminating) {
            Object executeScript = this.runtime.executeScript("__j2v8__checkThreadTerminate();\n" + this.script, getName(), -1);
            if (executeScript != null) {
                this.result = executeScript.toString();
            }
            if (executeScript instanceof Releasable) {
                ((Releasable) executeScript).release();
            }
            if (executeScript instanceof Releasable) {
                ((Releasable) executeScript).release();
            }
        }
        while (!this.forceTerminating && this.longRunning) {
            synchronized (this) {
                if (this.messageQueue.isEmpty() && !this.shuttingDown) {
                    wait();
                }
                if (!((this.messageQueue.isEmpty() && this.shuttingDown) || this.forceTerminating)) {
                }
            }
        }
        synchronized (this) {
            if (this.runtime.getLocker().hasLock()) {
                this.runtime.release();
                this.runtime = null;
            }
            this.terminated = true;
        }
    }

    public boolean hasException() {
        return this.exception != null;
    }

    public Exception getException() {
        return this.exception;
    }

    public boolean hasTerminated() {
        return this.terminated;
    }

    public void forceTermination() {
        synchronized (this) {
            this.forceTerminating = true;
            this.shuttingDown = true;
            if (this.runtime != null) {
                this.runtime.terminateExecution();
            }
            notify();
        }
    }

    public void shutdown() {
        synchronized (this) {
            this.shuttingDown = true;
            notify();
        }
    }

    public boolean isShuttingDown() {
        return this.shuttingDown;
    }

    public boolean isTerminating() {
        return this.forceTerminating;
    }
}
