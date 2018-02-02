package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.mm.modelappbrand.a.b.k;

class b$k$1 implements Runnable {
    final /* synthetic */ Bitmap hkm;
    final /* synthetic */ k hkn;

    b$k$1(k kVar, Bitmap bitmap) {
        this.hkn = kVar;
        this.hkm = bitmap;
    }

    public final void run() {
        this.hkn.j(this.hkm);
    }
}
