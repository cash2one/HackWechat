package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class g extends b {
    private static final int CTRL_INDEX = 362;
    public static final String NAME = "removeLivePusher";

    protected final int i(JSONObject jSONObject) {
        return jSONObject.optInt("livePusherId");
    }

    protected final boolean b(p pVar, int i, View view, JSONObject jSONObject) {
        super.b(pVar, i, view, jSONObject);
        x.i("MicroMsg.JsApiRemoveLivePusher", "onRemoveView livePusherId=%d", new Object[]{Integer.valueOf(i)});
        if (view instanceof CoverViewContainer) {
            View w = ((CoverViewContainer) view).w(View.class);
            if (w instanceof AppBrandLivePusherView) {
                ((AppBrandLivePusherView) w).sW();
                return true;
            }
            x.e("MicroMsg.JsApiRemoveLivePusher", "targetView not AppBrandLivePusherView");
            return false;
        }
        x.w("MicroMsg.JsApiRemoveLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
        return false;
    }
}
