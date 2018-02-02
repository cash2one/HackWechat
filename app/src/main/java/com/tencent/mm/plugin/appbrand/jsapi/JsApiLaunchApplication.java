package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.protocal.c.alv;
import com.tencent.mm.protocal.c.alw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class JsApiLaunchApplication extends a {
    private static final int CTRL_INDEX = 427;
    private static final String NAME = "launchApplication";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiLaunchApplication", "data is null");
            jVar.E(i, e("fail:data is null", null));
            return;
        }
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("schemeUrl");
        String optString3 = jSONObject.optString("parameter");
        int i2 = bh.getInt(jSONObject.optString("alertType"), 0);
        x.i("MicroMsg.JsApiLaunchApplication", "appid : %s, scheme : %s, extinfo:[%s], parameter : %s", new Object[]{optString, optString2, jSONObject.optString("extInfo"), optString3});
        if (bh.ov(optString) && bh.ov(optString2)) {
            x.e("MicroMsg.JsApiLaunchApplication", "appid and scheme is null or nil");
            jVar.E(i, e("fail:appid and scheme is null or nil", null));
            return;
        }
        String url;
        String str = jVar.mAppId;
        p b = b(jVar);
        if (b != null) {
            url = b.getURL();
        } else {
            x.e("MicroMsg.JsApiLaunchApplication", "getCurrentPageView is null");
            url = null;
        }
        Bundle bundle = new Bundle();
        if (!bh.ov(url)) {
            try {
                bundle.putString("current_page_url", URLEncoder.encode(url, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
            }
        }
        bundle.putString("current_page_appid", str);
        a aVar = new a();
        aVar.hmj = new alv();
        aVar.hmk = new alw();
        aVar.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        aVar.hmi = 1125;
        alv com_tencent_mm_protocal_c_alv = (alv) aVar.JZ().hmg.hmo;
        com_tencent_mm_protocal_c_alv.fFm = str;
        com_tencent_mm_protocal_c_alv.wsO = optString;
        com_tencent_mm_protocal_c_alv.scene = jVar.irP.iqH.scene;
        com_tencent_mm_protocal_c_alv.url = url;
        com_tencent_mm_protocal_c_alv.wsP = optString2;
        com_tencent_mm_protocal_c_alv.liK = i2;
        com_tencent_mm_protocal_c_alv.wsQ = 1;
        x.i("MicroMsg.JsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", new Object[]{str, optString, Integer.valueOf(com_tencent_mm_protocal_c_alv.scene), com_tencent_mm_protocal_c_alv.url, com_tencent_mm_protocal_c_alv.wsP, Integer.valueOf(com_tencent_mm_protocal_c_alv.liK)});
        b.a(aVar.JZ(), new 1(this, jVar, i, optString2, bundle, optString, optString3, r8));
    }
}
