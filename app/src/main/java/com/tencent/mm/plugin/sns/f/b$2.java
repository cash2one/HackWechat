package com.tencent.mm.plugin.sns.f;

import android.view.View;

class b$2 implements Runnable {
    final /* synthetic */ View qZG;
    final /* synthetic */ b qZH;
    final /* synthetic */ View zS;

    b$2(b bVar, View view, View view2) {
        this.qZH = bVar;
        this.zS = view;
        this.qZG = view2;
    }

    public final void run() {
        b.a(this.qZH, this.zS, this.qZG);
    }
}
