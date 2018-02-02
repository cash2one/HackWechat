package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.sight.draft.ui.c.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import java.lang.ref.WeakReference;

final class c$a implements Runnable {
    String aAM;
    String path;
    boolean qvX;
    WeakReference<c> qvY;

    private c$a() {
    }

    public final void run() {
        Bitmap UN = d.UN(this.path);
        c cVar = (c) this.qvY.get();
        if (cVar != null) {
            if (!(bh.ov(this.aAM) || UN == null)) {
                cVar.qvV.put(this.aAM, UN);
            }
            Runnable bVar = new b((byte) 0);
            bVar.aAM = this.aAM;
            bVar.mTJ = UN;
            bVar.qvY = this.qvY;
            if (this.qvX) {
                ag.y(bVar);
            }
        }
    }
}
