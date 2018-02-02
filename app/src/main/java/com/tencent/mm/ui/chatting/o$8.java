package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;

class o$8 implements Runnable {
    final /* synthetic */ o ysq;

    o$8(o oVar) {
        this.ysq = oVar;
    }

    public final void run() {
        if (o.l(this.ysq) != null) {
            o.l(this.ysq).stopTone();
            x.i("MicroMsg.ChattingFooterEventImpl", "stopTone");
        }
    }
}
