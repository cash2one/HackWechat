package com.tencent.mm.plugin.base.model;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak.b.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class d$1 implements a {
    final /* synthetic */ String gIT;
    final /* synthetic */ String jde;
    final /* synthetic */ d$a kuG;
    final /* synthetic */ Context val$context;

    d$1(d$a com_tencent_mm_plugin_base_model_d_a, String str, Context context, String str2) {
        this.kuG = com_tencent_mm_plugin_base_model_d_a;
        this.gIT = str;
        this.val$context = context;
        this.jde = str2;
    }

    public final void v(String str, boolean z) {
        x.i("MicroMsg.WebviewShrotcutManager", "getContactCallBack, suc = %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            ar.Hg();
            com.tencent.mm.storage.x WO = c.EY().WO(this.gIT);
            if (WO != null && !bh.ov(WO.AP())) {
                d.a(this.val$context, this.gIT, this.jde, WO.AP(), this.kuG);
            } else if (this.kuG != null) {
                this.kuG.dO(false);
            }
        } else if (this.kuG != null) {
            this.kuG.dO(false);
        }
    }
}
