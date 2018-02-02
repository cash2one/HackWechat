package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;

class MallProductSubmitUI$7 implements Runnable {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ MallProductSubmitUI pgR;

    MallProductSubmitUI$7(MallProductSubmitUI mallProductSubmitUI, Bitmap bitmap) {
        this.pgR = mallProductSubmitUI;
        this.jsN = bitmap;
    }

    public final void run() {
        MallProductSubmitUI.e(this.pgR).setImageBitmap(this.jsN);
    }
}
