package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.g;

public final class b extends a {
    private long nFT;
    public long nFU;
    public long nFV = 0;
    public long nFW = 0;
    public long nFX = 0;

    public final void start() {
        super.start();
        this.nFT = System.currentTimeMillis();
    }

    public final void reset() {
        this.nFT = 0;
        this.nFU = 0;
        this.nFV = 0;
        this.nFW = 0;
        this.nFX = 0;
    }

    protected final void aUb() {
        g.pQN.h(12930, new Object[]{Long.valueOf(this.nFT), Long.valueOf(this.nFU), Long.valueOf(this.nFV), Long.valueOf(this.nFW), Long.valueOf(this.nFX)});
    }
}
