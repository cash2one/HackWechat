package com.google.android.gms.analytics.internal;

import java.util.concurrent.Callable;

class y$1 implements Callable<String> {
    final /* synthetic */ y aHa;

    y$1(y yVar) {
        this.aHa = yVar;
    }

    public final /* synthetic */ Object call() {
        n nVar = this.aHa;
        String B = nVar.B(nVar.aFo.mT().mContext);
        return B == null ? nVar.ns() : B;
    }
}
