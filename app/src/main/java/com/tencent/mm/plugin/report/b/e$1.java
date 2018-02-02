package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;

class e$1 implements Runnable {
    final /* synthetic */ e pPZ;

    e$1(e eVar) {
        this.pPZ = eVar;
    }

    public final void run() {
        SmcLogic.OnReportResp(3, -1, null, this.pPZ.fCR);
    }
}
