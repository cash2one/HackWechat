package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.aly;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.Map;

class g$7 implements e {
    final /* synthetic */ g tIj;

    g$7(g gVar) {
        this.tIj = gVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (g.k(this.tIj) != null && g.k(this.tIj).isShowing()) {
            g.k(this.tIj).dismiss();
            g.a(this.tIj, null);
        }
        ar.CG().b(1566, this);
        if (i == 0 && i2 == 0) {
            int i3;
            x.i("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Cgi_PayIBGGetUserOpenId success");
            com.tencent.mm.plugin.webview.model.k kVar2 = (com.tencent.mm.plugin.webview.model.k) kVar;
            aly com_tencent_mm_protocal_c_aly = kVar2.gJQ == null ? null : (aly) kVar2.gJQ.hmh.hmo;
            Object obj = g.j(this.tIj).pox.get("result_sign_type");
            if (obj != null) {
                i3 = bh.getInt((String) obj, 0);
            } else {
                i3 = 0;
            }
            Map hashMap = new HashMap();
            hashMap.put("package", com_tencent_mm_protocal_c_aly.vWh);
            hashMap.put("sign", com_tencent_mm_protocal_c_aly.vWi);
            if (i3 == 1) {
                hashMap.put("signType", com_tencent_mm_protocal_c_aly.vWj);
            }
            hashMap.put("timestamp", com_tencent_mm_protocal_c_aly.vLX);
            hashMap.put("noncestr", com_tencent_mm_protocal_c_aly.vWg);
            x.d("MicroMsg.MsgHandler", "select single contact : package:%s, sign:%s", new Object[]{com_tencent_mm_protocal_c_aly.vWh, com_tencent_mm_protocal_c_aly.vWi});
            g.a(this.tIj, g.j(this.tIj), "selectSingleContact:ok", hashMap);
            return;
        }
        x.e("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Cgi_PayIBGGetUserOpenId fail");
        g.a(this.tIj, g.j(this.tIj), "selectSingleContact:fail", null);
    }
}
