package com.tencent.mm.d;

import com.tencent.mm.d.e.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.t.c;

class e$a$1 implements Runnable {
    final /* synthetic */ a fjo;

    e$a$1(a aVar) {
        this.fjo = aVar;
    }

    public final void run() {
        x.d("MicroMsg.EmojiAndTextArtist", "cancel focus!");
        if (this.fjo.fjn.uI() != null) {
            c xz = ((com.tencent.mm.cache.c) this.fjo.fjn.uI()).xz();
            if (xz != null && xz.gNI) {
                xz.setSelected(false);
                a.a(this.fjo).aI(false);
                a.a(this.fjo).uS();
            }
        }
    }
}
