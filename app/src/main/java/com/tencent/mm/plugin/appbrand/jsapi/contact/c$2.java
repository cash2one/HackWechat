package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.protocal.c.agg;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ p jdJ;
    final /* synthetic */ c jiR;

    c$2(c cVar, p pVar, int i) {
        this.jiR = cVar;
        this.jdJ = pVar;
        this.gOK = i;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (i == 0 && i2 == 0 && bVar.hmh.hmo != null) {
            x.i("MicroMsg.JsApiEnterContact", "getsubbusinessinfo success, subBusinessUsername:%s", new Object[]{((agg) bVar.hmh.hmo).wnG});
            this.jdJ.getContentView().post(new 1(this, r0));
            return;
        }
        x.e("MicroMsg.JsApiEnterContact", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hmh.hmo});
        this.jdJ.E(this.gOK, this.jiR.e("fail:cgi fail", null));
    }
}
