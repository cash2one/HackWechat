package com.tencent.mm.plugin.ext.openapi.provider;

import com.tencent.mm.g.a.ew;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi.1;
import com.tencent.mm.sdk.platformtools.x;

class ExtControlProviderOpenApi$1$1 implements Runnable {
    final /* synthetic */ ew lZY;
    final /* synthetic */ 1 lZZ;

    ExtControlProviderOpenApi$1$1(1 1, ew ewVar) {
        this.lZZ = 1;
        this.lZY = ewVar;
    }

    public final void run() {
        x.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList run");
        if (this.lZY != null && this.lZY.ftL != null && this.lZY.ftL.ftr != 0) {
            x.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList return cursor");
            this.lZZ.bX(this.lZY.ftL.ftN);
        }
    }
}
