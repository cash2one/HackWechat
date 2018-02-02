package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.sdk.platformtools.x;

class c$2 implements Runnable {
    final /* synthetic */ c mHI;

    c$2(c cVar) {
        this.mHI = cVar;
    }

    public final void run() {
        c.d(this.mHI);
        if (c.a(this.mHI) != null) {
            c.a(this.mHI).c(c.b(this.mHI));
        }
        if (c.b(this.mHI) == null) {
            x.w(c.aqF(), "already callback");
        } else {
            c.c(this.mHI);
        }
    }
}
