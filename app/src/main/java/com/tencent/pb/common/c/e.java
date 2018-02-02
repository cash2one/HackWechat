package com.tencent.pb.common.c;

public abstract class e<T> {
    private T mInstance;

    public abstract T cCT();

    public final T get() {
        T t;
        synchronized (this) {
            if (this.mInstance == null) {
                this.mInstance = cCT();
            }
            t = this.mInstance;
        }
        return t;
    }
}
