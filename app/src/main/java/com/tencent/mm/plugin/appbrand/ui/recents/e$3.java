package com.tencent.mm.plugin.appbrand.ui.recents;

class e$3 implements Runnable {
    final /* synthetic */ e jQw;

    e$3(e eVar) {
        this.jQw = eVar;
    }

    public final void run() {
        e.a(this.jQw);
        if (e.b(this.jQw)) {
            e.c(this.jQw).performClick();
            e.d(this.jQw);
        }
    }
}
