package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.plugin.base.model.d;
import com.tencent.mm.sdk.platformtools.ac;

class al$1 implements Runnable {
    final /* synthetic */ String fgU;
    final /* synthetic */ String gIT;
    final /* synthetic */ al ttq;

    al$1(al alVar, String str, String str2) {
        this.ttq = alVar;
        this.gIT = str;
        this.fgU = str2;
    }

    public final void run() {
        d.a(ac.getContext(), this.gIT, this.fgU, null);
    }
}
