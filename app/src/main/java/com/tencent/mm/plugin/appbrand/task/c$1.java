package com.tencent.mm.plugin.appbrand.task;

import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.j.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

class c$1 implements Runnable {
    c$1() {
    }

    public final void run() {
        x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preInit start");
        new l().init();
        v.ks();
        c.ub();
        if (WebView.hasInited()) {
            c.akm();
            x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "webview already init done");
            return;
        }
        WebView.initWebviewCore(ac.getContext(), MMWebView.zvD, "appbrand", new 1(this));
        x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "misc preload done");
    }
}
