package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.pluginsdk.q$f;

class g$2 implements Runnable {
    final /* synthetic */ g oGJ;
    final /* synthetic */ q$f oGK;
    final /* synthetic */ String oGL;

    g$2(g gVar, q$f com_tencent_mm_pluginsdk_q_f, String str) {
        this.oGJ = gVar;
        this.oGK = com_tencent_mm_pluginsdk_q_f;
        this.oGL = str;
    }

    public final void run() {
        this.oGK.Rk(this.oGL);
    }
}
