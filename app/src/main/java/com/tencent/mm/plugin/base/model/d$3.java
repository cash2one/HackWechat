package com.tencent.mm.plugin.base.model;

import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.n;
import com.tencent.mm.sdk.platformtools.x;

class d$3 implements Runnable {
    final /* synthetic */ String gIT;
    final /* synthetic */ d$a kuG;
    final /* synthetic */ a kuI;

    d$3(a aVar, d$a com_tencent_mm_plugin_base_model_d_a, String str) {
        this.kuI = aVar;
        this.kuG = com_tencent_mm_plugin_base_model_d_a;
        this.gIT = str;
    }

    public final void run() {
        x.i("MicroMsg.WebviewShrotcutManager", "expired");
        if (d.JL().contains(this.kuI)) {
            d.JL().remove(this.kuI);
            n.Jz().b(this.kuI);
            if (this.kuG != null) {
                this.kuG.dO(false);
            }
        }
    }
}
