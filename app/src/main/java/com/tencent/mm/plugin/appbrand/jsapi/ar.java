package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class ar extends a {
    public static final int CTRL_INDEX = 192;
    public static final String NAME = "openSetting";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiOpenSetting", "jumpToSettingView!");
        AppBrandSysConfig appBrandSysConfig = jVar.irP.iqx;
        if (appBrandSysConfig == null) {
            x.e("MicroMsg.JsApiOpenSetting", "config is null!");
            jVar.E(i, e("fail", null));
            return;
        }
        Context a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiOpenSetting", "mmActivity is null, invoke fail!");
            return;
        }
        a.jwN = new 1(this, jVar, i);
        Intent putExtra = new Intent(jVar.getContext(), AppBrandAuthorizeUI.class).putExtra("key_username", appBrandSysConfig.fnl);
        putExtra.putExtra("key_app_authorize_jsapi", true);
        d.b(a, "appbrand", ".ui.AppBrandAuthorizeUI", putExtra, 1);
    }
}
