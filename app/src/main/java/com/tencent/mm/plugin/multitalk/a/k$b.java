package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.plugin.multitalk.a.k.c;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.x;

protected class k$b implements Runnable {
    final /* synthetic */ k oHh;
    private c oHi;

    public k$b(k kVar, c cVar) {
        this.oHh = kVar;
        this.oHi = cVar;
    }

    public final void run() {
        if (this.oHi != null) {
            x.d("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "draw user %s threadId %d", new Object[]{this.oHi.username, Long.valueOf(Thread.currentThread().getId())});
            if (this.oHh.oGq != null) {
                this.oHh.oGq.a(this.oHi.username, this.oHi.oHj, this.oHi.oHl, this.oHi.oHm, OpenGlRender.sui);
            }
            try {
                this.oHh.oHa.put(this.oHi);
            } catch (InterruptedException e) {
            }
        }
    }
}
