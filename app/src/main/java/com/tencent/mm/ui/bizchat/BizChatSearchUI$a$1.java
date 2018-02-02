package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ag.a.l;
import com.tencent.mm.ui.bizchat.BizChatSearchUI.a;
import com.tencent.mm.z.ar;

class BizChatSearchUI$a$1 implements Runnable {
    final /* synthetic */ String yoq;
    final /* synthetic */ a yor;

    BizChatSearchUI$a$1(a aVar, String str) {
        this.yor = aVar;
        this.yoq = str;
    }

    public final void run() {
        if (this.yoq.equals(a.c(this.yor))) {
            ar.CG().a(new l(a.e(this.yor), this.yoq, 0), 0);
        }
    }
}
