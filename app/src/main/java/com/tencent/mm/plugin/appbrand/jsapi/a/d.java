package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.protocal.c.ahb;
import com.tencent.mm.protocal.c.ahc;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 204;
    public static final String NAME = "getUserAutoFillData";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData data is invalid");
            pVar.E(i, e("fail:data is invalid", null));
            return;
        }
        LinkedList linkedList = new LinkedList();
        JSONArray optJSONArray = jSONObject.optJSONArray("fields");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                linkedList.add(optJSONArray.optString(i2));
            }
        }
        if (linkedList.size() == 0) {
            x.e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData fields is empty");
            pVar.E(i, e("fail:fields is empty", null));
            return;
        }
        x.i("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData appId:%s, data:%s", new Object[]{pVar.mAppId, jSONObject.toString()});
        b.a aVar = new b.a();
        aVar.hmj = new ahb();
        aVar.hmk = new ahc();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
        aVar.hmi = 1191;
        aVar.hml = 0;
        aVar.hmm = 0;
        b JZ = aVar.JZ();
        ahb com_tencent_mm_protocal_c_ahb = (ahb) JZ.hmg.hmo;
        com_tencent_mm_protocal_c_ahb.wov = linkedList;
        com_tencent_mm_protocal_c_ahb.fFm = r3;
        com_tencent_mm_protocal_c_ahb.wou = false;
        com_tencent_mm_protocal_c_ahb.cOY = 1;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(JZ, new 1(this, pVar, i));
    }
}
