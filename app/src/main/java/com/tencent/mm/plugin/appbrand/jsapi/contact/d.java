package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 152;
    public static final String NAME = "getContactMessageCount";

    public static class a extends f {
        private static final int CTRL_INDEX = 152;
        private static final String NAME = "onContactMessageCountChange";
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        String str = "";
        AppBrandSysConfig appBrandSysConfig = pVar.irP.iqx;
        if (appBrandSysConfig != null) {
            str = appBrandSysConfig.fnl;
        }
        if (bh.ov(str)) {
            x.e("MicroMsg.JsApiGetAppConfig", "getContactMessageCount username is empty!!!");
        }
        MainProcessTask jsApiGetContactMessageCountTask = new JsApiGetContactMessageCountTask();
        jsApiGetContactMessageCountTask.username = str;
        jsApiGetContactMessageCountTask.jcI = new 1(this, jsApiGetContactMessageCountTask, pVar, i);
        jsApiGetContactMessageCountTask.afi();
        AppBrandMainProcessService.a(jsApiGetContactMessageCountTask);
    }
}
