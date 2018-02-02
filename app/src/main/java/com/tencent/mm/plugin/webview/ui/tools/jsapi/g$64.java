package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.webview.model.c.b;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class g$64 implements b {
    final /* synthetic */ String jBv;
    final /* synthetic */ String mXv;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$64(g gVar, String str, String str2, i iVar) {
        this.tIj = gVar;
        this.jBv = str;
        this.mXv = str2;
        this.tIg = iVar;
    }

    public final void a(boolean z, String str, String str2, String str3) {
        x.i("MicroMsg.MsgHandler", this.jBv + ", on cdn finish,  is success : %s, mediaId : %s, local id is : %s, mediaUrl : %s", new Object[]{Boolean.valueOf(z), str2, str, str3});
        if (!bh.ov(str) && str.equals(this.mXv)) {
            g.A(this.tIj).remove(this.mXv);
            f.bRA().a((b) this);
            if (g.k(this.tIj) != null) {
                g.k(this.tIj).dismiss();
                g.a(this.tIj, null);
            }
            g.B(this.tIj);
            if (z) {
                Map hashMap = new HashMap();
                hashMap.put("serverId", str2);
                hashMap.put("mediaUrl", str3);
                g.a(this.tIj, this.tIg, this.jBv + ":ok", hashMap);
                return;
            }
            g.a(this.tIj, this.tIg, this.jBv + ":fail", null);
        }
    }
}
