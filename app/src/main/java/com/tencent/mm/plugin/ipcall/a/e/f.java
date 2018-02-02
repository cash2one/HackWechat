package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.g;

public final class f extends a {
    public int nGa = 0;
    public int nGb = 0;
    public int nGc = 0;
    public int nGd = 0;
    public int nGe = -9999;
    public String nGf = "";
    public int nGg = 0;
    public int nGh = 0;

    public final void start() {
        super.start();
    }

    public final void reset() {
        this.nGa = 0;
        this.nGb = 0;
        this.nGc = 0;
        this.nGd = 0;
        this.nGe = -9999;
        this.nGf = "";
        this.nGg = 0;
        this.nGh = 0;
    }

    protected final void aUb() {
        g.pQN.h(14182, new Object[]{Integer.valueOf(this.nGa), Integer.valueOf(this.nGb), Integer.valueOf(this.nGc), Integer.valueOf(this.nGd), Integer.valueOf(this.nGe), this.nGf, Integer.valueOf(this.nGg), Integer.valueOf(this.nGh)});
    }
}
