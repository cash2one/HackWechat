package com.tencent.mm.plugin.appbrand.dynamic.i;

class b$a {
    volatile int count;
    volatile long iUK;
    volatile long iUL;
    volatile long iUM;

    private b$a() {
    }

    final synchronized void reset() {
        this.iUK = 0;
        this.iUL = 0;
        this.count = 0;
    }
}
