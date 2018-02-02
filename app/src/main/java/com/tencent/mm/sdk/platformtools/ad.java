package com.tencent.mm.sdk.platformtools;

public final class ad {
    public volatile boolean xfv;

    public ad() {
        this.xfv = false;
    }

    public ad(boolean z) {
        this.xfv = z;
    }

    public final void open() {
        synchronized (this) {
            boolean z = this.xfv;
            this.xfv = true;
            if (!z) {
                notifyAll();
            }
        }
    }

    public final void close() {
        synchronized (this) {
            this.xfv = false;
        }
    }

    public final void block() {
        synchronized (this) {
            while (!this.xfv) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public final boolean cfB() {
        if (500 != 0) {
            boolean z;
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = 500 + currentTimeMillis;
                while (!this.xfv && currentTimeMillis < j) {
                    try {
                        wait(j - currentTimeMillis);
                    } catch (InterruptedException e) {
                    }
                    currentTimeMillis = System.currentTimeMillis();
                }
                z = this.xfv;
            }
            return z;
        }
        block();
        return true;
    }

    public final String toString() {
        return "MMConditionVariable[" + hashCode() + "," + this.xfv + "]";
    }
}
