package com.tencent.c.f;

public abstract class j<T> {
    private volatile T mInstance;

    public abstract T cCT();

    public final T get() {
        T t = this.mInstance;
        if (t == null) {
            synchronized (this) {
                t = this.mInstance;
                if (t == null) {
                    t = cCT();
                    this.mInstance = t;
                }
            }
        }
        return t;
    }
}
