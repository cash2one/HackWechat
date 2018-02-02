package com.tencent.mm.plugin.game.gamewebview.d;

import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public d mWG;
    private String mXZ;
    private int mYa = an.getNetType(ac.getContext());
    private int mYb;
    public int mYc;
    public boolean mYd;
    public long mYe;
    public long mYf;
    public long mYg;
    public long mYh;
    public long mYi;

    public a(d dVar) {
        this.mWG = dVar;
        this.mYb = dVar.mYN.isX5Kernel ? 1 : 2;
        this.mYe = System.currentTimeMillis();
        this.mXZ = bh.ou(this.mWG.mXZ);
    }

    public final void fu(boolean z) {
        long j;
        int i = 1;
        x.d("MicroMsg.GameWebViewReportManager", "getA8keyTime = %d, success = %b", new Object[]{Long.valueOf(System.currentTimeMillis() - this.mYh), Boolean.valueOf(z)});
        String aPk = this.mWG.aPk();
        if (!z) {
            i = 0;
        }
        a(aPk, 3, r4, i, 0);
        g gVar = g.pQN;
        if (z) {
            j = 2;
        } else {
            j = 1;
        }
        gVar.a(607, j, 1, false);
    }

    public final void a(String str, int i, long j, int i2, int i3) {
        g.pQN.h(14531, new Object[]{this.mWG.aPl(), ap.BY(this.mXZ), ap.BY(str), Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(this.mYa), Integer.valueOf(this.mYb), Integer.valueOf(i3)});
    }
}
