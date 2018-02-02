package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Message;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.sdk.platformtools.x;

class d$1 extends c {
    final /* synthetic */ d tMI;

    d$1(d dVar, Object obj) {
        this.tMI = dVar;
        super(obj);
    }

    public final void r(Message message) {
        x.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload complete. total time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - d.Tb())});
        if (this.tME != null) {
            Object obj = this.tME.get();
            if (obj instanceof kj) {
                kj kjVar = (kj) obj;
                if (kjVar != null) {
                    d.c(kjVar);
                }
            }
        }
    }
}
