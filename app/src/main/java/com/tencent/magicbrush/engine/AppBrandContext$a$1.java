package com.tencent.magicbrush.engine;

import com.tencent.magicbrush.engine.AppBrandContext.a;

class AppBrandContext$a$1 implements Runnable {
    final /* synthetic */ a bny;

    AppBrandContext$a$1(a aVar) {
        this.bny = aVar;
    }

    public final void run() {
        AppBrandContext.notifyRunTimer(this.bny.bnx.bnB, AppBrandContext.a(this.bny.bnx), this.bny.bnv);
    }
}
