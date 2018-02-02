package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class h extends c {
    public static final int CTRL_INDEX = 300;
    public static final String NAME = "updateHTMLWebView";

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        if (!(view instanceof a)) {
            return false;
        }
        String optString = jSONObject.optString("src", "about:blank");
        x.i("URL", optString);
        ((a) view).juE.loadUrl(optString);
        return true;
    }

    protected final int i(JSONObject jSONObject) {
        return jSONObject.getInt("htmlId");
    }
}
