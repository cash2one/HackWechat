package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import com.google.android.gms.analytics.internal.t.a;

class t$a$2 implements Runnable {
    final /* synthetic */ a aGy;
    final /* synthetic */ ComponentName aGz;

    t$a$2(a aVar, ComponentName componentName) {
        this.aGy = aVar;
        this.aGz = componentName;
    }

    public final void run() {
        n nVar = this.aGy.aGu;
        ComponentName componentName = this.aGz;
        q.mY();
        if (nVar.aGr != null) {
            nVar.aGr = null;
            nVar.c("Disconnected from device AnalyticsService", componentName);
            nVar.aFo.mU().mK();
        }
    }
}
