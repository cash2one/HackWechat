package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class d extends a {
    private static final int CTRL_INDEX = 105;
    private static final String NAME = "showToast";
    ak iZb;
    View jqe;
    l.a jqf = null;

    static /* synthetic */ void bH(View view) {
        if (view != null) {
            view.setVisibility(8);
            if (ViewGroup.class.isInstance(view.getParent())) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        boolean z = true;
        p b = b(jVar);
        if (b == null) {
            x.w("MicroMsg.JsApiShowToast", "invoke JsApi JsApiShowToast failed, current page view is null.");
            jVar.E(i, e("fail", null));
            return;
        }
        x.d("MicroMsg.JsApiShowToast", "showToast:%s", new Object[]{jSONObject});
        int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 1500);
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString("icon", "success");
        String optString3 = jSONObject.optString(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE);
        boolean optBoolean = jSONObject.optBoolean("mask");
        if (!(bh.ov(optString2) && bh.ov(optString3))) {
            z = false;
        }
        if (this.jqf == null) {
            this.jqf = new 1(this, b);
        }
        l bS = l.bS(b.aeM());
        l.a aVar = this.jqf;
        if (!(aVar == null || bS.jXJ.contains(aVar))) {
            bS.jXJ.add(aVar);
        }
        ag.y(new 2(this, b, z, jVar, optInt, i, optBoolean, optString2, optString3, optString));
    }
}
