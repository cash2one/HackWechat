package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.protocal.c.qx;
import com.tencent.mm.protocal.c.qy;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 206;
    public static final String NAME = "deleteUserAutoFillData";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData data is invalid");
            pVar.E(i, e("fail:data is invalid", null));
            return;
        }
        Object optString = jSONObject.optString("groupKey");
        int optInt = jSONObject.optInt("groupId", 0);
        if (TextUtils.isEmpty(optString)) {
            x.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData groupKey is invalid");
            pVar.E(i, e("fail:groupKey is invalid", null));
            return;
        }
        x.i("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData appId:%s, groupId:%d, groupKey:%s", new Object[]{pVar.mAppId, Integer.valueOf(optInt), optString});
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new qx();
        aVar.hmk = new qy();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo";
        aVar.hmi = 1194;
        aVar.hml = 0;
        aVar.hmm = 0;
        com.tencent.mm.ae.b JZ = aVar.JZ();
        qx qxVar = (qx) JZ.hmg.hmo;
        qxVar.vYY = optString;
        qxVar.fFm = r3;
        qxVar.vYZ = optInt;
        qxVar.cOY = 1;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(JZ, new 1(this, pVar, i));
    }
}
