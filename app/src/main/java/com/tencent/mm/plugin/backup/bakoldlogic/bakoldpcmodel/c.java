package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public int hgg;
    public int kqB;
    public int kqC;
    private int kqD;
    int kqE;
    int kqF;
    int kqG;
    public int kqH;

    private void reset() {
        this.kqB = 0;
        this.kqC = 0;
        this.hgg = 0;
        this.kqD = 0;
        this.kqE = 0;
        this.kqF = 0;
        this.kqG = 0;
        this.kqH = 0;
    }

    public final void HT() {
        if (this.kqB == 0) {
            reset();
            return;
        }
        x.i("MicroMsg.BakPCReportor", "report: %s", new Object[]{String.format("%d,%d,%d,%d,%d,%d,%d,%d", new Object[]{Integer.valueOf(this.kqB), Integer.valueOf(this.kqC), Integer.valueOf(this.hgg), Integer.valueOf(this.kqD), Integer.valueOf(this.kqE), Integer.valueOf(this.kqF), Integer.valueOf(this.kqG), Integer.valueOf(this.kqH)})});
        g.pQN.k(11103, r0);
        reset();
    }
}
