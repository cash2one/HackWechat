package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.view.View;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "insertContainer";

    protected final View a(p pVar, JSONObject jSONObject) {
        View appBrandNativeContainerView = new AppBrandNativeContainerView(pVar.mContext);
        appBrandNativeContainerView.setBackgroundColor(0);
        boolean optBoolean = jSONObject.optBoolean("visible", true);
        boolean optBoolean2 = jSONObject.optBoolean("canFullScreenByChild", false);
        int a = f.a(jSONObject, "contentOffsetLeft", 0);
        int a2 = f.a(jSONObject, "contentOffsetTop", 0);
        appBrandNativeContainerView.setVisibility(optBoolean ? 0 : 4);
        appBrandNativeContainerView.setPadding(-a, -a2, 0, 0);
        appBrandNativeContainerView.setDuplicateParentStateEnabled(true);
        appBrandNativeContainerView.jjb = optBoolean2;
        return appBrandNativeContainerView;
    }

    protected final int i(JSONObject jSONObject) {
        return jSONObject.getInt("containerId");
    }

    protected final void a(p pVar, int i, View view, JSONObject jSONObject) {
        view.setOnTouchListener(new 1(this));
    }
}
