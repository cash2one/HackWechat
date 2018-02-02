package com.tencent.mm.ui.base;

import android.view.Window;
import com.tencent.mm.sdk.platformtools.ag;

class u$5 implements Runnable {
    final /* synthetic */ Window jNi;
    final /* synthetic */ q yek;
    final /* synthetic */ int yel;

    u$5(q qVar, Window window, int i) {
        this.yek = qVar;
        this.jNi = window;
        this.yel = i;
    }

    public final void run() {
        ag.y(new 1(this));
    }
}
