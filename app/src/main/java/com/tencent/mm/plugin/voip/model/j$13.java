package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.x;

class j$13 implements Runnable {
    final /* synthetic */ j smu;

    j$13(j jVar) {
        this.smu = jVar;
    }

    public final void run() {
        x.d("MicroMsg.Voip.VoipMgr", "mCaptureRender == " + j.c(this.smu));
        if (j.c(this.smu) != null) {
            j.c(this.smu).bIv();
        }
    }
}
