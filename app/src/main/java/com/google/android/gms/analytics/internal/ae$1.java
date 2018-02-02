package com.google.android.gms.analytics.internal;

import android.os.Looper;

class ae$1 implements Runnable {
    final /* synthetic */ ae aHo;

    ae$1(ae aeVar) {
        this.aHo = aeVar;
    }

    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ae.a(this.aHo).mT().d((Runnable) this);
            return;
        }
        boolean nG = this.aHo.nG();
        ae.b(this.aHo);
        if (nG && !ae.c(this.aHo)) {
            this.aHo.run();
        }
    }
}
