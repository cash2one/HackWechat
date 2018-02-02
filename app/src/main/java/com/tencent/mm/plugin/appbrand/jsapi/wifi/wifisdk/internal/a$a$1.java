package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a.a;

class a$a$1 implements Runnable {
    final /* synthetic */ int iIS;
    final /* synthetic */ a jvQ;

    a$a$1(a aVar, int i) {
        this.jvQ = aVar;
        this.iIS = i;
    }

    public final void run() {
        this.jvQ.jvP.e(false, "fail to connect wifi:actionListener" + this.iIS);
    }
}
