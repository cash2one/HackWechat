package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class n$1 implements Runnable {
    final /* synthetic */ LinkedList nsG;
    final /* synthetic */ n nsH;

    n$1(n nVar, LinkedList linkedList) {
        this.nsH = nVar;
        this.nsG = linkedList;
    }

    public final void run() {
        n.a(this.nsH, this.nsG);
        ag.y(new Runnable(this) {
            final /* synthetic */ n$1 nsI;

            {
                this.nsI = r1;
            }

            public final void run() {
                n.b(this.nsI.nsH, this.nsI.nsG);
                x.i("MicroMsg.GameListAdapter", "add size: %d", new Object[]{Integer.valueOf(this.nsI.nsG.size())});
            }
        });
    }
}
