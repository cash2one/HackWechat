package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.webview.model.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.Map;

class g$9 implements e {
    final /* synthetic */ g tIj;

    g$9(g gVar) {
        this.tIj = gVar;
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
            hashMap.put("package", qVar.tse);
            hashMap.put("sign", qVar.sign);
            hashMap.put("headImgUrl", qVar.tsf);
            hashMap.put("nickName", qVar.tsg);
            hashMap.put("friendRelation", Integer.valueOf(qVar.tsh));
            x.d("MicroMsg.MsgHandler", "select single contact : opnid:%s, sign:%s, nick_name:%s, friend_relation:%d", qVar.tse, qVar.sign, qVar.tsg, Integer.valueOf(qVar.tsh));
            g.a(this.tIj, g.j(this.tIj), "selectSingleContact:ok", hashMap);
            return;
        }
        x.e("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Biz_Jsapi_Getuseropendid fail");
        g.a(this.tIj, g.j(this.tIj), "selectSingleContact:fail", null);
    }
}
