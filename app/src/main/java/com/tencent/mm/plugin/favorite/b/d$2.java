package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.plugin.favorite.b.d.a;

class d$2 implements Runnable {
    final /* synthetic */ d mrm;
    final /* synthetic */ a mrn;

    d$2(d dVar, a aVar) {
        this.mrm = dVar;
        this.mrn = aVar;
    }

    public final void run() {
        d.a(this.mrn, false);
    }

    public final String toString() {
        return super.toString() + "|retryJob";
    }
}
