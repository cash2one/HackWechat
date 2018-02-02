package com.tencent.mm.app;

import android.content.ComponentName;

class d$4 implements Runnable {
    final /* synthetic */ ComponentName feR;
    final /* synthetic */ d feT;

    d$4(d dVar, ComponentName componentName) {
        this.feT = dVar;
        this.feR = componentName;
    }

    public final void run() {
        d.a(this.feT);
    }
}
