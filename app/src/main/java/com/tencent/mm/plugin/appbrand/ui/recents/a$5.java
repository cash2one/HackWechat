package com.tencent.mm.plugin.appbrand.ui.recents;

class a$5 implements Runnable {
    final /* synthetic */ a jPj;

    a$5(a aVar) {
        this.jPj = aVar;
    }

    public final void run() {
        if (a.m(this.jPj).VU != null && a.m(this.jPj).VU.getHeight() > 0 && a.g(this.jPj) != null) {
            a.g(this.jPj).scrollBy(0, a.m(this.jPj).VU.getHeight());
        }
    }
}
