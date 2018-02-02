package com.tencent.mm.plugin.favorite.ui.b;

import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.protocal.c.uq;

class e$1 implements Runnable {
    final /* synthetic */ f mxX;
    final /* synthetic */ uq mxY;

    e$1(f fVar, uq uqVar) {
        this.mxX = fVar;
        this.mxY = uqVar;
    }

    public final void run() {
        j.b(this.mxX, this.mxY, true);
    }
}
