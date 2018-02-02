package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class ap extends a {
    public static final int CTRL_INDEX = 403;
    public static final String NAME = "openOfflinePayView";
    private int jcs;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        Context a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiOpenOfflinePayView", "mmActivity is null, invoke fail!");
            return;
        }
        a.jwN = new 1(this, jVar, i);
        this.jcs = i;
        x.d("MicroMsg.JsApiOpenOfflinePayView", "json: %s", new Object[]{jSONObject.toString()});
        AppBrandSysConfig oS = a.oS(jVar.mAppId);
        if (oS == null) {
            jVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiOpenOfflinePayView", "sysConfig is null, invoke fail!");
            return;
        }
        e oQ = a.oQ(jVar.mAppId);
        if (oQ == null) {
            jVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiOpenOfflinePayView", "runtime is null, invoke fail!");
            return;
        }
        String aeq = oQ.iqC.aeq();
        Intent intent = new Intent();
        intent.putExtra("appId", jVar.mAppId);
        intent.putExtra("timeStamp", jSONObject.optString("timeStamp"));
        intent.putExtra("nonceStr", jSONObject.optString("nonceStr"));
        intent.putExtra("packageExt", jSONObject.optString("package"));
        intent.putExtra("signtype", jSONObject.optString("signType"));
        intent.putExtra("paySignature", jSONObject.optString("paySign"));
        intent.putExtra("wxapp_username", oS.frn);
        intent.putExtra("wxapp_path", aeq);
        int hashCode = hashCode() & 65535;
        intent.putExtra("key_from_scene", 7);
        d.b(a, "offline", ".ui.WalletOfflineEntranceUI", intent, hashCode);
    }
}
