package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONObject;

public final class e extends c {
    private static final int CTRL_INDEX = 363;
    public static final String NAME = "operateLivePusher";

    protected final int i(JSONObject jSONObject) {
        return jSONObject.optInt("livePusherId");
    }

    protected final boolean afN() {
        return true;
    }

    protected final boolean a(p pVar, int i, View view, JSONObject jSONObject, f fVar) {
        x.i("MicroMsg.JsApiOperateLivePusher", "onUpdateView : livePusherId=%d", new Object[]{Integer.valueOf(i)});
        if (view instanceof CoverViewContainer) {
            View w = ((CoverViewContainer) view).w(View.class);
            if (w instanceof AppBrandLivePusherView) {
                AppBrandLivePusherView appBrandLivePusherView = (AppBrandLivePusherView) w;
                String optString = jSONObject.optString(DownloadSettingTable$Columns.TYPE);
                x.i("MicroMsg.JsApiOperateLivePusher", "onUpdateView operateType=%s", new Object[]{optString});
                if (optString.equalsIgnoreCase("snapshot")) {
                    appBrandLivePusherView.jkT.jlD = new 1(this, fVar, pVar);
                    if (!appBrandLivePusherView.sr("snapshot")) {
                        fVar.sj(e("fail", null));
                    }
                } else if (appBrandLivePusherView.sr(optString)) {
                    fVar.sj(e("ok", null));
                } else {
                    fVar.sj(e("fail", null));
                }
                return super.a(pVar, i, view, jSONObject, fVar);
            }
            x.e("MicroMsg.JsApiOperateLivePusher", "targetView not AppBrandLivePusherView");
            return false;
        }
        x.w("MicroMsg.JsApiOperateLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
        return false;
    }
}
