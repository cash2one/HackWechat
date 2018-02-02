package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession.RefreshSessionTask;
import com.tencent.mm.protocal.c.amr;
import com.tencent.mm.sdk.platformtools.x;

class JsApiRefreshSession$RefreshSessionTask$1 implements a {
    final /* synthetic */ RefreshSessionTask jdV;

    JsApiRefreshSession$RefreshSessionTask$1(RefreshSessionTask refreshSessionTask) {
        this.jdV = refreshSessionTask;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        x.d("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            amr com_tencent_mm_protocal_c_amr = (amr) bVar.hmh.hmo;
            if (com_tencent_mm_protocal_c_amr == null) {
                RefreshSessionTask.b(this.jdV, 0);
                x.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest failed, response is null!");
                RefreshSessionTask.b(this.jdV);
            } else {
                RefreshSessionTask.c(this.jdV, com_tencent_mm_protocal_c_amr.wte.fts);
                String str2 = com_tencent_mm_protocal_c_amr.wte.ftt;
                if (RefreshSessionTask.c(this.jdV) == 0) {
                    RefreshSessionTask.d(this.jdV, com_tencent_mm_protocal_c_amr.wtm);
                    RefreshSessionTask.c(this.jdV, com_tencent_mm_protocal_c_amr.wte.fts);
                    RefreshSessionTask.b(this.jdV, 1);
                    RefreshSessionTask.d(this.jdV);
                } else {
                    RefreshSessionTask.c(this.jdV, com_tencent_mm_protocal_c_amr.wte.fts);
                    RefreshSessionTask.b(this.jdV, 2);
                    x.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest ERROR %s", new Object[]{str2});
                    RefreshSessionTask.e(this.jdV);
                }
            }
        } else {
            RefreshSessionTask.b(this.jdV, 0);
            RefreshSessionTask.a(this.jdV);
        }
        return 0;
    }
}
