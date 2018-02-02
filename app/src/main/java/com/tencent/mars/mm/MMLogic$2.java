package com.tencent.mars.mm;

import com.tencent.mm.network.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class MMLogic$2 implements Runnable {
    final /* synthetic */ b val$monitor;
    final /* synthetic */ int val$mr;
    final /* synthetic */ int val$ms;
    final /* synthetic */ int val$wr;
    final /* synthetic */ int val$ws;

    MMLogic$2(b bVar, int i, int i2, int i3, int i4) {
        this.val$monitor = bVar;
        this.val$wr = i;
        this.val$ws = i2;
        this.val$mr = i3;
        this.val$ms = i4;
    }

    public final void run() {
        try {
            this.val$monitor.j(this.val$wr, this.val$ws, this.val$mr, this.val$ms);
        } catch (Throwable th) {
            x.e("C2Java", "reportFlowData :%s", new Object[]{bh.i(th)});
        }
    }
}
