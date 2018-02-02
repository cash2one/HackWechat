package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.menu.l;
import com.tencent.mm.plugin.appbrand.menu.m;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.u.b;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 73;
    public static final String NAME = "shareAppMessage";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.i("MicroMsg.JsApiShareAppMessage", "data is null");
            jVar.E(i, e("fail:data is null", null));
            return;
        }
        p b = b(jVar);
        if (b == null) {
            x.i("MicroMsg.JsApiShareAppMessage", "share app message fail, pageView is null");
            jVar.E(i, e("fail:current page do not exist", null));
            return;
        }
        l le = b.le(m.jAH);
        if (le == null) {
            x.i("MicroMsg.JsApiShareAppMessage", "share app message fail, menuInfo is null.");
            jVar.E(i, e("fail:menu is null", null));
            return;
        }
        b bVar = le.iTl;
        if (bVar.hA("user_clicked_share_btn")) {
            x.i("MicroMsg.JsApiShareAppMessage", "invoke share app message");
            bVar.u("user_clicked_share_btn", false);
            MMActivity a = a(jVar);
            if (a == null) {
                x.i("MicroMsg.JsApiShareAppMessage", "share app message fail, context is null");
                jVar.E(i, e("fail: page context is null", null));
                return;
            }
            boolean optBoolean;
            AppBrandSysConfig appBrandSysConfig = jVar.irP.iqx;
            boolean z = bVar.getBoolean("enable_share_with_share_ticket", false);
            int i2 = z ? 3 : 2;
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("desc", "");
            String optString3 = jSONObject.optString("path");
            String optString4 = jSONObject.optString("imageUrl");
            String optString5 = jSONObject.optString("cacheKey");
            if (jVar.irP.Yz()) {
                optBoolean = jSONObject.optBoolean("useDefaultSnapshot", false);
            } else {
                optBoolean = jSONObject.optBoolean("useDefaultSnapshot", true);
            }
            boolean hA = bVar.hA("enable_share_dynamic");
            String str = jVar.mAppId;
            String str2 = appBrandSysConfig.fnl;
            int i3 = appBrandSysConfig.iOI.iGK;
            int i4 = appBrandSysConfig.iOI.iGL;
            int i5 = 0;
            if (!bh.ov(str)) {
                e oQ = com.tencent.mm.plugin.appbrand.a.oQ(str);
                AppBrandInitConfig appBrandInitConfig = oQ == null ? null : oQ.iqw;
                if (appBrandInitConfig != null) {
                    i5 = appBrandInitConfig.fnv;
                } else {
                    x.i("MicroMsg.JsApiShareAppMessage", "null = initConfig!");
                }
            }
            String pr = com.tencent.mm.plugin.appbrand.l.pr(jVar.mAppId);
            boolean sJ = j.sJ(optString4);
            String a2 = j.a(b, optString4, optBoolean);
            Serializable hashMap = new HashMap();
            hashMap.put("desc", optString2);
            hashMap.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(i2));
            hashMap.put("title", optString);
            hashMap.put("app_id", str);
            hashMap.put("pkg_type", Integer.valueOf(i3));
            hashMap.put("pkg_version", Integer.valueOf(i4));
            hashMap.put("img_url", optString4);
            hashMap.put("is_dynamic", Boolean.valueOf(hA));
            hashMap.put("cache_key", optString5);
            hashMap.put("path", optString3);
            if (!bh.ov(a2)) {
                hashMap.put("delay_load_img_path", a2);
            }
            x.i("MicroMsg.JsApiShareAppMessage", "msgParams:%s", new Object[]{hashMap});
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("mutil_select_is_ret", !z);
            intent.putExtra("select_is_ret", true);
            intent.putExtra("scene_from", 3);
            intent.putExtra("appbrand_params", hashMap);
            intent.putExtra("Retr_Msg_Type", 2);
            d.a(a, ".ui.transmit.SelectConversationUI", intent, 1, new 1(this, jVar, i, str, optString3, z, str2, optString, optString2, pr, i2, optString4, appBrandSysConfig, b, sJ, a2, hA, optString5, i5, a));
            return;
        }
        x.i("MicroMsg.JsApiShareAppMessage", "share app message fail, not allow to share");
        jVar.E(i, e("fail:not allow to share", null));
    }
}
