package com.tencent.mm.plugin.appbrand.game.e;

import android.support.v4.e.i.a;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class f<T> implements a<T> {
    public ConcurrentLinkedQueue<T> jas = new ConcurrentLinkedQueue();

    public abstract T adY();

    public T bG() {
        T poll = this.jas.poll();
        if (poll == null) {
            return adY();
        }
        return poll;
    }

    public final boolean j(T t) {
        return this.jas.offer(t);
    }
}
