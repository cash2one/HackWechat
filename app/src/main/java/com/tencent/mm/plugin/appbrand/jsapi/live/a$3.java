package com.tencent.mm.plugin.appbrand.jsapi.live;

class a$3 implements Runnable {
    final /* synthetic */ String jkN;
    final /* synthetic */ String val$url;

    a$3(String str, String str2) {
        this.val$url = str;
        this.jkN = str2;
    }

    public final void run() {
        a.bi(this.val$url, this.jkN);
    }
}
