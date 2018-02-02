package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class j extends c {
    private static final int CTRL_INDEX = 331;
    public static final String NAME = "updateCamera";

    protected final int i(JSONObject jSONObject) {
        return jSONObject.optInt("cameraId");
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        boolean z = false;
        x.i("MicroMsg.JsApiUpdateCamera", "onUpdateView : cameraId=%d", Integer.valueOf(i));
        if (view instanceof CoverViewContainer) {
            AppBrandCameraView appBrandCameraView = (AppBrandCameraView) ((CoverViewContainer) view).w(AppBrandCameraView.class);
            if (appBrandCameraView == null) {
                x.w("MicroMsg.JsApiUpdateCamera", "the camera view(%s) is null", Integer.valueOf(i));
                return false;
            }
            int optInt = jSONObject.optInt("cameraId");
            String optString = jSONObject.optString("devicePosition", "back");
            String optString2 = jSONObject.optString("flash", "auto");
            boolean optBoolean = jSONObject.optBoolean("needOutput", false);
            appBrandCameraView.mAppId = pVar.mAppId;
            appBrandCameraView.T(optString, false);
            appBrandCameraView.sl(optString2);
            appBrandCameraView.jif = optBoolean;
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            int a = f.a(optJSONObject, "width", 0);
            int a2 = f.a(optJSONObject, "height", 0);
            x.d("MicroMsg.JsApiUpdateCamera", "onUpdateView cameraId: %d, devicePosition: %s,flash: %s,width： %d,height： %d", Integer.valueOf(optInt), optString, optString2, Integer.valueOf(a), Integer.valueOf(a2));
            if (!(a == 0 || a2 == 0)) {
                z = appBrandCameraView.bH(a, a2);
            }
            if (z) {
                appBrandCameraView.release();
                appBrandCameraView.initView();
            } else {
                appBrandCameraView.agc();
            }
            return true;
        }
        x.w("MicroMsg.JsApiUpdateCamera", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
        return false;
    }
}
