package com.tencent.mm.plugin.emoji.sync;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class b$c implements ThreadFactory {
    private static final AtomicInteger hDb = new AtomicInteger(1);
    private final ThreadGroup hDc;
    private final AtomicInteger hDd = new AtomicInteger(1);
    private final String hDe;
    private final int hDf;

    b$c(int i, String str) {
        this.hDf = i;
        SecurityManager securityManager = System.getSecurityManager();
        this.hDc = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.hDe = str + hDb.getAndIncrement() + "-thread-";
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.hDc, runnable, this.hDe + this.hDd.getAndIncrement(), 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        thread.setPriority(this.hDf);
        return thread;
    }
}
