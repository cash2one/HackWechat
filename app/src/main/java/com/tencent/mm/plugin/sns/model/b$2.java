package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.a.f;

class b$2 implements Runnable {
    final /* synthetic */ b$b qSF;
    final /* synthetic */ b qSG;

    b$2(b bVar, b$b com_tencent_mm_plugin_sns_model_b_b) {
        this.qSG = bVar;
        this.qSF = com_tencent_mm_plugin_sns_model_b_b;
    }

    public final void run() {
        e eVar = this.qSG;
        eVar.gCl.remove(this.qSF);
        int i = b.qSu - 1;
        b.qSu = i;
        if (i <= 0) {
            g.Dk();
            g.Di().gPJ.b(f.CTRL_INDEX, eVar);
        }
    }
}
