package com.tencent.mm.plugin.webview.fts.topstory.a;

import com.tencent.mm.plugin.webview.fts.topstory.a.e.b;

class e$b$4 implements Runnable {
    final /* synthetic */ b tnZ;
    final /* synthetic */ int toa;
    final /* synthetic */ String uS;

    e$b$4(b bVar, String str, int i) {
        this.tnZ = bVar;
        this.uS = str;
        this.toa = i;
    }

    public final void run() {
        if (e.c(this.tnZ.tnX) != null && e.c(this.tnZ.tnX, this.uS)) {
            e.c(this.tnZ.tnX).K(this.uS, this.toa);
        }
    }
}
