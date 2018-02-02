package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.g.a.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class g$42 extends c<i> {
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$42(g gVar, i iVar) {
        this.tIj = gVar;
        this.tIg = iVar;
        this.xen = i.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        i iVar = (i) bVar;
        if (!(iVar instanceof i)) {
            x.w("MicroMsg.MsgHandler", "mismatched event");
        } else if (iVar.fmX.scene != 0) {
            x.i("MicroMsg.MsgHandler", "not jsapi api callback");
        } else if (iVar.fmX.fmY) {
            x.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, cancel");
            g.a(this.tIj, this.tIg, "add_download_task:cancel", null);
        } else {
            if (iVar.fmX.fmZ > 0) {
                Map hashMap = new HashMap();
                hashMap.put("download_id", Long.valueOf(iVar.fmX.fmZ));
                x.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, ok");
                g.a(this.tIj, this.tIg, "add_download_task:ok", hashMap);
            } else {
                x.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, failed");
                g.a(this.tIj, this.tIg, "add_download_task:fail", null);
            }
            a.xef.c(g.v(this.tIj));
        }
        return false;
    }
}
