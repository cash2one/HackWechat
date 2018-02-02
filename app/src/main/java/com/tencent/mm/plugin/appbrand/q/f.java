package com.tencent.mm.plugin.appbrand.q;

public final class f {
    private long jRW;
    private long jRX;
    private a jRY;

    public f(long j, a aVar) {
        this.jRW = j;
        this.jRY = aVar;
    }

    public final boolean i(Object... objArr) {
        boolean z = false;
        if (!((System.currentTimeMillis() - this.jRX < this.jRW) || this.jRY == null)) {
            z = this.jRY.g(objArr);
            if (z) {
                this.jRX = System.currentTimeMillis();
            }
        }
        return z;
    }
}
