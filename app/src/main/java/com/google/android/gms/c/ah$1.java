package com.google.android.gms.c;

import java.util.Iterator;

class ah$1 implements Runnable {
    final /* synthetic */ ae aYr;
    final /* synthetic */ ah aYs;

    public ah$1(ah ahVar, ae aeVar) {
        this.aYs = ahVar;
        this.aYr = aeVar;
    }

    public final void run() {
        this.aYr.aXZ.a(this.aYr);
        Iterator it = ah.a(this.aYs).iterator();
        while (it.hasNext()) {
            it.next();
        }
        ah.d(this.aYr);
    }
}
