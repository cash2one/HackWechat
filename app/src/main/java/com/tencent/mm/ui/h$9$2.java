package com.tencent.mm.ui;

import android.graphics.Bitmap;
import com.tencent.mm.ui.h.9;

class h$9$2 implements Runnable {
    final /* synthetic */ Bitmap kXG;
    final /* synthetic */ 9 xFB;

    h$9$2(9 9, Bitmap bitmap) {
        this.xFB = 9;
        this.kXG = bitmap;
    }

    public final void run() {
        h.a(this.xFB.xFs, true);
        this.xFB.xFy.V(this.kXG);
        if (this.xFB.xFz == 3) {
            h.a(this.xFB.xFy, 8, 8, false, 0, 0, 0);
        } else if (this.xFB.xFz == 4) {
            h.a(this.xFB.xFy, 8, 0, false, 0, 0, 0);
        }
        h.c(this.xFB.fgU, this.xFB.sPD, this.xFB.xFA, this.xFB.heX, this.xFB.xFz);
    }
}
