package com.tencent.mm.plugin.appbrand.jsapi;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class w extends a {
    public static final int CTRL_INDEX = 101;
    public static final String NAME = "getAppConfig";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            jVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiGetAppConfig", "data is null");
            return;
        }
        String str = jVar.mAppId;
        final int optInt = jSONObject.optInt(DownloadSettingTable$Columns.TYPE, 0);
        x.i("MicroMsg.JsApiGetAppConfig", "getAppConfig app_id:%s,type:%d", new Object[]{str, Integer.valueOf(optInt)});
        if (optInt <= 0) {
            jVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiGetAppConfig", "type %d is invalid", new Object[]{Integer.valueOf(optInt)});
            return;
        }
        final MainProcessTask jsApiGetAppConfigTask = new JsApiGetAppConfigTask();
        jsApiGetAppConfigTask.appId = str;
        jsApiGetAppConfigTask.type = optInt;
        final j jVar2 = jVar;
        final int i2 = i;
        jsApiGetAppConfigTask.jcI = new Runnable(this) {
            final /* synthetic */ w jcW;

            public final void run() {
                Map hashMap = new HashMap();
                hashMap.put(DownloadSettingTable$Columns.TYPE, optInt);
                hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, jsApiGetAppConfigTask.value);
                x.i("MicroMsg.JsApiGetAppConfig", "getAppConfig type:%d,data:\n%s", new Object[]{Integer.valueOf(optInt), jsApiGetAppConfigTask.value});
                if (bh.ov(jsApiGetAppConfigTask.value)) {
                    jVar2.E(i2, this.jcW.e("fail", null));
                } else {
                    jVar2.E(i2, this.jcW.e("ok", hashMap));
                }
                jsApiGetAppConfigTask.afj();
            }
        };
        jsApiGetAppConfigTask.afi();
        AppBrandMainProcessService.a(jsApiGetAppConfigTask);
    }
}
