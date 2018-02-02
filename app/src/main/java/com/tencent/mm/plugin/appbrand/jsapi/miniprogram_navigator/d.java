package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e.b;
import com.tencent.mm.sdk.platformtools.bh;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 251;
    public static final String NAME = "navigateToMiniProgram";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        String optString = jSONObject.optString("appId", null);
        if (bh.ov(optString)) {
            jVar.E(i, e("fail:invalid data", null));
        } else if (optString.equals(jVar.mAppId)) {
            jVar.E(i, e("fail:target appId is the same as the caller appId", null));
        } else {
            int i2;
            int i3;
            String optString2 = jSONObject.optString("path", null);
            JSONObject optJSONObject = jSONObject.optJSONObject("extraData");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            String optString3 = jSONObject.optString("envVersion");
            int i4 = jVar.irP.iqx.iOI.iGK;
            if (optString3 == null) {
                optString3 = "";
            }
            switch (optString3.hashCode()) {
                case 110628630:
                    if (optString3.equals("trial")) {
                        i2 = 1;
                        break;
                    }
                case 1090594823:
                    if (optString3.equals("release")) {
                        i2 = 2;
                        break;
                    }
                case 1559690845:
                    if (optString3.equals("develop")) {
                        i2 = 0;
                        break;
                    }
                default:
                    i2 = -1;
                    break;
            }
            switch (i2) {
                case 0:
                    i3 = 1;
                    break;
                case 1:
                    i3 = 2;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (!(i4 == 1 || i4 == 2)) {
                i3 = 0;
            }
            int optInt = jSONObject.optInt("sourcetype", 0);
            e.a aVar = new e.a();
            aVar.scene = jSONObject.optInt("scene", 0);
            aVar.fnp = jSONObject.optString("sceneNote");
            aVar.fIs = jSONObject.optInt("preScene", 0);
            aVar.fIt = jSONObject.optString("preSceneNote");
            e.a(jVar, optString, i3, optInt, optString2, aVar, optJSONObject, new b(this) {
                final /* synthetic */ d jon;

                public final void cO(boolean z) {
                    jVar.E(i, this.jon.e(z ? "ok" : "fail", null));
                }
            });
        }
    }
}
