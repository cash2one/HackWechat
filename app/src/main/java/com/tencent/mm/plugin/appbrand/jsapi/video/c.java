package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class c extends b {
    private static final int CTRL_INDEX = 7;
    public static final String NAME = "removeVideoPlayer";

    protected final int i(JSONObject jSONObject) {
        return jSONObject.optInt("videoPlayerId", 0);
    }

    protected final boolean b(p pVar, int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiRemoveVideoPlayer", "onRemoveView videoPlayerId=%d", new Object[]{Integer.valueOf(i)});
        if (view instanceof CoverViewContainer) {
            AppBrandVideoView appBrandVideoView = (AppBrandVideoView) ((CoverViewContainer) view).w(AppBrandVideoView.class);
            if (appBrandVideoView == null) {
                x.w("MicroMsg.JsApiRemoveVideoPlayer", "onRemoveView not AppBrandVideoView");
                return false;
            }
            ag.y(new 1(this, appBrandVideoView));
            super.b(pVar, i, view, jSONObject);
            return true;
        }
        x.w("MicroMsg.JsApiRemoveVideoPlayer", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
        return false;
    }
}
