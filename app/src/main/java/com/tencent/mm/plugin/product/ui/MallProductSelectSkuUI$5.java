package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;

class MallProductSelectSkuUI$5 implements Runnable {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ MallProductSelectSkuUI pgr;

    MallProductSelectSkuUI$5(MallProductSelectSkuUI mallProductSelectSkuUI, Bitmap bitmap) {
        this.pgr = mallProductSelectSkuUI;
        this.jsN = bitmap;
    }

    public final void run() {
        MallProductSelectSkuUI.e(this.pgr).setImageBitmap(this.jsN);
    }
}
