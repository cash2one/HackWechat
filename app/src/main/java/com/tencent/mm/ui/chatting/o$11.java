package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.b.t;

class o$11 implements Runnable {
    final /* synthetic */ boolean iij = true;
    final /* synthetic */ o ysq;
    final /* synthetic */ boolean ysr;

    o$11(o oVar, boolean z, boolean z2) {
        this.ysq = oVar;
        this.ysr = z2;
    }

    public final void run() {
        int lastVisiblePosition = o.j(this.ysq).getLastVisiblePosition();
        int count = o.j(this.ysq).getCount() - 1;
        x.v("MicroMsg.ChattingFooterEventImpl", "last visible/adapter=" + lastVisiblePosition + "/" + count + " " + this.iij);
        if (lastVisiblePosition >= count - 1 || this.iij) {
            lastVisiblePosition = o.e(this.ysq).getCount();
            if (lastVisiblePosition <= 1 || !((au) o.e(this.ysq).getItem(lastVisiblePosition - 2)).isSystem()) {
                t.a(o.j(this.ysq), count, this.ysr);
                return;
            }
            t.a(o.j(this.ysq), count - 1, 0, this.ysr);
        }
    }
}
