package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.webview.model.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.Map;

class g$12 implements e {
    final /* synthetic */ String fgO;
    final /* synthetic */ Intent kvq;
    final /* synthetic */ g tIj;

    g$12(g gVar, Intent intent, String str) {
        this.tIj = gVar;
        this.kvq = intent;
        this.fgO = str;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (g.k(this.tIj) != null && g.k(this.tIj).isShowing()) {
            g.k(this.tIj).dismiss();
            g.a(this.tIj, null);
        }
        ar.CG().b(1177, (e) this);
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Biz_Jsapi_Getuseropendid success");
            q qVar = (q) kVar;
            Map hashMap = new HashMap();
            hashMap.put("openid", qVar.tse);
            hashMap.put("headImgUrl", qVar.tsf);
            hashMap.put("nickName", qVar.tsg);
            x.d("MicroMsg.MsgHandler", "opnid:%s, nick_name:%s", qVar.tse, qVar.tsg);
            g.a(this.tIj, null, "", this.fgO, (String) g.j(this.tIj).pox.get("img_url"), (String) g.j(this.tIj).pox.get("src_username"), (String) g.j(this.tIj).pox.get("src_displayname"), this.kvq == null ? null : this.kvq.getStringExtra("custom_send_text"), null);
            if (g.i(this.tIj) != null) {
                h.bu(g.i(this.tIj), g.i(this.tIj).getResources().getString(R.l.dGG));
            }
            g.a(this.tIj, g.j(this.tIj), "sendSingleAppMessage:ok", hashMap);
            return;
        }
        x.e("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Biz_Jsapi_Getuseropendid fail");
        g.a(this.tIj, g.j(this.tIj), "sendSingleAppMessage:fail", null);
    }
}
