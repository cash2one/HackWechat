package com.tencent.mm.plugin.appbrand;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.d;

class s$3 extends bc<Bitmap> {
    final /* synthetic */ e iCN;

    s$3(e eVar) {
        this.iCN = eVar;
        super(500, null);
    }

    protected final /* synthetic */ Object run() {
        View aiT = this.iCN.iqC.aiT();
        if (aiT.getWidth() == 0 || aiT.getHeight() == 0) {
            return null;
        }
        Object createBitmap = Bitmap.createBitmap(aiT.getWidth(), aiT.getHeight(), Config.ARGB_8888);
        d.a(new Canvas(createBitmap), aiT);
        return createBitmap;
    }
}
