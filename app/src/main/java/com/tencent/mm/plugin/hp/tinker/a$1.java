package com.tencent.mm.plugin.hp.tinker;

import com.tencent.tinker.lib.f.a;

class a$1 implements Runnable {
    final /* synthetic */ a$a nBd;
    final /* synthetic */ a nBe;

    a$1(a aVar, a$a com_tencent_mm_plugin_hp_tinker_a_a) {
        this.nBe = aVar;
        this.nBd = com_tencent_mm_plugin_hp_tinker_a_a;
    }

    public final void run() {
        if (this.nBd != null) {
            a.i("Tinker.ScreenOffRetryPatch", "ScreenOffRetryPatch runnable try to start", new Object[0]);
            this.nBd.aSB();
        }
    }
}
