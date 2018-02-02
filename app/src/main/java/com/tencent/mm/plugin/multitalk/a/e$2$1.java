package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.plugin.multitalk.a.e.2;
import com.tencent.mm.plugin.multitalk.a.i.a;
import com.tencent.mm.sdk.platformtools.x;

class e$2$1 implements Runnable {
    final /* synthetic */ 2 oGA;

    e$2$1(2 2) {
        this.oGA = 2;
    }

    public final void run() {
        a bcN = i.bcN();
        if (bcN != this.oGA.oGz.oGr) {
            a aVar = this.oGA.oGz.oGr;
            this.oGA.oGz.oGr = bcN;
            x.i("MicroMsg.MT.MultiTalkManager", "steve: network change: %s -> %s", new Object[]{aVar.name(), this.oGA.oGz.oGr.name()});
            this.oGA.oGz.tg(this.oGA.oGz.oGe);
            if (this.oGA.oGz.oGq != null) {
                this.oGA.oGz.oGq.a(this.oGA.oGz.oGr);
                return;
            }
            return;
        }
        x.i("MicroMsg.MT.MultiTalkManager", "network not change: %s", new Object[]{this.oGA.oGz.oGr.name()});
    }
}
