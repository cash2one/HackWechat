package com.tencent.mm.plugin.appbrand;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.appbrand.ui.l.a;

class s$2 implements Runnable {
    final /* synthetic */ e iCN;
    final /* synthetic */ Bitmap iCO;

    s$2(e eVar, Bitmap bitmap) {
        this.iCN = eVar;
        this.iCO = bitmap;
    }

    public final void run() {
        a.a(this.iCN, this.iCO);
        e eVar = this.iCN;
        eVar.iqw.abT();
        eVar.reload();
    }
}
