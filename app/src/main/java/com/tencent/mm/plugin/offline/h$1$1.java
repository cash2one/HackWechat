package com.tencent.mm.plugin.offline;

import com.tencent.mm.plugin.offline.h.1;
import com.tencent.mm.sdk.platformtools.x;

class h$1$1 implements Runnable {
    final /* synthetic */ 1 oVI;

    h$1$1(1 1) {
        this.oVI = 1;
    }

    public final void run() {
        x.d("MicroMsg.OfflineProcess", "tofutest do callback");
        this.oVI.oVH.a(this.oVI.zHU, 0, h.b(this.oVI.oVH));
        this.oVI.zHV.bJV();
    }
}
