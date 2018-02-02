package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u;
import com.tencent.mm.z.u.b;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiStartPlayVoice extends a {
    public static final int CTRL_INDEX = 33;
    public static final String NAME = "playVoice";
    public static String jfz = null;
    private StartPlayVoice jfA;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String az = bh.az(jSONObject.optString(DownloadInfoColumns.FILEPATH, null), jSONObject.optString("localId"));
        x.i("MicroMsg.JsApiStartPlayVoice", "doPlayVoice, appId : %s, localId : %s", new Object[]{jVar.mAppId, az});
        if (bh.ov(az)) {
            jVar.E(i, e("fail_missing arguments", null));
            return;
        }
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(jVar.mAppId, az);
        final p b = b(jVar);
        if (itemByLocalId == null || bh.ov(itemByLocalId.hhZ) || b == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        b t = u.GK().t("JsApi@" + b.hashCode(), true);
        d dVar = (d) t.get("onBackgroundListener", null);
        if (dVar == null) {
            dVar = new d(this) {
                final /* synthetic */ JsApiStartPlayVoice jfC;

                public final void afA() {
                    JsApiStopPlayVoice.afB();
                    b.b(this);
                }
            };
            t.o("onBackgroundListener", dVar);
        }
        b.a(dVar);
        if (((e) t.get("onDestroyListener", null)) == null) {
            e anonymousClass2 = new e(this) {
                final /* synthetic */ JsApiStartPlayVoice jfC;

                public final void onDestroy() {
                    JsApiStopPlayVoice.afB();
                    b.b(this);
                    b hy = u.GK().hy("JsApi@" + b.hashCode());
                    if (hy != null) {
                        hy.recycle();
                    }
                }
            };
            t.o("onDestroyListener", anonymousClass2);
            b.a(anonymousClass2);
        }
        if (this.jfA == null) {
            this.jfA = new StartPlayVoice(this, jVar, i);
        }
        if (jfz != null) {
            Map hashMap = new HashMap();
            hashMap.put("localId", this.jfA.fus);
            jVar.E(StartPlayVoice.a(this.jfA), e("fail", hashMap));
            return;
        }
        StartPlayVoice.a(this.jfA, this);
        StartPlayVoice.a(this.jfA, jVar);
        StartPlayVoice.a(this.jfA, i);
        this.jfA.fus = az;
        this.jfA.filePath = itemByLocalId.hhZ;
        AppBrandMainProcessService.a(this.jfA);
        jfz = az;
    }
}
