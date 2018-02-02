package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.view.View;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.appbrand.jsapi.base.c {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "updateContainer";

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        if (!(view instanceof AppBrandNativeContainerView)) {
            return false;
        }
        int a = f.a(jSONObject, "contentOffsetLeft", 0);
        int a2 = f.a(jSONObject, "contentOffsetTop", 0);
        AppBrandNativeContainerView appBrandNativeContainerView = (AppBrandNativeContainerView) view;
        try {
            appBrandNativeContainerView.setVisibility(jSONObject.getBoolean("visible") ? 0 : 4);
        } catch (JSONException e) {
        }
        appBrandNativeContainerView.setPadding(-a, -a2, 0, 0);
        return true;
    }

    protected final int i(JSONObject jSONObject) {
        return jSONObject.getInt("containerId");
    }
}
