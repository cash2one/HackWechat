package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.b;
import com.tencent.xweb.c;
import java.util.Map;
import org.json.JSONObject;

class d$15 implements Runnable {
    final /* synthetic */ d mZC;
    final /* synthetic */ Map mZD;
    final /* synthetic */ String mZE;

    d$15(d dVar, Map map, String str) {
        this.mZC = dVar;
        this.mZD = map;
        this.mZE = str;
    }

    public final void run() {
        int i;
        if (!(this.mZD == null || this.mZD.size() == 0)) {
            d.I(this.mZC);
            c.iO(d.t(this.mZC));
            b cIj = b.cIj();
            for (String str : this.mZD.keySet()) {
                cIj.setCookie(bh.VZ(this.mZE), str + "=" + ((String) this.mZD.get(str)));
            }
            cIj.setCookie(bh.VZ(d.J(this.mZC)), "httponly");
            c.cIl();
            c.sync();
            x.i("MicroMsg.GameWebPageView", "cookies:%s", cIj.getCookie(bh.VZ(this.mZE)));
        }
        d dVar = this.mZC;
        String str2 = this.mZE;
        if (this.mZD == null || this.mZD.size() == 0) {
            i = 0;
        } else {
            i = 1;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fullurl", str2);
            jSONObject.put("set_cookie", i);
            dVar.cH("onGetA8KeyUrl", jSONObject.toString());
        } catch (Exception e) {
            x.e("MicroMsg.GameWebviewJsLoader", "onGetA8Key, e:" + e.getMessage());
        }
    }
}
