package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.c;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends a {
    private static final int CTRL_INDEX = 119;
    private static final String NAME = "removeTextArea";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        try {
            c.runOnUiThread(new 1(this, new WeakReference(pVar), jSONObject.getInt("inputId"), i));
        } catch (JSONException e) {
            pVar.E(i, e("fail:invalid data", null));
        }
    }
}
