package com.tencent.e;

public abstract class d<T extends e> {
    public T[] Amx = IX(20);
    public final Object mLock = new Object();
    public int qur;

    public abstract T[] IX(int i);

    public abstract T cHq();

    public d(int i) {
    }

    public T cHr() {
        T t = null;
        synchronized (this.mLock) {
            if (this.qur > 0) {
                this.qur--;
                t = this.Amx[this.qur];
                this.Amx[this.qur] = null;
            }
        }
        return t;
    }
}
