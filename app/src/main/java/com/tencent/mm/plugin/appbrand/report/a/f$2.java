package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.report.a.f.a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class f$2 extends ThreadPoolExecutor {
    f$2(TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(1, 1, 1000, timeUnit, blockingQueue, threadFactory);
    }

    protected final void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (runnable instanceof a) {
            f.ajW().a((a) runnable);
        }
    }
}
