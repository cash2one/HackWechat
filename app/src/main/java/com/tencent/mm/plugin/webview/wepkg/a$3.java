package com.tencent.mm.plugin.webview.wepkg;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class a$3 implements a {
    final /* synthetic */ a tLy;

    a$3(a aVar) {
        this.tLy = aVar;
    }

    public final boolean uF() {
        if (a.c(this.tLy).aPx()) {
            a.a(this.tLy, 0);
        } else {
            x.i("MicroMsg.Wepkg.WePkgPlugin", "white screen");
            ag.y(new 1(this));
        }
        return false;
    }
}
