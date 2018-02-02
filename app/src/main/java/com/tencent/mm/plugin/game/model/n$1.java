package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.model.n.b;

class n$1 implements Runnable {
    final /* synthetic */ String nbP;
    final /* synthetic */ boolean nbQ;
    final /* synthetic */ n nbR;
    final /* synthetic */ int val$event;

    n$1(n nVar, int i, String str, boolean z) {
        this.nbR = nVar;
        this.val$event = i;
        this.nbP = str;
        this.nbQ = z;
    }

    public final void run() {
        synchronized (n.aQh()) {
            for (b h : n.aQh()) {
                h.h(this.val$event, this.nbP, this.nbQ);
            }
        }
    }
}
