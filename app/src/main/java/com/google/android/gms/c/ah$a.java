package com.google.android.gms.c;

import com.google.android.gms.c.ah.b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class ah$a extends ThreadPoolExecutor {
    final /* synthetic */ ah aYs;

    public ah$a(ah ahVar) {
        this.aYs = ahVar;
        super(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        setThreadFactory(new b((byte) 0));
    }

    protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new 1(this, runnable, t);
    }
}
