package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.webview.model.g;
import com.tencent.mm.protocal.c.ye;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.Map;

class g$80 implements e {
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$80(g gVar, i iVar) {
        this.tIj = gVar;
        this.tIg = iVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            g gVar = (g) kVar;
            Map hashMap = new HashMap();
            hashMap.put("ticket", ((ye) gVar.lMW.hmh.hmo).frP);
            g.a(this.tIj, this.tIg, "get_wechat_verify_ticket:ok ticket", hashMap);
        } else {
            x.e("MicroMsg.MsgHandler", "doGetWechatVerifyTicket, errType = " + i + ", errCode = " + i2);
            g.a(this.tIj, this.tIg, "get_wechat_verify_ticket:fail ticket", null);
        }
        ar.CG().b(1097, this);
    }
}
