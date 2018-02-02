package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class f extends a {
    private static final int CTRL_INDEX = 329;
    public static final String NAME = "insertCamera";

    protected final View a(p pVar, JSONObject jSONObject) {
        Context context = pVar.mContext;
        AppBrandCameraView appBrandCameraView = new AppBrandCameraView(context);
        int optInt = jSONObject.optInt("cameraId");
        String optString = jSONObject.optString("devicePosition", "back");
        String optString2 = jSONObject.optString("flash", "auto");
        boolean optBoolean = jSONObject.optBoolean("needOutput", false);
        appBrandCameraView.mAppId = pVar.mAppId;
        appBrandCameraView.jia = pVar;
        appBrandCameraView.jib = optInt;
        appBrandCameraView.T(optString, true);
        appBrandCameraView.sl(optString2);
        appBrandCameraView.jif = optBoolean;
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        int a = com.tencent.mm.plugin.appbrand.p.f.a(optJSONObject, "width", 0);
        int a2 = com.tencent.mm.plugin.appbrand.p.f.a(optJSONObject, "height", 0);
        if (!(a == 0 || a2 == 0)) {
            appBrandCameraView.bH(a, a2);
        }
        x.d("MicroMsg.JsApiInsertCamera", "inflateView appId:%s,cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d", pVar.mAppId, Integer.valueOf(optInt), optString, optString2, Integer.valueOf(a), Integer.valueOf(a2));
        a(pVar, appBrandCameraView);
        return new CoverViewContainer(context, appBrandCameraView);
    }

    protected final int i(JSONObject jSONObject) {
        return jSONObject.optInt("cameraId");
    }

    protected final void a(final p pVar, final int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiInsertCamera", "onInsertView cameraId=%d", Integer.valueOf(i));
        final AppBrandCameraView appBrandCameraView = (AppBrandCameraView) ((CoverViewContainer) view).w(AppBrandCameraView.class);
        a afZ = a.a.afZ();
        afZ.jhY.put(Integer.valueOf(appBrandCameraView.jib), appBrandCameraView);
        pVar.a(appBrandCameraView);
        pVar.a(appBrandCameraView);
        pVar.a(appBrandCameraView);
        c.a(pVar.mAppId, new b(this) {
            final /* synthetic */ f jiy;

            public final void onDestroy() {
                pVar.b(appBrandCameraView);
                pVar.b(appBrandCameraView);
                pVar.b(appBrandCameraView);
                a.a.afZ().g(Integer.valueOf(i));
                c.b(pVar.mAppId, this);
            }
        });
        appBrandCameraView.jim = new b(this) {
            final /* synthetic */ f jiy;

            {
                this.jiy = r1;
            }
        };
    }

    final boolean a(p pVar, AppBrandCameraView appBrandCameraView) {
        com.tencent.mm.plugin.appbrand.a.a(pVar.mAppId, new 3(this, pVar, appBrandCameraView));
        Activity activity = (Activity) pVar.mContext;
        if (activity == null) {
            return false;
        }
        boolean a = com.tencent.mm.pluginsdk.g.a.a(activity, "android.permission.CAMERA", 16, "", "");
        a.a.afZ().jhW = a;
        if (!a) {
            return false;
        }
        boolean a2 = com.tencent.mm.pluginsdk.g.a.a(activity, "android.permission.RECORD_AUDIO", 18, "", "");
        a.a.afZ().jhX = a2;
        if (!a2) {
            return false;
        }
        com.tencent.mm.plugin.appbrand.a.oR(pVar.mAppId);
        appBrandCameraView.initView();
        return true;
    }
}
