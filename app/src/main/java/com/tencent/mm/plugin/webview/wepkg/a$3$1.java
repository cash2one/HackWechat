package com.tencent.mm.plugin.webview.wepkg;

import com.tencent.mm.plugin.webview.wepkg.a.3;
import com.tencent.mm.plugin.webview.wepkg.model.g;
import com.tencent.mm.plugin.webview.wepkg.utils.a;
import com.tencent.mm.plugin.webview.wepkg.utils.b;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.x;

class a$3$1 implements Runnable {
    final /* synthetic */ 3 tLA;

    a$3$1(3 3) {
        this.tLA = 3;
    }

    public final void run() {
        try {
            x.i("MicroMsg.Wepkg.WePkgPlugin", "load url from net");
            a.d(this.tLA.tLy);
            a.e(this.tLA.tLy).loadUrl(a.b(this.tLA.tLy));
            int f = a.f(this.tLA.tLy);
            if (f > 1) {
                if (a.g(this.tLA.tLy) != null) {
                    a.b("whiteScreen", a.b(this.tLA.tLy), a.g(this.tLA.tLy).tNm, a.g(this.tLA.tLy).version, -1, 0, null);
                }
                String Qq = d.Qq(a.b(this.tLA.tLy));
                b.tNV.Qo(Qq);
                g.Qe(Qq);
                a.h(this.tLA.tLy);
                return;
            }
            a.a(this.tLA.tLy, f + 1);
        } catch (Exception e) {
        }
    }
}
