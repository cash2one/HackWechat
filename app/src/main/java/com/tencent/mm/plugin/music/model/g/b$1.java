package com.tencent.mm.plugin.music.model.g;

import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    final /* synthetic */ boolean oMi;
    final /* synthetic */ b oMj;

    b$1(b bVar, boolean z) {
        this.oMj = bVar;
        this.oMi = z;
    }

    public final void run() {
        x.i("MicroMsg.Music.BasePlayer", "onError, needRetry:%b", new Object[]{Boolean.valueOf(this.oMi)});
        this.oMj.oMg.f(this.oMj.fAA, this.oMi);
    }
}
