package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.ui.n.2;
import com.tencent.mm.sdk.platformtools.x;

class n$2$1 implements Runnable {
    final /* synthetic */ 2 nsJ;

    n$2$1(2 2) {
        this.nsJ = 2;
    }

    public final void run() {
        n.c(this.nsJ.nsH, this.nsJ.nsG);
        x.i("MicroMsg.GameListAdapter", "set size: %d", new Object[]{Integer.valueOf(this.nsJ.nsG.size())});
    }
}
