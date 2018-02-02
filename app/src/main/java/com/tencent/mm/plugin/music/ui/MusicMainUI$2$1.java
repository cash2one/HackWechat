package com.tencent.mm.plugin.music.ui;

import com.tencent.mm.g.a.js;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.plugin.music.ui.MusicMainUI.2;

class MusicMainUI$2$1 implements Runnable {
    final /* synthetic */ js oNQ;
    final /* synthetic */ 2 oNR;

    MusicMainUI$2$1(2 2, js jsVar) {
        this.oNR = 2;
        this.oNQ = jsVar;
    }

    public final void run() {
        if (this.oNQ.fAz.action == 0 && h.bdz().mode != 2) {
            MusicMainUI.i(this.oNR.oNP).a(MusicMainUI.h(this.oNR.oNP));
            MusicMainUI.i(this.oNR.oNP).ah(100000 + h.bdz().oJA);
        }
        MusicMainUI.j(this.oNR.oNP);
    }
}
