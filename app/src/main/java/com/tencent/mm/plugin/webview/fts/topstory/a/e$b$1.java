package com.tencent.mm.plugin.webview.fts.topstory.a;

import com.tencent.mm.plugin.webview.fts.topstory.a.e.b;

class e$b$1 implements Runnable {
    final /* synthetic */ int htd;
    final /* synthetic */ int hte;
    final /* synthetic */ b tnZ;
    final /* synthetic */ String uS;

    e$b$1(b bVar, String str, int i, int i2) {
        this.tnZ = bVar;
        this.uS = str;
        this.htd = i;
        this.hte = i2;
    }

    public final void run() {
        if (e.c(this.tnZ.tnX) != null && e.c(this.tnZ.tnX, this.uS)) {
            e.c(this.tnZ.tnX).iG(this.htd);
        }
    }
}
