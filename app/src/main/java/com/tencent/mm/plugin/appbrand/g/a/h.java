package com.tencent.mm.plugin.appbrand.g.a;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Locker;
import com.tencent.xweb.d;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class h {
    public volatile boolean Vx = true;
    public volatile boolean iqR = false;
    public V8 jwm;
    public Thread jwx;
    final ConcurrentLinkedQueue<Runnable> jwy = new ConcurrentLinkedQueue();
    d jwz;

    public h(V8 v8) {
        this.jwm = v8;
        this.jwx = new 1(this);
        V8Locker locker = this.jwm.getLocker();
        if (locker.hasLock()) {
            locker.release();
        }
        this.jwx.start();
    }

    public final void p(Runnable runnable) {
        this.jwy.offer(runnable);
        this.jwx.interrupt();
    }
}
