package com.tencent.mm.sdk.platformtools;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class at {
    private static final ConcurrentLinkedQueue<Runnable> xhu = new ConcurrentLinkedQueue();
    private static ExecutorService xhv = null;

    at() {
    }

    public static ExecutorService cfU() {
        ExecutorService executorService;
        synchronized (at.class) {
            if (xhv == null) {
                xhv = Executors.newSingleThreadExecutor();
            }
            executorService = xhv;
        }
        return executorService;
    }

    public static void M(Runnable runnable) {
        xhu.add(runnable);
    }

    public static void N(Runnable runnable) {
        xhu.remove(runnable);
    }
}
