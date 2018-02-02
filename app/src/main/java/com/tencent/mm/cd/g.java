package com.tencent.mm.cd;

public final class g<T> {
    private byte[] gOg = new byte[0];
    private volatile T mInstance;
    private c<T> zJT;

    public g(c<T> cVar) {
        this.zJT = cVar;
    }

    public final T get() {
        if (this.mInstance == null) {
            synchronized (this.gOg) {
                if (this.mInstance == null) {
                    this.mInstance = this.zJT.get();
                }
            }
        }
        return this.mInstance;
    }
}
