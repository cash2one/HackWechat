package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;

class m$1 implements Runnable {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ m pgF;

    m$1(m mVar, Bitmap bitmap) {
        this.pgF = mVar;
        this.jsN = bitmap;
    }

    public final void run() {
        this.pgF.jNs.setImageBitmap(this.jsN);
    }
}
