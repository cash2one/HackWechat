package com.tencent.mm.sdk.f;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

final class f extends ThreadPoolExecutor {
    private a xkj;

    interface a {
        void P(Runnable runnable);

        void beforeExecute(Thread thread, Runnable runnable);
    }

    public f(int i, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, a aVar) {
        super(0, i, 120, timeUnit, blockingQueue, new d(), new CallerRunsPolicy());
        this.xkj = aVar;
    }

    public final void execute(Runnable runnable) {
        super.execute(runnable);
    }

    protected final void beforeExecute(Thread thread, Runnable runnable) {
        if (this.xkj != null) {
            this.xkj.beforeExecute(thread, runnable);
        }
        super.beforeExecute(thread, runnable);
    }

    protected final void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (this.xkj != null) {
            this.xkj.P(runnable);
        }
    }
}
