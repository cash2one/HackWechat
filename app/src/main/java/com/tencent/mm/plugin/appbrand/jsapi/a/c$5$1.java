package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.a.c.5;
import com.tencent.mm.plugin.appbrand.jsapi.a.c.6;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.nu;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class c$5$1 implements Runnable {
    final /* synthetic */ nu jgL;
    final /* synthetic */ 5 jgM;

    c$5$1(5 5, nu nuVar) {
        this.jgM = 5;
        this.jgL = nuVar;
    }

    public final void run() {
        if (this.jgL.status == 0) {
            x.d("MicroMsg.JsApiGetPhoneNumber", "encryptedData:%s, iv:%s", this.jgL.jgv, this.jgL.atl);
            if (!TextUtils.isEmpty(this.jgL.jgv)) {
                this.jgM.jgI.jgv = this.jgL.jgv;
            }
            if (!TextUtils.isEmpty(this.jgL.atl)) {
                this.jgM.jgI.atl = this.jgL.atl;
            }
        }
        c cVar = this.jgM.jgI;
        int i = this.jgL.status;
        x.i("MicroMsg.JsApiGetPhoneNumber", "handleCheckVerifyCodeStatus:%d", Integer.valueOf(i));
        if (i == 0) {
            g.pQN.h(14249, cVar.jgr.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(cVar.jgF), Integer.valueOf(cVar.jgG), Integer.valueOf(cVar.jgE));
            cVar.afI();
        } else if (i == 1) {
            cVar.sh(cVar.jgr.getContentView().getResources().getString(j.izo));
            g.pQN.h(14249, cVar.jgr.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(cVar.jgF), Integer.valueOf(cVar.jgG), Integer.valueOf(cVar.jgE));
        } else if (i == 3 || i == 4) {
            h.a(cVar.jgr.mContext, cVar.jgr.getContentView().getResources().getString(j.izq), "", false, new 6(cVar));
        } else {
            cVar.sh(cVar.jgr.getContentView().getResources().getString(j.izt));
            g.pQN.h(14249, cVar.jgr.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(cVar.jgF), Integer.valueOf(cVar.jgG), Integer.valueOf(cVar.jgE));
        }
    }
}
