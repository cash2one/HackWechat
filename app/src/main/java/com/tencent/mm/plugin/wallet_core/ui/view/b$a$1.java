package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.wallet_core.ui.view.b.a;

class b$a$1 implements Runnable {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ a sXm;

    b$a$1(a aVar, Bitmap bitmap) {
        this.sXm = aVar;
        this.jsN = bitmap;
    }

    public final void run() {
        this.sXm.sCa.setImageBitmap(this.jsN);
        this.sXm.sXh.invalidate();
    }
}
