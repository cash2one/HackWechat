package com.tencent.mm.plugin.webview.b;

class e$1 implements Runnable {
    final /* synthetic */ e tle;

    public e$1(e eVar) {
        this.tle = eVar;
    }

    public final void run() {
        String str = "WebViewHistory";
        this.tle.fx(str, "delete from WebViewHistory where  timeStamp < " + ((System.currentTimeMillis() / 1000) - 604800));
        e.a(this.tle);
    }
}
