package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Message;
import com.tencent.mm.plugin.webview.wepkg.a.b;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class b$2 extends c {
    final /* synthetic */ b tMA;
    final /* synthetic */ String tMB;

    b$2(b bVar, String str) {
        this.tMA = bVar;
        this.tMB = str;
    }

    public final void r(Message message) {
        final String string = message.getData().getString("used_wepkg_version");
        d.Dm().F(new Runnable(this) {
            final /* synthetic */ b$2 tMD;

            public final void run() {
                if (!bh.ov(string)) {
                    return;
                }
                if (g.Qg(d.Qp(this.tMD.tMB))) {
                    com.tencent.mm.plugin.webview.wepkg.a.d.bVa().PQ(this.tMD.tMB);
                    b.bUZ().PQ(this.tMD.tMB);
                    x.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg success. pkgid:%s", new Object[]{this.tMD.tMB});
                    return;
                }
                x.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg fail. pkgid:%s", new Object[]{this.tMD.tMB});
            }
        });
    }
}
