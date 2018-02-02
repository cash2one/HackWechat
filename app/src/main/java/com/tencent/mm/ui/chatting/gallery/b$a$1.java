package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.ui.chatting.gallery.b.a;

class b$a$1 implements Runnable {
    final /* synthetic */ long yDr;
    final /* synthetic */ Boolean yDs;
    final /* synthetic */ b yDt;
    final /* synthetic */ a yDu;

    b$a$1(a aVar, long j, Boolean bool, b bVar) {
        this.yDu = aVar;
        this.yDr = j;
        this.yDs = bool;
        this.yDt = bVar;
    }

    public final void run() {
        a.a(this.yDu, this.yDr);
        if (this.yDs.booleanValue()) {
            this.yDu.handler.postDelayed(new 1(this), 0);
        }
    }
}
