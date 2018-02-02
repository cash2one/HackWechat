package com.tencent.mm.plugin.music.model.g;

import com.tencent.mm.sdk.platformtools.x;

class b$4 implements Runnable {
    final /* synthetic */ b oMj;
    final /* synthetic */ boolean oMk;

    b$4(b bVar, boolean z) {
        this.oMj = bVar;
        this.oMk = z;
    }

    public final void run() {
        x.i("MicroMsg.Music.BasePlayer", "onStop, isComplete:%b", new Object[]{Boolean.valueOf(this.oMk)});
        this.oMj.oMg.e(this.oMj.fAA, this.oMk);
    }
}
