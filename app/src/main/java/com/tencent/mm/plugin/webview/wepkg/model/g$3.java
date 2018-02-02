package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.plugin.webview.wepkg.utils.d;
import java.io.File;

class g$3 implements Runnable {
    final /* synthetic */ WepkgCrossProcessTask tNf;
    final /* synthetic */ String tNg;
    final /* synthetic */ File tNh;
    final /* synthetic */ g$a tNi;

    g$3(WepkgCrossProcessTask wepkgCrossProcessTask, String str, File file, g$a com_tencent_mm_plugin_webview_wepkg_model_g_a) {
        this.tNf = wepkgCrossProcessTask;
        this.tNg = str;
        this.tNh = file;
        this.tNi = com_tencent_mm_plugin_webview_wepkg_model_g_a;
    }

    public final void run() {
        if (this.tNf.fnI) {
            d.Dm().F(new 1(this));
        }
        this.tNf.afj();
    }
}
