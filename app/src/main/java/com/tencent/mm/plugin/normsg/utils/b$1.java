package com.tencent.mm.plugin.normsg.utils;

import android.view.View;
import java.util.List;

class b$1 implements Runnable {
    final /* synthetic */ int oTe;
    final /* synthetic */ View oTf;
    final /* synthetic */ List oTg;
    final /* synthetic */ boolean[] oTh;
    final /* synthetic */ b oTi;

    b$1(b bVar, int i, View view, List list, boolean[] zArr) {
        this.oTi = bVar;
        this.oTe = i;
        this.oTf = view;
        this.oTg = list;
        this.oTh = zArr;
    }

    public final void run() {
        b.b(this.oTi, this.oTe, this.oTf, this.oTg);
        synchronized (this.oTh) {
            this.oTh[0] = true;
            this.oTh.notifyAll();
        }
    }
}
