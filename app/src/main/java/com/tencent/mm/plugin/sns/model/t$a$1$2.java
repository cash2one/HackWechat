package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.model.t.a.1;
import com.tencent.mm.protocal.c.ol;

class t$a$1$2 implements Runnable {
    final /* synthetic */ ol qUx;
    final /* synthetic */ 1 qUy;

    t$a$1$2(1 1, ol olVar) {
        this.qUy = 1;
        this.qUx = olVar;
    }

    public final void run() {
        if (!this.qUy.qUw.qUt.b(this.qUx, this.qUy.qUw.mqK)) {
            this.qUy.qUw.mqK.sendEmptyMessage(0);
        }
    }
}
