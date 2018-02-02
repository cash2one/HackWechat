package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;

class MallProductUI$8 implements Runnable {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ MallProductUI phb;

    MallProductUI$8(MallProductUI mallProductUI, Bitmap bitmap) {
        this.phb = mallProductUI;
        this.jsN = bitmap;
    }

    public final void run() {
        MallProductUI.g(this.phb).setImageBitmap(this.jsN);
    }
}
