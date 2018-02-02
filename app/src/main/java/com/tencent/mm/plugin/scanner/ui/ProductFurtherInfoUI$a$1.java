package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.a;

class ProductFurtherInfoUI$a$1 implements Runnable {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ ImageView lOQ;
    final /* synthetic */ a pVG;

    ProductFurtherInfoUI$a$1(a aVar, ImageView imageView, Bitmap bitmap) {
        this.pVG = aVar;
        this.lOQ = imageView;
        this.jsN = bitmap;
    }

    public final void run() {
        this.lOQ.setImageBitmap(this.jsN);
        this.lOQ.setBackgroundColor(0);
    }
}
