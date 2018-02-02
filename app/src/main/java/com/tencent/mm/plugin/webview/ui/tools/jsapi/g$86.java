package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.s;
import com.tencent.mm.protocal.c.zq;
import java.util.HashMap;
import java.util.Map;

class g$86 implements e {
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$86(g gVar, i iVar) {
        this.tIj = gVar;
        this.tIg = iVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2;
        zq zqVar;
        int i3;
        s.a(this);
        String str3 = "getEnterpriseChat:fail";
        if (i == 0 && i2 == 0) {
            zq zqVar2;
            s sVar = (s) kVar;
            if (sVar.gJQ == null || sVar.gJQ.hmh.hmo == null) {
                zqVar2 = null;
            } else {
                zqVar2 = (zq) sVar.gJQ.hmh.hmo;
            }
            if (zqVar2 == null || zqVar2.vNw == null) {
                str2 = str3;
                zqVar = zqVar2;
                i3 = -1;
            } else {
                int i4 = zqVar2.vNw.ret;
                if (zqVar2.vNw.ftt == null || zqVar2.vNw.ftt.length() <= 0) {
                    str2 = str3;
                    zqVar = zqVar2;
                    i3 = i4;
                } else {
                    str2 = "getEnterpriseChat:fail_" + zqVar2.vNw.ftt;
                    zqVar = zqVar2;
                    i3 = i4;
                }
            }
        } else {
            str2 = str3;
            i3 = -1;
            zqVar = null;
        }
        if (i3 != 0) {
            g.a(this.tIj, this.tIg, str2, null);
            return;
        }
        Map hashMap = new HashMap();
        hashMap.put("result", zqVar.result);
        g.a(this.tIj, this.tIg, "getEnterpriseChat:ok", hashMap);
    }
}
