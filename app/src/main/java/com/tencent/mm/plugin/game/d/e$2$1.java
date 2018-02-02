package com.tencent.mm.plugin.game.d;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.game.d.e.2;

class e$2$1 implements Runnable {
    final /* synthetic */ Bitmap nxm;
    final /* synthetic */ 2 nxn;

    e$2$1(2 2, Bitmap bitmap) {
        this.nxn = 2;
        this.nxm = bitmap;
    }

    public final void run() {
        if (this.nxn.jlT != null) {
            this.nxn.jlT.setImageBitmap(this.nxm);
        }
    }
}
