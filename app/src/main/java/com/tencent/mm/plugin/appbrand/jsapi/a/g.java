package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b$a;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.protocal.c.bdt;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = 205;
    public static final String NAME = "setUserAutoFillData";

    public final void a(final p pVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData data is invalid");
            pVar.E(i, e("fail:data is invalid", null));
            return;
        }
        String optString = jSONObject.optString("dataList");
        x.i("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData appId:%s, dataList:%s", new Object[]{pVar.mAppId, optString});
        b.a aVar = new b.a();
        aVar.hmj = new bdt();
        aVar.hmk = new bdu();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo";
        aVar.hmi = 1180;
        aVar.hml = 0;
        aVar.hmm = 0;
        b JZ = aVar.JZ();
        bdt com_tencent_mm_protocal_c_bdt = (bdt) JZ.hmg.hmo;
        com_tencent_mm_protocal_c_bdt.fFm = r2;
        com_tencent_mm_protocal_c_bdt.wow = optString;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(JZ, new b$a(this) {
            final /* synthetic */ g jhf;

            public final void a(int i, int i2, String str, b bVar) {
                if (i == 0 && i2 == 0 && bVar.hmh.hmo != null) {
                    x.i("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData success");
                    pVar.E(i, this.jhf.e("ok", null));
                    return;
                }
                x.e("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData SaveUserAutoFillInfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hmh.hmo});
                pVar.E(i, this.jhf.e("fail:cgi fail", null));
            }
        });
    }
}
