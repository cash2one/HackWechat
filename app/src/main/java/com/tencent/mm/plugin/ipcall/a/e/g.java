package com.tencent.mm.plugin.ipcall.a.e;

public final class g extends a {
    private long nFT;
    public long nFU;
    public long nGi = 0;
    public String nGj = "";
    public String nGk = "";
    public long nGl = 0;
    public long nGm = 0;
    public long nGn = 0;
    public String nGo = "";

    public final void start() {
        super.start();
        this.nFT = System.currentTimeMillis();
    }

    public final void reset() {
        this.nFT = 0;
        this.nFU = 0;
        this.nGi = 0;
        this.nGj = "";
        this.nGk = "";
        this.nGl = 0;
        this.nGm = 0;
        this.nGn = 0;
        this.nGo = "";
    }

    protected final void aUb() {
        com.tencent.mm.plugin.report.service.g.pQN.h(12933, new Object[]{Long.valueOf(this.nFT), Long.valueOf(this.nFU), Long.valueOf(this.nGi), this.nGj, this.nGk, Long.valueOf(this.nGl), Long.valueOf(this.nGm), Long.valueOf(this.nGn), this.nGo});
    }
}
