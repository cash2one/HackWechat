package com.tencent.mm.plugin.brandservice.ui.base;

class b$1 implements Runnable {
    final /* synthetic */ b kHf;

    b$1(b bVar) {
        this.kHf = bVar;
    }

    public final void run() {
        this.kHf.invalidateSelf();
    }
}
