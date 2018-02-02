package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.webview.wepkg.model.g;
import com.tencent.mm.plugin.webview.wepkg.model.g.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class g$25 implements Runnable {
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$25(g gVar, i iVar) {
        this.tIj = gVar;
        this.tIg = iVar;
    }

    public final void run() {
        g.a(new a(this) {
            final /* synthetic */ g$25 tID;

            {
                this.tID = r1;
            }

            public final void G(JSONObject jSONObject) {
                Map hashMap = new HashMap();
                hashMap.put("wepkg_info", jSONObject);
                g.a(this.tID.tIj, this.tID.tIg, "getLocalWePkgInfo:ok", hashMap);
            }
        });
    }
}
