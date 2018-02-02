package com.tencent.smtt.sdk;

import com.tencent.smtt.sdk.QbSdk.1;

class QbSdk$1$1 implements Runnable {
    final /* synthetic */ boolean vrb;
    final /* synthetic */ 1 zWi;

    QbSdk$1$1(1 1, boolean z) {
        this.zWi = 1;
        this.vrb = z;
    }

    public final void run() {
        this.zWi.zWh.onReceiveValue(Boolean.valueOf(this.vrb));
    }
}
