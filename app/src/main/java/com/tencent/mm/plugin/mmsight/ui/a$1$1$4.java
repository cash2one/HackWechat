package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.mmsight.ui.a.1.1;
import com.tencent.mm.plugin.u.a.f;
import com.tencent.mm.ui.base.h;

class a$1$1$4 implements Runnable {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ 1 oBW;

    a$1$1$4(1 1, Bitmap bitmap) {
        this.oBW = 1;
        this.jsN = bitmap;
    }

    public final void run() {
        this.oBW.oBV.oBU.ilH = h.a(this.oBW.oBV.oBU.fmM, this.oBW.oBV.oBU.fmM.getString(f.oFj), false, null);
        this.oBW.oBV.oBU.oxz.pause();
        a.a(this.oBW.oBV.oBU, this.jsN);
    }
}
