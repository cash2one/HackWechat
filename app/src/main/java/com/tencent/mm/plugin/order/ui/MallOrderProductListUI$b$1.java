package com.tencent.mm.plugin.order.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.order.ui.MallOrderProductListUI.b;

class MallOrderProductListUI$b$1 implements Runnable {
    final /* synthetic */ b pco;
    final /* synthetic */ Bitmap val$bmp;

    MallOrderProductListUI$b$1(b bVar, Bitmap bitmap) {
        this.pco = bVar;
        this.val$bmp = bitmap;
    }

    public final void run() {
        this.pco.kUM.setImageBitmap(this.val$bmp);
    }
}
