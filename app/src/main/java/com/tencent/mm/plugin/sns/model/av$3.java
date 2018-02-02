package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.model.av.a;
import com.tencent.mm.sdk.platformtools.x;

class av$3 implements Runnable {
    final /* synthetic */ boolean hyi;
    final /* synthetic */ av qXV;
    final /* synthetic */ int qXW;

    av$3(av avVar, int i, boolean z) {
        this.qXV = avVar;
        this.qXW = i;
        this.hyi = z;
    }

    public final void run() {
        if (ae.bve()) {
            x.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
            return;
        }
        for (a aVar : av.c(this.qXV)) {
            if (aVar != null) {
                aVar.L(this.qXW, this.hyi);
            }
        }
    }
}
