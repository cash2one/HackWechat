package com.tencent.mm.ui.base;

import com.tencent.mm.ui.base.MMTagPanel.c;
import com.tencent.mm.ui.tools.h;

class MMTagPanel$c$1 implements Runnable {
    final /* synthetic */ c yeb;

    MMTagPanel$c$1(c cVar) {
        this.yeb = cVar;
    }

    public final void run() {
        MMTagPanel.e(this.yeb.ydR).j(MMTagPanel.i(this.yeb.ydR), h.aY(c.a(this.yeb), ""));
    }
}
