package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.internal.t.a;

class t$a$1 implements Runnable {
    final /* synthetic */ d aGx;
    final /* synthetic */ a aGy;

    t$a$1(a aVar, d dVar) {
        this.aGy = aVar;
        this.aGx = dVar;
    }

    public final void run() {
        if (!this.aGy.aGu.isConnected()) {
            this.aGy.aGu.av("Connected to service after a timeout");
            n nVar = this.aGy.aGu;
            d dVar = this.aGx;
            q.mY();
            nVar.aGr = dVar;
            nVar.mZ();
            nVar.aFo.mU().onServiceConnected();
        }
    }
}
