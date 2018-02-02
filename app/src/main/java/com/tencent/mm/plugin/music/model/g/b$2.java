package com.tencent.mm.plugin.music.model.g;

import com.tencent.mm.sdk.platformtools.x;

class b$2 implements Runnable {
    final /* synthetic */ b oMj;

    b$2(b bVar) {
        this.oMj = bVar;
    }

    public final void run() {
        x.i("MicroMsg.Music.BasePlayer", "onStart %b", new Object[]{Boolean.valueOf(this.oMj.isPlaying())});
        this.oMj.oMg.n(this.oMj.fAA);
    }
}
