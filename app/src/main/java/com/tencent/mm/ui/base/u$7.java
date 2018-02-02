package com.tencent.mm.ui.base;

import android.app.Activity;

class u$7 implements Runnable {
    final /* synthetic */ Activity icz;
    final /* synthetic */ q yek;
    final /* synthetic */ int yeo;

    u$7(q qVar, Activity activity, int i) {
        this.yek = qVar;
        this.icz = activity;
        this.yeo = i;
    }

    public final void run() {
        this.yek.showAtLocation(this.icz.getWindow().getDecorView(), 48, 0, this.yeo);
    }
}
