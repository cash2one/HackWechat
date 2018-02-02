package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;

class a$1 implements Runnable {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ a pTM;

    a$1(a aVar, Bitmap bitmap) {
        this.pTM = aVar;
        this.jsN = bitmap;
    }

    public final void run() {
        a.a(this.pTM).setImageBitmap(this.jsN);
        a.a(this.pTM).setVisibility(0);
        if (a.b(this.pTM) != null) {
            a.b(this.pTM).notifyDataSetChanged();
        }
    }
}
