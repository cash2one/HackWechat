package com.tencent.mm.plugin.offline;

import com.tencent.mm.sdk.platformtools.x;

class i$b implements Runnable {
    final /* synthetic */ i oVU;

    private i$b(i iVar) {
        this.oVU = iVar;
    }

    public final void run() {
        x.i("MicroMsg.OfflineTokensMgr", "mUpdateTokenRunnable, do doNetSceneToken");
        this.oVU.de(6, 6);
    }
}
