package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.sdk.platformtools.x;

class c$6 implements Runnable {
    final /* synthetic */ c mYA;

    c$6(c cVar) {
        this.mYA = cVar;
    }

    public final void run() {
        x.d("MicroMsg.GameWebPageContainer", "anim end : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - c.b(this.mYA))});
        this.mYA.postDelayed(new 1(this), 500);
    }
}
