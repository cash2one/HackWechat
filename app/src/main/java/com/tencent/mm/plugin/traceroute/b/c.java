package com.tencent.mm.plugin.traceroute.b;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

public final class c extends ThreadPoolExecutor {
    public c() {
        super(10, 20, 3000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(200), new CallerRunsPolicy());
    }
}
