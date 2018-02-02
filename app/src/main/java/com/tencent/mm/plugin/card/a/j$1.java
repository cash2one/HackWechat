package com.tencent.mm.plugin.card.a;

import com.tencent.mm.sdk.platformtools.x;

class j$1 implements Runnable {
    final /* synthetic */ int hLI;
    final /* synthetic */ String kJw;
    final /* synthetic */ int kJx = 0;
    final /* synthetic */ int kJy = 0;
    final /* synthetic */ j kJz;

    j$1(j jVar, String str, int i, int i2, int i3) {
        this.kJz = jVar;
        this.kJw = str;
        this.hLI = i3;
    }

    public final void run() {
        j.g(this.kJw, this.kJx, this.kJy, this.hLI);
        x.i("MicroMsg.CardMarkCodeMgr", "run the unmark task, the card is " + this.kJw + " system.time:" + System.currentTimeMillis());
    }
}
