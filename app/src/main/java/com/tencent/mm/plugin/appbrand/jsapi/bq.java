package com.tencent.mm.plugin.appbrand.jsapi;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ae.b;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.protocal.c.bsc;
import com.tencent.mm.protocal.c.bsd;
import org.json.JSONObject;

public final class bq extends a {
    public static final int CTRL_INDEX = 313;
    public static final String NAME = "verifyPlugin";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jSONObject == null || jSONObject.opt(SlookAirButtonFrequentContactAdapter.DATA) == null) {
            jVar.E(i, e("fail:data is null or nil", null));
            return;
        }
        String str = jVar.mAppId;
        a com_tencent_mm_protocal_c_bsc = new bsc();
        b.a aVar = new b.a();
        aVar.hmj = com_tencent_mm_protocal_c_bsc;
        aVar.hmk = new bsd();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/verifyplugin";
        aVar.hmi = 1714;
        aVar.hml = 0;
        aVar.hmm = 0;
        com_tencent_mm_protocal_c_bsc.fFm = str;
        com_tencent_mm_protocal_c_bsc.wTw = jSONObject.opt(SlookAirButtonFrequentContactAdapter.DATA).toString();
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.JZ(), new 1(this, jVar, i));
    }
}
