package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 277;
    public static final String NAME = "startSoterAuthentication";

    static /* synthetic */ void a(b bVar, j jVar, int i, Bundle bundle, String str) {
        int i2;
        String string;
        Object string2;
        Object string3;
        int i3;
        String str2 = "not returned";
        String str3 = "";
        String str4 = "";
        if (bundle != null) {
            i2 = bundle.getInt("err_code");
            string = bundle.getString("err_msg");
            string2 = bundle.getString("result_json");
            string3 = bundle.getString("result_json_signature");
            i3 = bundle.getByte("use_mode");
        } else {
            i2 = -1;
            string = str2;
            str2 = str3;
            str3 = str4;
            i3 = 0;
        }
        JSONArray kr = a.kr(i3);
        Object obj = "";
        if (kr.length() > 0) {
            try {
                obj = kr.getString(0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiStartSoterAuthentication", e, "hy: json error in callback", new Object[0]);
            }
        }
        Map hashMap = new HashMap(5);
        hashMap.put("authMode", obj);
        hashMap.put("errCode", Integer.valueOf(i2));
        hashMap.put("resultJSON", string2);
        hashMap.put("resultJSONSignature", string3);
        if ("fail".equals(str)) {
            str = str + " " + string;
        }
        jVar.E(i, bVar.e(str, hashMap));
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.JsApiStartSoterAuthentication", "hy: JsApiStartSoterAuthentication");
        super.a(jVar, jSONObject, i);
        Context a = a(jVar);
        if (a == null) {
            x.e("MicroMsg.JsApiStartSoterAuthentication", "JsApiStartSoterAuthentication context is null, appId is %s", jVar.mAppId);
            jVar.E(i, e("fail", null));
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("requestAuthModes");
        String optString = jSONObject.optString("challenge");
        String optString2 = jSONObject.optString("authContent");
        Intent intent = new Intent();
        intent.putExtra("auth_mode", a.g(optJSONArray));
        intent.putExtra("challenge", optString);
        intent.putExtra("auth_content", optString2);
        intent.putExtra("key_soter_fp_mp_scene", 0);
        a.jwN = new 1(this, jVar, i);
        d.b(a, "soter_mp", ".ui.SoterAuthenticationUI", intent, 1000);
    }
}
