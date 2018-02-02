package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.webview.model.c$b;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class g$73 implements c$b {
    final /* synthetic */ String mXv;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$73(g gVar, String str, i iVar) {
        this.tIj = gVar;
        this.mXv = str;
        this.tIg = iVar;
    }

    public final void a(boolean z, String str, String str2, String str3) {
        x.i("MicroMsg.MsgHandler", "doUploadVoice, on cdn finish,  is success : %s, mediaid : %s, local id is : %s", new Object[]{Boolean.valueOf(z), str2, str});
        if (!bh.ov(str) && str.equals(this.mXv)) {
            f.bRA().a(this);
            if (g.k(this.tIj) != null) {
                g.k(this.tIj).dismiss();
                g.a(this.tIj, null);
            }
            if (z) {
                Map hashMap = new HashMap();
                hashMap.put("serverId", str2);
                g.a(this.tIj, this.tIg, "uploadVoice:ok", hashMap);
                return;
            }
            g.a(this.tIj, this.tIg, "uploadVoice:fail", null);
        }
    }
}
