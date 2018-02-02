package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bgi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;

class c$17 implements a {
    final /* synthetic */ c jgI;
    final /* synthetic */ r jgK;

    c$17(c cVar, r rVar) {
        this.jgI = cVar;
        this.jgK = rVar;
    }

    public final void a(int i, int i2, String str, b bVar) {
        this.jgK.dismiss();
        if (i == 0 && i2 == 0 && bVar.hmh.hmo != null) {
            bgi com_tencent_mm_protocal_c_bgi = (bgi) bVar.hmh.hmo;
            x.i("MicroMsg.JsApiGetPhoneNumber", "SendVerifyCode cgi success");
            this.jgI.jgr.getContentView().post(new 1(this, com_tencent_mm_protocal_c_bgi));
            return;
        }
        x.e("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber SendVerifyCode cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hmh.hmo});
        this.jgI.jgr.E(this.jgI.jcN, this.jgI.e("fail:SendVerifyCode cgi fail", null));
        g.pQN.h(14249, new Object[]{this.jgI.jgr.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(this.jgI.jgF), Integer.valueOf(this.jgI.jgG), Integer.valueOf(this.jgI.jgE)});
    }
}
