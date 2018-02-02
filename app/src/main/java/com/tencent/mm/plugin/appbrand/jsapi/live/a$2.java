package com.tencent.mm.plugin.appbrand.jsapi.live;

class a$2 implements Runnable {
    final /* synthetic */ String jkM;
    final /* synthetic */ String jkN;
    final /* synthetic */ String val$url;

    a$2(String str, String str2, String str3) {
        this.val$url = str;
        this.jkM = str2;
        this.jkN = str3;
    }

    public final void run() {
        a.y(this.val$url, this.jkM, this.jkN);
    }
}
