package com.tencent.mm.pluginsdk.i.a.d;

import com.tencent.mm.sdk.f.e;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class t implements ThreadFactory {
    private static final AtomicInteger vih = new AtomicInteger(1);
    private final AtomicInteger hDd;
    private String hDe;

    public t() {
        this("ResDownloaderPool", "ResDownloaderThread");
    }

    public t(String str, String str2) {
        this.hDd = new AtomicInteger(1);
        this.hDe = String.format("%s-%d-%s-", new Object[]{str, Integer.valueOf(vih.getAndIncrement()), str2});
    }

    public final Thread newThread(Runnable runnable) {
        Thread d = e.d(runnable, this.hDe + this.hDd.getAndIncrement(), 1);
        if (d.isDaemon()) {
            d.setDaemon(false);
        }
        return d;
    }
}
