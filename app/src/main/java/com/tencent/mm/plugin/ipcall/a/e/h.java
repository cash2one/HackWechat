package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.g;

public final class h extends a {
    private long nFT;
    public long nFU;
    private long nGp = 0;
    public long nGq = 0;
    public long nGr = 0;
    public long nGs = 0;

    public final void start() {
        super.start();
        this.nFT = System.currentTimeMillis();
    }

    public final void reset() {
        this.nFT = 0;
        this.nFU = 0;
        this.nGp = 0;
        this.nGq = 0;
        this.nGr = 0;
        this.nGs = 0;
    }

    protected final void aUb() {
        g.pQN.h(12931, new Object[]{Long.valueOf(this.nFT), Long.valueOf(this.nFU), Long.valueOf(this.nGp), Long.valueOf(this.nGq), Long.valueOf(this.nGr), Long.valueOf(this.nGs)});
    }
}
