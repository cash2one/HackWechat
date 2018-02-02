package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;

final class c$b implements Runnable {
    String aAM;
    Bitmap mTJ;
    WeakReference<c> qvY;

    private c$b() {
    }

    public final void run() {
        c cVar = (c) this.qvY.get();
        if (cVar != null) {
            cVar.r(this.aAM, this.mTJ);
        }
    }
}
