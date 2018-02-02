package com.tencent.mm.plugin.appbrand.page;

class n$12 implements Runnable {
    final /* synthetic */ boolean jDB;
    final /* synthetic */ n jDp;
    final /* synthetic */ String val$url;

    n$12(n nVar, String str, boolean z) {
        this.jDp = nVar;
        this.val$url = str;
        this.jDB = z;
    }

    public final void run() {
        n.a(this.jDp, this.val$url, this.jDB ? aa.AUTO_RE_LAUNCH : aa.RE_LAUNCH);
    }
}
