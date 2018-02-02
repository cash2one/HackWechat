package com.tencent.mm.plugin.sight.decode.a;

import android.view.View;

class b$d implements Runnable {
    final /* synthetic */ b qtU;

    private b$d(b bVar) {
        this.qtU = bVar;
    }

    public final void run() {
        if (b.k(this.qtU).get() != null) {
            ((View) b.k(this.qtU).get()).startAnimation(b.l(this.qtU));
        }
    }
}
