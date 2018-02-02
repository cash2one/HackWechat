package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.sdk.platformtools.x;

class c$2 implements Runnable {
    final /* synthetic */ boolean[] jDq;
    final /* synthetic */ c mYA;
    final /* synthetic */ b mYB;
    final /* synthetic */ b mYC;

    c$2(c cVar, boolean[] zArr, b bVar, b bVar2) {
        this.mYA = cVar;
        this.jDq = zArr;
        this.mYB = bVar;
        this.mYC = bVar2;
    }

    public final void run() {
        boolean z = true;
        x.i("MicroMsg.GameWebPageContainer", "loadUrl costTime = %d", new Object[]{Long.valueOf(System.currentTimeMillis() - c.b(this.mYA))});
        if (!this.jDq[0]) {
            this.jDq[0] = true;
            synchronized (this.mYA) {
                if (this.mYB != null) {
                    c cVar = this.mYA;
                    b bVar = this.mYB;
                    boolean booleanExtra = c.c(this.mYA).getBooleanExtra("finish_recent_page", false);
                    if (c.c(this.mYA).getBooleanExtra("transparent_page", false)) {
                        z = false;
                    }
                    c.a(cVar, bVar, booleanExtra, z);
                }
                c.a(this.mYA, this.mYC);
            }
        }
    }
}
