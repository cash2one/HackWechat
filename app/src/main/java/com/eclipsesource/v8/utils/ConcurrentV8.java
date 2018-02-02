package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.V8;

public final class ConcurrentV8 {
    private V8 v8;

    public ConcurrentV8() {
        this.v8 = null;
        this.v8 = V8.createV8Runtime();
        this.v8.getLocker().release();
    }

    public final V8 getV8() {
        return this.v8;
    }

    public final synchronized void run(V8Runnable v8Runnable) {
        try {
            this.v8.getLocker().acquire();
            v8Runnable.run(this.v8);
            if (!(this.v8 == null || this.v8.getLocker() == null || !this.v8.getLocker().hasLock())) {
                this.v8.getLocker().release();
            }
        } catch (Throwable th) {
            if (!(this.v8 == null || this.v8.getLocker() == null || !this.v8.getLocker().hasLock())) {
                this.v8.getLocker().release();
            }
        }
    }

    public final void release() {
        if (this.v8 != null && !this.v8.isReleased()) {
            run(new 1(this));
        }
    }
}
