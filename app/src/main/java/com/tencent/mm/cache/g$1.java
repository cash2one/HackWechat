package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements Runnable {
    final /* synthetic */ Bitmap gBE;
    final /* synthetic */ String gBF;
    final /* synthetic */ g gBG;

    public g$1(g gVar, Bitmap bitmap, String str) {
        this.gBG = gVar;
        this.gBE = bitmap;
        this.gBF = str;
    }

    public final void run() {
        try {
            d.a(this.gBE, 50, CompressFormat.PNG, this.gBF, true);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MosaicCache", e, "", new Object[0]);
        }
    }
}
