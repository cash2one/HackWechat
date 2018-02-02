package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.app.f;

class a$4 implements Runnable {
    final /* synthetic */ a jPj;
    final /* synthetic */ long jPk;

    a$4(a aVar, long j) {
        this.jPj = aVar;
        this.jPk = j;
    }

    public final void run() {
        this.jPj.runOnUiThread(new 1(this, a.k(this.jPj).k(f.Zm().iKb.e(this.jPk, 30))));
    }
}
