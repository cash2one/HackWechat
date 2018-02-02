package com.tencent.mm.ui.base;

import android.app.Dialog;
import com.tencent.mm.ui.base.h.14;

class h$14$1 implements Runnable {
    final /* synthetic */ int xYU;
    final /* synthetic */ 14 xYV;

    h$14$1(14 14, int i) {
        this.xYV = 14;
        this.xYU = i;
    }

    public final void run() {
        ((Dialog) this.xYV.qio.getTag()).dismiss();
        if (this.xYV.xYT != null) {
            this.xYV.xYT.vm(this.xYU);
        }
    }
}
