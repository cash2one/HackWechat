package com.google.android.gms.c;

import com.google.android.gms.c.ah.c;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class ah$b implements ThreadFactory {
    private static final AtomicInteger aYu = new AtomicInteger();

    private ah$b() {
    }

    public final Thread newThread(Runnable runnable) {
        return new c(runnable, "measurement-" + aYu.incrementAndGet());
    }
}
