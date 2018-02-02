package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.mm.plugin.clean.c.j;

class CleanNewUI$8 implements Runnable {
    final /* synthetic */ CleanNewUI lhD;
    final /* synthetic */ long lhF;

    CleanNewUI$8(CleanNewUI cleanNewUI, long j) {
        this.lhD = cleanNewUI;
        this.lhF = j;
    }

    public final void run() {
        CleanNewUI cleanNewUI = this.lhD;
        long j = this.lhF;
        j.ayv();
        CleanNewUI.a(cleanNewUI, j, j.ayc());
    }
}
