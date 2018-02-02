package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.ui.chatting.viewitems.b.b;

class b$b$1 implements Runnable {
    final /* synthetic */ b yIC;

    b$b$1(b bVar) {
        this.yIC = bVar;
    }

    public final void run() {
        this.yIC.ysf.notifyDataSetChanged();
    }
}
