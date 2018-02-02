package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.magicbrush.handler.a;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.game.c;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ e iCN;

    public b$1(e eVar) {
        this.iCN = eVar;
    }

    public final void e(Runnable runnable) {
        if (this.iCN.iqC == null || this.iCN.iqC.aiT() == null || this.iCN.iqC.aiT().aex() == null) {
            x.e("MicroMsg.MBImageHandlerRegistry", "runOnRenderThread NPE Error");
            return;
        }
        p aex = this.iCN.iqC.aiT().aex();
        if (aex instanceof c) {
            ((c) aex).e(runnable);
        } else {
            x.e("MicroMsg.MBImageHandlerRegistry", "runOnRenderThread can't find the IRenderThreadHandler");
        }
    }
}
