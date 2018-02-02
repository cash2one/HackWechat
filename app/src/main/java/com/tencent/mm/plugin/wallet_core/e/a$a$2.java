package com.tencent.mm.plugin.wallet_core.e;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.plugin.wallet_core.e.a.a;

class a$a$2 implements Runnable {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ ImageView lOQ;
    final /* synthetic */ a sYG;

    a$a$2(a aVar, ImageView imageView, Bitmap bitmap) {
        this.sYG = aVar;
        this.lOQ = imageView;
        this.jsN = bitmap;
    }

    public final void run() {
        this.lOQ.setImageBitmap(this.jsN);
    }
}
