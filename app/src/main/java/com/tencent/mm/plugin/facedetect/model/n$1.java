package com.tencent.mm.plugin.facedetect.model;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class n$1 implements Runnable {
    final /* synthetic */ Bitmap mhj;
    final /* synthetic */ String mhk;

    n$1(Bitmap bitmap, String str) {
        this.mhj = bitmap;
        this.mhk = str;
    }

    public final void run() {
        long Wq = bh.Wq();
        n.b(this.mhj, this.mhk);
        x.i("MicroMsg.FaceUtils", "hy: saving blur bm using: %d ms", new Object[]{Long.valueOf(bh.bA(Wq))});
    }
}
