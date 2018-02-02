package com.tencent.mm.plugin.webview.fts.topstory.a;

import com.tencent.mm.plugin.webview.fts.topstory.a.e.b;

class e$b$3 implements Runnable {
    final /* synthetic */ int hBA;
    final /* synthetic */ int htd;
    final /* synthetic */ b tnZ;
    final /* synthetic */ String uS;

    e$b$3(b bVar, String str, int i, int i2) {
        this.tnZ = bVar;
        this.uS = str;
        this.htd = i;
        this.hBA = i2;
    }

    public final void run() {
        if (e.c(this.tnZ.tnX) != null && e.c(this.tnZ.tnX, this.uS)) {
            e.c(this.tnZ.tnX).g(this.uS, this.htd, this.hBA);
        }
    }
}
