package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareResult;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandPrepareTask$a$2 implements g {
    final /* synthetic */ i jxb;
    final /* synthetic */ a jxd;
    final /* synthetic */ d jxf;

    AppBrandPrepareTask$a$2(a aVar, i iVar, d dVar) {
        this.jxd = aVar;
        this.jxb = iVar;
        this.jxf = dVar;
    }

    public final void ul() {
        com.tencent.mm.kernel.g.Dh();
        boolean Cx = com.tencent.mm.kernel.a.Cx();
        boolean Cs = com.tencent.mm.kernel.a.Cs();
        if (!Cx || Cs) {
            x.i("MicroMsg.AppBrandPrepareTask", "prepareCall, startup done, hasLogin %B, hold %B", Boolean.valueOf(Cx), Boolean.valueOf(Cs));
            ag.y(new 1(this));
            if (this.jxb != null) {
                PrepareResult prepareResult = new PrepareResult();
                PrepareResult.a(prepareResult, 3);
                this.jxb.as(prepareResult);
                return;
            }
            return;
        }
        c 2 = new 2(this);
        if (com.tencent.mm.kernel.g.Dh().gPy) {
            2.a(null);
            return;
        }
        x.i("MicroMsg.AppBrandPrepareTask", "prepareCall account not notifyAllDone yet, wait for it");
        2.ceO();
    }

    public final void aG(boolean z) {
    }
}
