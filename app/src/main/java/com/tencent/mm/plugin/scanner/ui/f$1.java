package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;

class f$1 implements Runnable {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ f pVu;

    f$1(f fVar, Bitmap bitmap) {
        this.pVu = fVar;
        this.jsN = bitmap;
    }

    public final void run() {
        f.a(this.pVu).setImageBitmap(this.jsN);
        f.a(this.pVu).setBackgroundColor(0);
        if (f.b(this.pVu) != null) {
            f.b(this.pVu).notifyDataSetChanged();
        }
    }
}
