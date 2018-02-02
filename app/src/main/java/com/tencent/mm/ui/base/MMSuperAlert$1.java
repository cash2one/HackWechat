package com.tencent.mm.ui.base;

class MMSuperAlert$1 implements Runnable {
    final /* synthetic */ int ydv;
    final /* synthetic */ int ydw;
    final /* synthetic */ boolean ydx;
    final /* synthetic */ MMSuperAlert ydy;

    MMSuperAlert$1(MMSuperAlert mMSuperAlert, int i, int i2, boolean z) {
        this.ydy = mMSuperAlert;
        this.ydv = i;
        this.ydw = i2;
        this.ydx = z;
    }

    public final void run() {
        h.a(this.ydy, this.ydv == 0 ? "" : this.ydy.getString(this.ydv), this.ydw == 0 ? "" : this.ydy.getString(this.ydw), this.ydx, new 1(this), new 2(this));
    }
}
