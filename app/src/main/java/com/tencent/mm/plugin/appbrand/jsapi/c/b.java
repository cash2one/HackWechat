package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.view.View;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public class b extends c {
    public static final int CTRL_INDEX = 69;
    public static final String NAME = "drawCanvas";

    protected final int i(JSONObject jSONObject) {
        return jSONObject.getInt("canvasId");
    }

    protected final boolean a(p pVar, int i, View view, JSONObject jSONObject, f fVar) {
        if (view instanceof CoverViewContainer) {
            View w = ((CoverViewContainer) view).w(View.class);
            x.d("MicroMsg.JsApiDrawCanvas", "drawCanvas(id : %s)", new Object[]{Integer.valueOf(i)});
            if (w instanceof a) {
                long currentTimeMillis = System.currentTimeMillis();
                JSONArray optJSONArray = jSONObject.optJSONArray("actions");
                a aVar = (a) w;
                if (jSONObject.optBoolean("reserve")) {
                    aVar.b(optJSONArray, new 1(this, fVar));
                } else {
                    aVar.a(optJSONArray, new 2(this, fVar));
                }
                aVar.abh();
                x.v("MicroMsg.JsApiDrawCanvas", "post drawCanvas cost : %sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                return super.a(pVar, i, view, jSONObject, fVar);
            }
            x.i("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of AppBrandDrawableView.(%s)", new Object[]{Integer.valueOf(i)});
            return false;
        }
        x.i("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of CoverViewContainer.(%s)", new Object[]{Integer.valueOf(i)});
        return false;
    }

    protected final boolean afN() {
        return true;
    }
}
