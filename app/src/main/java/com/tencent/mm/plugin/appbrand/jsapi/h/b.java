package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.f.e;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 280;
    private static final String NAME = "getRegionData";
    private static final AtomicReference<String> jpv = new AtomicReference();

    public final void a(p pVar, JSONObject jSONObject, int i) {
        e.post(new 1(this, new WeakReference(pVar), i), "AppBrandJsApiGetRegionData");
    }
}
