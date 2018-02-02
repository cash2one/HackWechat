package com.google.android.gms.analytics.internal;

class m$2 implements Runnable {
    final /* synthetic */ m aFM;
    final /* synthetic */ String aFN;
    final /* synthetic */ Runnable aFO;

    public m$2(m mVar, String str, Runnable runnable) {
        this.aFM = mVar;
        this.aFN = str;
        this.aFO = runnable;
    }

    public final void run() {
        this.aFM.aFK.aD(this.aFN);
        if (this.aFO != null) {
            this.aFO.run();
        }
    }
}
