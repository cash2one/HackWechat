package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.sdk.platformtools.ak.a;

class c$5 implements a {
    final /* synthetic */ c mNG;

    c$5(c cVar) {
        this.mNG = cVar;
    }

    public final boolean uF() {
        if (!this.mNG.mNz) {
            this.mNG.mNz = true;
            this.mNG.gJk.a(131112, new c.a(this.mNG, (byte) 0));
        }
        com.tencent.mm.sdk.b.a.xef.c(this.mNG.mND);
        return false;
    }

    public final String toString() {
        return super.toString() + "|mBackgroundTimer";
    }
}
