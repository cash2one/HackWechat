package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.g;

public final class j extends a {
    private long nFT;
    public long nFU;
    public long nGt = 0;
    public long nGu = 0;
    public long nGv = 0;

    public final void start() {
        super.start();
        this.nFT = System.currentTimeMillis();
    }

    public final void reset() {
        this.nFT = 0;
        this.nFU = 0;
        this.nGt = 0;
        this.nGu = 0;
        this.nGv = 0;
    }

    protected final void aUb() {
        g.pQN.h(12934, Long.valueOf(this.nFT), Long.valueOf(this.nFU), Long.valueOf(this.nGt), Long.valueOf(this.nGu), Long.valueOf(this.nGv));
    }
}
