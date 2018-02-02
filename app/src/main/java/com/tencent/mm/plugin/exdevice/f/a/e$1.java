package com.tencent.mm.plugin.exdevice.f.a;

import android.content.Context;
import android.widget.ImageView;

class e$1 implements Runnable {
    final /* synthetic */ ImageView lOQ;
    final /* synthetic */ int lOR;
    final /* synthetic */ Context val$context;
    final /* synthetic */ String val$url;

    e$1(Context context, ImageView imageView, String str, int i) {
        this.val$context = context;
        this.lOQ = imageView;
        this.val$url = str;
        this.lOR = i;
    }

    public final void run() {
        e.b(this.lOQ, this.val$url, this.lOR);
    }
}
