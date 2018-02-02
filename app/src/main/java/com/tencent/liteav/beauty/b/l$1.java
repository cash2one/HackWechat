package com.tencent.liteav.beauty.b;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.d.e;

class l$1 implements Runnable {
    final /* synthetic */ Bitmap a;
    final /* synthetic */ l b;

    l$1(l lVar, Bitmap bitmap) {
        this.b = lVar;
        this.a = bitmap;
    }

    public void run() {
        if (this.a != null) {
            this.b.u = e.a(this.a, this.b.u, false);
        }
    }
}
