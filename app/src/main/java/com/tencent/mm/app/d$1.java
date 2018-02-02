package com.tencent.mm.app;

import android.content.ComponentName;
import android.os.IBinder;

class d$1 implements Runnable {
    final /* synthetic */ ComponentName feR;
    final /* synthetic */ IBinder feS;
    final /* synthetic */ d feT;

    d$1(d dVar, ComponentName componentName, IBinder iBinder) {
        this.feT = dVar;
        this.feR = componentName;
        this.feS = iBinder;
    }

    public final void run() {
        d.a(this.feT, this.feS);
    }
}
