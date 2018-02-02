package com.tencent.mm.ui.chatting.b;

class w$4 implements Runnable {
    final /* synthetic */ int hvX;
    final /* synthetic */ w yBn;

    w$4(w wVar, int i) {
        this.yBn = wVar;
        this.hvX = i;
    }

    public final void run() {
        w.a(this.yBn).af(this.hvX, true);
    }
}
