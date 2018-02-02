package com.tencent.mm.sdk.c;

import com.tencent.mm.sdk.c.b.b;
import com.tencent.mm.sdk.c.b.c;
import com.tencent.mm.sdk.platformtools.af;

class b$1 implements Runnable {
    final /* synthetic */ af kCy;
    final /* synthetic */ b xep;
    final /* synthetic */ c xeq;
    final /* synthetic */ b xer;

    b$1(b bVar, b bVar2, c cVar, af afVar) {
        this.xer = bVar;
        this.xep = bVar2;
        this.xeq = cVar;
        this.kCy = afVar;
    }

    public final void run() {
        this.xer.a(this.xep, this.xeq);
        if (this.kCy != null) {
            this.kCy.post(new 1(this));
        } else {
            this.xeq.onComplete();
        }
    }
}
