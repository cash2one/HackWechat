package com.tencent.mm.ui;

import android.os.Looper;

class z$3 implements Runnable {
    final /* synthetic */ z xLL;

    z$3(z zVar) {
        this.xLL = zVar;
    }

    public final void run() {
        Looper.myQueue().addIdleHandler(this.xLL.xLE);
    }
}
