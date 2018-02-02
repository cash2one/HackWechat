package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;

class o$7 implements Runnable {
    final /* synthetic */ o ysq;

    o$7(o oVar) {
        this.ysq = oVar;
    }

    public final void run() {
        synchronized (o.g(this.ysq)) {
            if (o.h(this.ysq)) {
                x.i("MicroMsg.ChattingFooterEventImpl", "jacks already stop before begin!!");
                return;
            }
            o.i(this.ysq);
            o.b(this.ysq).J(100, 100);
            o.a(this.ysq, false);
            o.c(this.ysq).J(200, 200);
            o.d(this.ysq).Cj(o.j(this.ysq).getHeight());
            d dVar = o.e(this.ysq).ysR;
            dVar.kEw = true;
            dVar.crh();
            dVar.crc();
            o.k(this.ysq);
            this.ysq.yse.setKeepScreenOn(true);
            o.f(this.ysq).yvL.FE(3);
            o.f(this.ysq).yvL.keepSignalling();
            o.crF();
            o.f(this.ysq).mK(true);
        }
    }
}
