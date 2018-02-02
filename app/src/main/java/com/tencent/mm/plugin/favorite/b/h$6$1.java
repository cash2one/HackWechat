package com.tencent.mm.plugin.favorite.b;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.favorite.b.h.6;

class h$6$1 implements Runnable {
    final /* synthetic */ Bitmap mrC;
    final /* synthetic */ 6 mrD;

    h$6$1(6 6, Bitmap bitmap) {
        this.mrD = 6;
        this.mrC = bitmap;
    }

    public final void run() {
        this.mrD.lOQ.setImageBitmap(this.mrC);
    }
}
