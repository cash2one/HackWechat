package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.x;

class e$5 implements Runnable {
    final /* synthetic */ int kI;
    final /* synthetic */ e yEz;

    e$5(e eVar, int i) {
        this.yEz = eVar;
        this.kI = i;
    }

    public final void run() {
        if (e.b(this.yEz) == null) {
            x.e("MicroMsg.ImageGalleryLazyLoader", "loader is null!");
            return;
        }
        final Bitmap FZ = e.b(this.yEz).FZ(this.kI);
        if (FZ != null) {
            e.c(this.yEz).post(new Runnable(this) {
                final /* synthetic */ e$5 yEB;

                public final void run() {
                    this.yEB.yEz.yEw.put(Integer.valueOf(this.yEB.kI), FZ);
                }
            });
        }
    }
}
