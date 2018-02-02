package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

class s$1 implements Runnable {
    final /* synthetic */ boolean oXe = false;
    final /* synthetic */ s oXf;

    s$1(s sVar, boolean z) {
        this.oXf = sVar;
    }

    public final void run() {
        x.v("MicroMsg.WalletOfflineMsgManager", "DO NetSceneOfflineAckMsg");
        g.Dk();
        g.Di().gPJ.a(new b(this.oXe), 0);
    }
}
