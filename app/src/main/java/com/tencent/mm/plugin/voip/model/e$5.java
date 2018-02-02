package com.tencent.mm.plugin.voip.model;

import java.util.TimerTask;

class e$5 extends TimerTask {
    final /* synthetic */ e skv;

    e$5(e eVar) {
        this.skv = eVar;
    }

    public final void run() {
        e eVar = this.skv;
        eVar.sks++;
        if (this.skv.ske.spt != 0 || this.skv.sks > 10) {
            this.skv.bGx();
            this.skv.skr.cancel();
            this.skv.skr = null;
        }
    }
}
