package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.x;

class aq$8 implements Runnable {
    final /* synthetic */ aq qXH;

    aq$8(aq aqVar) {
        this.qXH = aqVar;
    }

    public final void run() {
        if (this.qXH.qXC != null) {
            x.i("MicroMsg.SnsVideoService", "download video finish cdnmediaId %s", new Object[]{this.qXH.qXC.hTu});
            this.qXH.qXE.remove(this.qXH.qXC.hTu);
        }
        this.qXH.qXC = null;
        this.qXH.bwb();
    }
}
