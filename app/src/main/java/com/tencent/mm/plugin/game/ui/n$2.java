package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.sdk.platformtools.ag;
import java.util.LinkedList;

class n$2 implements Runnable {
    final /* synthetic */ LinkedList nsG;
    final /* synthetic */ n nsH;

    n$2(n nVar, LinkedList linkedList) {
        this.nsH = nVar;
        this.nsG = linkedList;
    }

    public final void run() {
        n.a(this.nsH, this.nsG);
        ag.y(new 1(this));
    }
}
