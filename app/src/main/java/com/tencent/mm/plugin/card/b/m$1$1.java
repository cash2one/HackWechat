package com.tencent.mm.plugin.card.b;

import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import com.tencent.mm.plugin.card.b.m.1;

class m$1$1 implements Runnable {
    final /* synthetic */ Bitmap kXG;
    final /* synthetic */ 1 kXH;

    m$1$1(1 1, Bitmap bitmap) {
        this.kXH = 1;
        this.kXG = bitmap;
    }

    public final void run() {
        this.kXH.kXE.setImageBitmap(this.kXG);
        this.kXH.kXE.setColorFilter(this.kXH.irj, Mode.SRC_IN);
    }
}
