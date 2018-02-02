package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class m$12 implements Runnable {
    final /* synthetic */ m qoh;

    m$12(m mVar) {
        this.qoh = mVar;
    }

    public final void run() {
        if (ar.Hj()) {
            ar.Hg();
            bh.g(c.Fr(), "Sk", 604800000);
        }
    }

    public final String toString() {
        return super.toString() + "|onAccountPostReset";
    }
}
