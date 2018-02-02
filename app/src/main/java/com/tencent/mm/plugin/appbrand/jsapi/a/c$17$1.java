package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.app.Activity;
import com.tencent.mm.plugin.af.a;
import com.tencent.mm.plugin.appbrand.jsapi.a.c.17;
import com.tencent.mm.plugin.appbrand.jsapi.a.c.9;
import com.tencent.mm.plugin.appbrand.q.b;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bgi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;

class c$17$1 implements Runnable {
    final /* synthetic */ bgi jgT;
    final /* synthetic */ 17 jgU;

    c$17$1(17 17, bgi com_tencent_mm_protocal_c_bgi) {
        this.jgU = 17;
        this.jgT = com_tencent_mm_protocal_c_bgi;
    }

    public final void run() {
        c cVar = this.jgU.jgI;
        int i = this.jgT.status;
        x.i("MicroMsg.JsApiGetPhoneNumber", "handleSendVerifyCodeStatus:%d", new Object[]{Integer.valueOf(i)});
        if (i == 0) {
            x.i("MicroMsg.JsApiGetPhoneNumber", "startSmsListener");
            if (cVar.jgB != null) {
                cVar.jgB.cancel();
            } else {
                cVar.jgB = new c$a(cVar);
            }
            cVar.jgB.start();
            if (cVar.jgC == null) {
                cVar.jgC = new a(cVar.jgr.mContext);
            }
            cVar.jgC.qyb = cVar.jgr.getContentView().getResources().getStringArray(b.isv);
            cVar.jgC.qxZ = cVar.jgH;
            com.tencent.mm.plugin.appbrand.a.a(cVar.jgr.mAppId, new 9(cVar));
            boolean a = com.tencent.mm.pluginsdk.g.a.a((Activity) cVar.jgr.mContext, "android.permission.READ_SMS", FileUtils.S_IWUSR, "", "");
            if (a) {
                com.tencent.mm.plugin.appbrand.a.oR(cVar.jgr.mAppId);
            }
            if (a) {
                x.i("MicroMsg.JsApiGetPhoneNumber", "request sms permission success");
            } else {
                x.e("MicroMsg.JsApiGetPhoneNumber", "request sms permission fail");
            }
            cVar.jgC.start();
        } else if (i == 1 || i != 2) {
            cVar.sh(cVar.jgr.getContentView().getResources().getString(j.izn));
            g.pQN.h(14249, new Object[]{cVar.jgr.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(cVar.jgF), Integer.valueOf(cVar.jgG), Integer.valueOf(cVar.jgE)});
        } else {
            cVar.sh(cVar.jgr.getContentView().getResources().getString(j.izo));
            g.pQN.h(14249, new Object[]{cVar.jgr.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(cVar.jgF), Integer.valueOf(cVar.jgG), Integer.valueOf(cVar.jgE)});
        }
    }
}
