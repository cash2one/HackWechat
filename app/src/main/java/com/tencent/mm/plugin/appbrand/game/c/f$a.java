package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.mm.sdk.platformtools.ak.a;

class f$a implements a {
    final /* synthetic */ f iZf;

    private f$a(f fVar) {
        this.iZf = fVar;
    }

    public final boolean uF() {
        synchronized (this.iZf) {
            this.iZf.iZd = (int) Math.round(this.iZf.iZc.aju());
        }
        return true;
    }
}
