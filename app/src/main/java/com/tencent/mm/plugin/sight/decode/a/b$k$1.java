package com.tencent.mm.plugin.sight.decode.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.tencent.mm.plugin.sight.decode.a.b.k;

class b$k$1 implements Runnable {
    final /* synthetic */ View quh;
    final /* synthetic */ Bitmap qui;
    final /* synthetic */ k quj;

    b$k$1(k kVar, View view, Bitmap bitmap) {
        this.quj = kVar;
        this.quh = view;
        this.qui = bitmap;
    }

    public final void run() {
        this.quh.setBackgroundDrawable(new BitmapDrawable(this.qui));
    }
}
