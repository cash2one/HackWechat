package com.tencent.mm.memory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class d<T, S> {
    protected Queue<T> gZR = new ConcurrentLinkedQueue();
    protected S gZS;

    public d(S s) {
        this.gZS = s;
    }

    public final T pop() {
        return this.gZR.poll();
    }

    public final void put(T t) {
        this.gZR.add(t);
    }

    public final int size() {
        return this.gZR.size();
    }

    public final S Et() {
        return this.gZS;
    }
}
