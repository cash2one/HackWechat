package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.plugin.webview.wepkg.utils.b;
import com.tencent.mm.sdk.platformtools.x;

class g$2 implements Runnable {
    g$2() {
    }

    public final void run() {
        g.Qg(b.OBJECT_ROOT_DIR_PATH);
        x.i("MicroMsg.Wepkg.WepkgManager", "clear all local wepkg");
    }
}
